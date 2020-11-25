package com.parking.example.parking.models;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.util.List;

@Entity
@Table(name = "users", uniqueConstraints = {
        @UniqueConstraint(columnNames = "username"),
        @UniqueConstraint(columnNames = "email")
})
public class User {

    @Getter
    @Setter
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Getter
    @Setter
    @NotBlank
    @Size(max = 60)
    private String username;

    @Getter
    @Setter
    @NotBlank
    @Size(max = 60)
    private String email;

    @Getter
    @Setter
    @NotBlank
    @Size(max = 120)
    private String password;

//    @Getter
//    @Setter
//    @ManyToMany(fetch = FetchType.LAZY)
//    @JoinTable(name = "user_roles",
//            joinColumns = @JoinColumn(name = "user_id"),
//            inverseJoinColumns = @JoinColumn(name = "role_id"))
//    private Set<Role> roles = new HashSet<>();

    public User(@NotBlank @Size(max = 60) String username, @NotBlank @Size(max = 60) String email, @NotBlank @Size(max = 120) String password) {
        this.username = username;
        this.email = email;
        this.password = password;
    }

    public User() {
        super();
    }

    @Getter
    @Setter
    @OneToMany(fetch = FetchType.EAGER, targetEntity = Client.class, mappedBy = "user")
    private List<Client> clientProfiles;
}