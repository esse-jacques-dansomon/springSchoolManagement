package co.essejacques.springschoolmanagement.data.entity;

import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.SuperBuilder;

import java.util.Set;


@Entity
@Getter
@Setter
@ToString
@RequiredArgsConstructor
@SuperBuilder
@AllArgsConstructor
public class Student extends User {

    private String firstName;
    private String lastName;
    private String address;
    private String registrationNumber;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @ToString.Exclude
    private ClassRoom classRoom;


    @OneToMany(fetch = FetchType.LAZY, mappedBy = "student", cascade = CascadeType.ALL)
    @ToString.Exclude
    private Set<Attendance> attendances;

}
