package pl.project.instruktor.model;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.hibernate.validator.constraints.NotBlank;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.Size;
import java.time.LocalDateTime;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
@Table(name = "users")
@ToString(exclude = {"cities", "opinions", "offers", "messages"})
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank
    @Size(min = 2, max = 50)
    private String firstName;
    @NotBlank
    @Size(min = 2, max = 50)
    private String lastName;

    private LocalDateTime created;

    @PrePersist
    public void prePersist() {
        created = LocalDateTime.now();
    }

    private LocalDateTime lastActivity;

    private String description;

    @NotBlank
    @Email
    private String email;

    @NotBlank
    private String password;

    private Long phoneNumber;

    private String videoLink;

    private String facebookLink;

    @OneToMany
    private List<City> cities;

    @OneToMany
    private List<Opinion> opinions;

    @OneToMany
    private List<Offer> offers;

}
