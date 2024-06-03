package co.essejacques.springschoolmanagement.data.projections;

import java.util.Set;

public interface StudentProjection {
    Long getId();
    String getEmail();
    String getFirstName();
    String getLastName();
    String getAddress();
    String getRegistrationNumber();

}
