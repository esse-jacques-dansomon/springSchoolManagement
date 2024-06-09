package co.essejacques.springschoolmanagement.mobile.controller;

import co.essejacques.springschoolmanagement.data.entity.Attendance;
import co.essejacques.springschoolmanagement.data.projections.AttendanceDetailsProjection;
import co.essejacques.springschoolmanagement.services.interfaces.IAttendanceService;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/attendances")
@Tag(name = "Attendances", description = "Attendance API")

@AllArgsConstructor
public class AttendanceController {

    private final IAttendanceService attendanceService;

    @GetMapping
    public ResponseEntity<Page<AttendanceDetailsProjection>> getAttendances(
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "10") int size
    ) {
        Page<AttendanceDetailsProjection> attendances = attendanceService.getAll(PageRequest.of(page, size));
        return ResponseEntity.ok(attendances);
    }

    @PostMapping
    public ResponseEntity<Attendance> createAttendance(@RequestBody Attendance attendance) {
        Attendance createdAttendance = attendanceService.createAttendance(attendance);
        return ResponseEntity.ok(createdAttendance);
    }

    @PutMapping
    public ResponseEntity<Attendance> updateAttendance(@RequestBody Attendance attendance) {
        Attendance updatedAttendance = attendanceService.updateAttendance(attendance);
        return ResponseEntity.ok(updatedAttendance);
    }

    @DeleteMapping("/{attendanceId}")
    public ResponseEntity<Void> deleteAttendance(@PathVariable Long attendanceId) {
        attendanceService.deleteAttendance(attendanceId);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/{attendanceId}")
    public ResponseEntity<Optional<AttendanceDetailsProjection>> getAttendance(@PathVariable Long attendanceId) {
        Optional<AttendanceDetailsProjection> attendance = attendanceService.getAttendance(attendanceId);
        return ResponseEntity.ok(attendance);
    }

    @GetMapping("/sessions/{sessionId}")
    public ResponseEntity<List<AttendanceDetailsProjection>> getAttendanceBySession(@PathVariable Long sessionId) {
        List<AttendanceDetailsProjection> attendances = attendanceService.getAttendanceBySession(sessionId);
        return ResponseEntity.ok(attendances);
    }

    @GetMapping("/students/{studentId}")
    public ResponseEntity<List<AttendanceDetailsProjection>> getAttendanceByStudent(@PathVariable Long studentId) {
        List<AttendanceDetailsProjection> attendances = attendanceService.getAttendanceByStudent(studentId);
        return ResponseEntity.ok(attendances);
    }

    @GetMapping("/courses/{courseId}")
    public ResponseEntity<List<AttendanceDetailsProjection>> getAttendanceByCourse(@PathVariable Long courseId) {
        List<AttendanceDetailsProjection> attendances = attendanceService.getAttendanceByCourse(courseId);
        return ResponseEntity.ok(attendances);
    }
}
