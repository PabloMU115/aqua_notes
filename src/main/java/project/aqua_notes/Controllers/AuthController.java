package project.aqua_notes.Controllers;

import java.util.Map;

import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.oauth2.jwt.Jwt;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import project.aqua_notes.Entities.RoleEntity;
import project.aqua_notes.Entities.UserEntity;
import project.aqua_notes.Repositories.RoleRepository;
import project.aqua_notes.Repositories.UserRepository;
import project.aqua_notes.Security.JwtService;

@RestController
@RequestMapping("/api/auth")
public class AuthController {

    private final AuthenticationManager authManager;
    private final JwtService jwtService;

    private final UserRepository userRepo;
    private final RoleRepository roleRepo;
    private final PasswordEncoder encoder;

    public AuthController(AuthenticationManager authManager, JwtService jwtService,
                          UserRepository userRepo, RoleRepository roleRepo, PasswordEncoder encoder) {
        this.authManager = authManager;
        this.jwtService = jwtService;
        this.userRepo = userRepo;
        this.roleRepo = roleRepo;
        this.encoder = encoder;
    }

    public record LoginRequest(String userMail, String password) {}
    public record AuthResponse(String accessToken) {}

    @PostMapping("/login")
    public ResponseEntity<AuthResponse> login(@RequestBody LoginRequest req) {
        Authentication auth = authManager.authenticate(
                new UsernamePasswordAuthenticationToken(req.userMail(), req.password())
        );
        String token = jwtService.generateAccessToken((UserDetails) auth.getPrincipal());
        return ResponseEntity.ok(new AuthResponse(token));
    }

    // Turn this into a DTO later
    public record RegisterRequest(String userName, String userMail, String password) {}

    @PostMapping("/register")
    public ResponseEntity<?> register(@RequestBody RegisterRequest req) {
        if (userRepo.existsByUserMail(req.userMail())) {
            return ResponseEntity.badRequest().body("Email already in use");
        }

        RoleEntity roleUser = roleRepo.findByRoleType("ROLE_USER")
                .orElseThrow(() -> new RuntimeException("ROLE_USER not found in DB"));

        UserEntity u = new UserEntity();
        u.setUserName(req.userName());
        u.setUserMail(req.userMail());
        u.setPasswordHash(encoder.encode(req.password()));
        u.setRole(roleUser);
        u.setVerified(true);
        u.setVisible(true);

        userRepo.save(u);
        return ResponseEntity.ok().build();
    }

    @GetMapping("/me")
    public Map<String, Object> me(@AuthenticationPrincipal Jwt jwt) {
    return Map.of(
        "sub", jwt.getSubject(),
        "roles", jwt.getClaimAsStringList("roles"),
        "iss", jwt.getClaimAsString("iss"),
        "exp", jwt.getExpiresAt()
    );
    }
}
