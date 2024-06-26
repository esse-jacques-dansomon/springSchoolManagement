package co.essejacques.springschoolmanagement.data.projections;

import java.util.Set;

public interface CourseProjection {
    Long getId();
    String getModule();
    String getProfessor();
    String getIcon();
    String getStatus();
}
