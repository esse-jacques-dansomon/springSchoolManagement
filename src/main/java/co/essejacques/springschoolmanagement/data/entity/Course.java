package co.essejacques.springschoolmanagement.data.entity;

import co.essejacques.springschoolmanagement.data.enums.CourseStatus;
import jakarta.persistence.*;
import lombok.*;

import java.util.List;
import java.util.Set;

@Data
@Entity
@Table(name = "course")
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

    @Column(name = "icon")
    private String icon = "https://img.freepik.com/free-vector/designer-girl-concept-illustration_114360-4455.jpg?w=2000";

    @OneToMany(mappedBy = "course")
    private Set<Seance> seances;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    private ClassRoom classRoom;

    @Enumerated(EnumType.STRING)
    private CourseStatus status;
}