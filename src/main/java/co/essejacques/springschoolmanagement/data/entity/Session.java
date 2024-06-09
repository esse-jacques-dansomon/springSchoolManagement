package co.essejacques.springschoolmanagement.data.entity;

import co.essejacques.springschoolmanagement.data.enums.CourseStatus;
import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.Set;


@Getter
@Setter
@Entity
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Session {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private LocalDate date;
    private LocalDateTime startTime;
    private LocalDateTime endTime;
    private Integer numberOfHours = 4;

    @ManyToOne(cascade = CascadeType.MERGE)
    @JoinColumn(name = "course_id")
    private Course course;

    @Enumerated(EnumType.STRING)
    private CourseStatus status;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "session", cascade = CascadeType.ALL)
    @ToString.Exclude
    private Set<Attendance> attendances;

    @CreationTimestamp
    @Column(updatable = false, name = "created_at")
    private Date createdAt;

    @UpdateTimestamp
    @Column(name = "updated_at")
    private Date updatedAt;

    public void addAttendance(Attendance attendance) {
        this.attendances.add(attendance);
        attendance.setSession(this);
    }

    public void removeAttendance(Attendance attendance) {
        this.attendances.remove(attendance);
        attendance.setSession(null);
    }

    public void setCourse(Course course) {
        this.course = course;
        course.addSession(this);
    }


}