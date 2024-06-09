package co.essejacques.springschoolmanagement.data.projections;

import co.essejacques.springschoolmanagement.data.enums.CourseStatus;

import java.time.LocalDate;
import java.time.LocalDateTime;

public interface SessionDetailsProjection extends SessionProjection {
    CourseProjection getCourse();
}
