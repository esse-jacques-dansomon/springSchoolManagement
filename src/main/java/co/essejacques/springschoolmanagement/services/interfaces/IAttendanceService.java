package co.essejacques.springschoolmanagement.services.interfaces;

import co.essejacques.springschoolmanagement.data.entity.Attendance;
import co.essejacques.springschoolmanagement.data.projections.AttendanceDetailsProjection;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;

import java.util.List;
import java.util.Optional;

public interface IAttendanceService {
    Attendance createAttendance(Attendance attendance);
    Attendance updateAttendance(Attendance attendance);
    void deleteAttendance(Long attendanceId);
    Optional<AttendanceDetailsProjection> getAttendance(Long sessionSessionId);
    List<AttendanceDetailsProjection> getAttendanceBySession(Long sessionId);
    List<AttendanceDetailsProjection>  getAttendanceByStudent(Long sessionStudentId);
    List<AttendanceDetailsProjection>  getAttendanceByCourse(Long sessionCourseId);
    Page<AttendanceDetailsProjection> getAll(PageRequest pageRequest);
}
