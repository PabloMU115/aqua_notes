package project.aqua_notes.Entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "users")
public class User {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long userId;

    @Column(nullable = false, length = 100)
    private String userName;

    @Column(unique = true, nullable = false, length = 150)
    private String userMail;

    @Column(length = 100)
    private String userCountry;

    @Column(length = 100)
    private String userProvince;

    @Column(length = 100)
    private String userCity;

    @Column(length = 20)
    private String userPhone;

    @ManyToOne
    @JoinColumn(name = "role_id", nullable = false)
    private Role role;

    @Column(nullable = false)
    private boolean verified;

    @Column(nullable = false, length = 255)
    private String passwordHash;
}