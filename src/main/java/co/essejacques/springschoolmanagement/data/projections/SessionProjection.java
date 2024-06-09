package co.essejacques.springschoolmanagement.data.projections;

import co.essejacques.springschoolmanagement.data.enums.CourseStatus;

import java.time.LocalDate;
import java.time.LocalDateTime;

public interface SessionProjection {
    Long getId();
    LocalDate getDate();
    Integer getNumberOfHours();
    LocalDateTime getStartTime();
    LocalDateTime getEndTime();
    CourseStatus getstatus();
}
