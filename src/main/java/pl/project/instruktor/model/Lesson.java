package pl.project.instruktor.model;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Data
@NoArgsConstructor
@Table(name = "lessons")
public class Lesson {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @OneToOne
    private User instructor;
    @OneToOne
    private User student;
    private LocalDateTime startTime;
    private LocalDateTime endTime;
    @OneToOne
    private Category category;
    private boolean reservation;
}
