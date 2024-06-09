package co.essejacques.springschoolmanagement.data.projections;

import co.essejacques.springschoolmanagement.data.enums.AttendanceStatus;

import java.time.LocalDateTime;

public interface AttendanceProjection {
    Long getId();
    LocalDateTime getDate();
    AttendanceStatus getStatus();
}
