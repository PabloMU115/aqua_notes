package project.aqua_notes.Security;

import java.util.List;

import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import project.aqua_notes.Entities.UserEntity;
import project.aqua_notes.Repositories.UserRepository;

@Service
public class JpaUserDetailsService implements UserDetailsService {

    private final UserRepository userRepo;

    public JpaUserDetailsService(UserRepository userRepo) {
        this.userRepo = userRepo;
    }

    @Override
    public UserDetails loadUserByUsername(String userMail) throws UsernameNotFoundException {
        UserEntity u = userRepo.findByUserMail(userMail)
                .orElseThrow(() -> new UsernameNotFoundException("User not found"));

        if (!u.isVisible()) throw new UsernameNotFoundException("User disabled");
        if (!u.isVerified()) throw new UsernameNotFoundException("User not verified");

        return org.springframework.security.core.userdetails.User.builder()
                .username(u.getUserMail())
                .password(u.getPasswordHash())
                .authorities(List.of(new SimpleGrantedAuthority(u.getRole().getRoleType())))
                .build();
    }
}
