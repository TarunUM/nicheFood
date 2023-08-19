package com.example.nichefood.models.users;

import com.example.nichefood.models.enums.Role;
import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.Pattern;
import lombok.*;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.Date;
import java.util.List;
import java.util.UUID;

@Data
@Builder
@AllArgsConstructor
@RequiredArgsConstructor
@Entity
@Table
public class User implements UserDetails {
    @Id
    @GeneratedValue(generator = "uuid2")
    @Column(
            columnDefinition = "BINARY(16)",
            nullable = false, updatable = false
    )
    private UUID id;

    @Column(unique = true, nullable = false)
    @Email
    private String email;

    @Column(nullable = false)
    @Max(16)
    @Min(8)
    @Pattern(regexp = "/^(?=.*\\d)(?=.*[a-z])(?=.*[A-Z])(?=.*[a-zA-Z]).{8,}$/gm")
    private String password;

    @Column(nullable = false)
    private String name;

    @Pattern(regexp = "^(\\+91|0|)\\d{9,10}$")
    private String phone;

    @Enumerated(EnumType.STRING)
    private Role role = Role.ADMIN;

    @Column(nullable = false, updatable = false, columnDefinition = "TIMESTAMP DEFAULT CURRENT_TIMESTAMP")
    private Date createdAt;

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return List.of(new SimpleGrantedAuthority(role.name()));
    }

    @Override
    public String getUsername() {
        return this.email;
    }

    @Override
    public boolean isAccountNonExpired() {
        return false;
    }

    @Override
    public boolean isAccountNonLocked() {
        return false;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return false;
    }

    @Override
    public boolean isEnabled() {
        return false;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", email='" + email + '\'' +
                ", password='" + password + '\'' +
                ", name='" + name + '\'' +
                ", phone='" + phone + '\'' +
                ", role=" + role +
                ", createdAt=" + createdAt +
                '}';
    }
}
