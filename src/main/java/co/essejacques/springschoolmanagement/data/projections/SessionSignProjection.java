package co.essejacques.springschoolmanagement.data.projections;

import co.essejacques.springschoolmanagement.data.enums.SessionSignStatus;

import java.time.LocalDateTime;

public interface SessionSignProjection {
    Long getId();
    LocalDateTime getDate();
    SessionSignStatus getStatus();
}
