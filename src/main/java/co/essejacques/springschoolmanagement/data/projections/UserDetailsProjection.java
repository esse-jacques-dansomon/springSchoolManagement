package co.essejacques.springschoolmanagement.data.projections;

import java.util.List;


public interface UserDetailsProjection  extends UserProjection{
    Long getId();
    String getEmail();
    List<RoleProjection> getRoles() ;
}
