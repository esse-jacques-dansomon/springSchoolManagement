package co.essejacques.springschoolmanagement.services.interfaces;

import co.essejacques.springschoolmanagement.data.entity.SessionSign;
import co.essejacques.springschoolmanagement.data.projections.SessionSignDetailsProjection;

import java.util.List;
import java.util.Optional;

public interface ISessionSignService {
    SessionSign createSessionSign(SessionSign sessionSign);
    SessionSign updateSessionSign(SessionSign sessionSign);
    void deleteSessionSign(Long sessionSignId);
    Optional<SessionSignDetailsProjection> getSessionSign(Long sessionSessionId);
    List<SessionSignDetailsProjection> getSessionSignBySession(Long sessionId);
    List<SessionSignDetailsProjection>  getSessionSignByStudent(Long sessionStudentId);
    List<SessionSignDetailsProjection>  getSessionSignByCourse(Long sessionCourseId);
}
