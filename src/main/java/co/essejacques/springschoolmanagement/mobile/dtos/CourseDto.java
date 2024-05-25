package co.essejacques.springschoolmanagement.mobile.dtos;

import co.essejacques.springschoolmanagement.data.enums.CourseStatus;
import lombok.Value;

import java.io.Serializable;

/**
 * DTO for {@link co.essejacques.springschoolmanagement.data.entity.Course}
 */

public record CourseDto(Long id, String module, String professor, CourseStatus status) implements Serializable {
}