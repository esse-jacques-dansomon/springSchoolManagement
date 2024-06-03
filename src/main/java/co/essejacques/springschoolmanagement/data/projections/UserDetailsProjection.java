package co.essejacques.springschoolmanagement.data.projections;

import java.util.List;


public interface UserDetailsProjection {
    Long getId();
    String getEmail();
    List<RoleProjection> getRoles = null;
}
