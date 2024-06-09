package co.essejacques.springschoolmanagement.data.entity;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.util.Date;
import java.util.Set;

@Getter
@Setter
@Entity
@Table(name = "class_room")
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ClassRoom {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private String division;
    private String level;

    @OneToMany(mappedBy = "classRoom", orphanRemoval = true)
    private Set<Course> courses;

    @OneToMany(mappedBy = "classRoom")
    private Set<Student> students;

    @CreationTimestamp
    @Column(updatable = false, name = "created_at")
    private Date createdAt;

    @UpdateTimestamp
    @Column(name = "updated_at")
    private Date updatedAt;
}