package co.essejacques.springschoolmanagement.data.entity;

import jakarta.persistence.*;
import lombok.*;

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

    @OneToMany(mappedBy = "classRoom")
    private Set<Course> courses;





}