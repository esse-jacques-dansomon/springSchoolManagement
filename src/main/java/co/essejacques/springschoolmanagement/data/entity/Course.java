package co.essejacques.springschoolmanagement.data.entity;

import co.essejacques.springschoolmanagement.data.enums.CourseStatus;
import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.util.Date;
import java.util.Set;

@Data
@Entity
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Course {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "module", nullable = false)
    private String module;

    @Column(name = "professor", nullable = false)
    private String professor;

    @Column(name = "icon", nullable = true)
    private String icon ;

    @OneToMany(mappedBy = "course")
    private Set<Session> sessions;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    private ClassRoom classRoom;

    @Enumerated(EnumType.STRING)
    private CourseStatus status;

    @CreationTimestamp
    @Column(updatable = false, name = "created_at")
    private Date createdAt;

    @UpdateTimestamp
    @Column(name = "updated_at")
    private Date updatedAt;
}