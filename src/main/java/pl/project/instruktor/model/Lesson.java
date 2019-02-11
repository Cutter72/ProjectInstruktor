package pl.project.instruktor.model;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import java.time.DayOfWeek;
import java.time.LocalDate;

@Entity
@Data
@NoArgsConstructor
@Table(name = "lessons")
public class Lesson {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @OneToOne
    private User user;
    private LocalDate date;
    private DayOfWeek dayOfWeek;
    @Min(0)
    @Max(23)
    private int startHour;
    @Min(0)
    @Max(59)
    private int startMinutes;
    @Min(0)
    @Max(23)
    private int endHour;
    @Min(0)
    @Max(59)
    private int endMinutes;
    @OneToOne
    private Category category;

    @PrePersist
    public void prePersist() {
        dayOfWeek = date.getDayOfWeek();
    }

}
