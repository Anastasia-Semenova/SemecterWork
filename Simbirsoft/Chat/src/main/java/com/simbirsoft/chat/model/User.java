package com.simbirsoft.chat.model;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.context.annotation.Primary;

import javax.persistence.*;
import java.io.Serializable;


@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "chat_user")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String firstName;
    private String lastName;
    private String login;
    private String email;
    private String password;
    @Transient
    private String confirmPassword;

    @Enumerated(EnumType.STRING)
    private State state;

    public enum State {
        CONFIRMED, NOT_CONFIRMED, BANNED
    }

    @Enumerated(EnumType.STRING)
    private Role role;

    public enum Role {
        ROLE_USER, ROLE_ADMIN, ROLE_MODERATOR
    }

    public boolean isBanned() {
        return this.state == State.BANNED;
    }

    public boolean isActive() {
        return isConfirmed();
    }

    public boolean isConfirmed() {
        return this.state == State.CONFIRMED;
    }

    public boolean isAdmin() {
        return this.role == Role.ROLE_ADMIN;
    }

    public boolean isModerator() {
        return this.role == Role.ROLE_MODERATOR;
    }
}

