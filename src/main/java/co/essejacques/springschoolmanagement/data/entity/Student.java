package co.essejacques.springschoolmanagement.data.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.ManyToOne;
import lombok.*;
import lombok.experimental.SuperBuilder;
import org.hibernate.proxy.HibernateProxy;

import java.util.Objects;

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

}
