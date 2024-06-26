package co.essejacques.springschoolmanagement.data.entity;

import co.essejacques.springschoolmanagement.data.enums.AttendanceStatus;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.time.LocalDateTime;
import java.util.Date;

@Getter
@Setter
@Entity
public class Attendance {
    @Id
    @Column(name = "id", nullable = false)
    private Long id;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "session_id")
    private Session session;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "sutdent_id")
    private Student student;

    @Enumerated(EnumType.STRING)
    private AttendanceStatus status;

    private LocalDateTime date;

    @CreationTimestamp
    @Column(updatable = false, name = "created_at")
    private Date createdAt;

    @UpdateTimestamp
    @Column(name = "updated_at")
    private Date updatedAt;
}