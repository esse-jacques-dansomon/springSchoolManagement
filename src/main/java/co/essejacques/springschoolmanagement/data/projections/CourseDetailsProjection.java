package co.essejacques.springschoolmanagement.data.projections;

import java.util.Set;

public interface CourseDetailsProjection extends CourseProjection {
    Set<SessionProjection> getSessions();
}
