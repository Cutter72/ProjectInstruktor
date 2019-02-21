package pl.project.instruktor.model;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.time.LocalDateTime;

@Entity
@Data
@NoArgsConstructor
@Table(name = "messages")
@ToString(exclude = {"recipientUser", "senderUser"})
public class Message {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Size(max = 100)
    @NotBlank
    private String title;
    @Size(max = 1000)
    private String messageText;
    @OneToOne
    private User recipientUser;
    @OneToOne
    private User senderUser;
    @ManyToOne
    private Message parent;
    private LocalDateTime created;

    @PrePersist
    public void prePersist() {
        created = LocalDateTime.now();
    }
}
