package co.essejacques.springschoolmanagement.data.projections;

import co.essejacques.springschoolmanagement.data.enums.CourseStatus;

import java.time.LocalDate;
import java.time.LocalDateTime;

public interface SeanceDetailsProjection {
    Long getId();
    LocalDate getDate();
    LocalDateTime getStartTime();
    LocalDateTime getEndTime();
    CourseStatus getstatus();
    CourseProjection getCourse();
}
