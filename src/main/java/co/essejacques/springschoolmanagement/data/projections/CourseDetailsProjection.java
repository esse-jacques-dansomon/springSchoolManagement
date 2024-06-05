package co.essejacques.springschoolmanagement.data.projections;

import java.util.Set;

public interface CourseDetailsProjection {
    Long getId();

    String getModule();

    String getProfessor();

    String getIcon();

    String getStatus();

    Set<SessionProjection> getSessions();
}
