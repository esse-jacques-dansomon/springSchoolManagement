package co.essejacques.springschoolmanagement.services.impl;

import co.essejacques.springschoolmanagement.data.entity.Attendance;
import co.essejacques.springschoolmanagement.data.projections.AttendanceDetailsProjection;
import co.essejacques.springschoolmanagement.data.repository.AttendanceRepository;
import co.essejacques.springschoolmanagement.services.interfaces.IAttendanceService;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class AttendanceService implements IAttendanceService {
    private final AttendanceRepository attendanceRepository;

    /**
     * @param attendance
     * @return
     */
    @Override
    public Attendance createAttendance(Attendance attendance) {
        return this.attendanceRepository.save(attendance);
    }

    /**
     * @param attendance
     * @return
     */
    @Override
    public Attendance updateAttendance(Attendance attendance) {
        return  this.attendanceRepository.save(attendance);
    }

    /**
     * @param attendanceId
     */
    @Override
    public void deleteAttendance(Long attendanceId) {
        this.attendanceRepository.deleteById(attendanceId);
    }

    /**
     * @param sessionSessionId
     * @return
     */
    @Override
    public Optional<AttendanceDetailsProjection> getAttendance(Long sessionSessionId) {
        return this.attendanceRepository.findProjectedById(sessionSessionId);
    }

    /**
     * @param sessionId
     * @return
     */
    @Override
    public List<AttendanceDetailsProjection> getAttendanceBySession(Long sessionId) {
        return this.attendanceRepository.findBySessionId(sessionId);
    }

    /**
     * @param sessionStudentId
     * @return
     */
    @Override
    public List<AttendanceDetailsProjection> getAttendanceByStudent(Long sessionStudentId) {
        return this.attendanceRepository.findByStudentId(sessionStudentId);
    }

    /**
     * @param sessionCourseId
     * @return
     */
    @Override
    public List<AttendanceDetailsProjection> getAttendanceByCourse(Long sessionCourseId) {
        return this.attendanceRepository.findAllBySession_Course_Id(sessionCourseId);
    }

    /**
     * @param pageRequest
     * @return
     */
    @Override
    public Page<AttendanceDetailsProjection> getAll(PageRequest pageRequest) {
        return this.attendanceRepository.findPagedProjectedBy(pageRequest);
    }
}
