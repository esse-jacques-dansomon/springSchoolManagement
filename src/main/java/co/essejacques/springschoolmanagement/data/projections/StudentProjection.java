package co.essejacques.springschoolmanagement.data.projections;

import java.util.Set;

public interface StudentProjection  extends  UserProjection{
    Long getId();
    String getEmail();
    String getFirstName();
    String getLastName();
    String getAddress();
    String getRegistrationNumber();
}
