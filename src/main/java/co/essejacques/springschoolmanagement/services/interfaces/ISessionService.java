package co.essejacques.springschoolmanagement.services.interfaces;

import co.essejacques.springschoolmanagement.data.entity.Session;
import co.essejacques.springschoolmanagement.data.enums.CourseStatus;
import co.essejacques.springschoolmanagement.data.projections.SessionDetailsProjection;

import java.util.List;

public interface ISessionService {

    List<SessionDetailsProjection> getSessions();
    List<SessionDetailsProjection> getSessionsByStatus(CourseStatus courseStatus);
    Session getSessionById(Long id);
    Session saveSession(Session session);
    void deleteSession(Long id);
    Session updateSession(Long id, Session session);
    List<SessionDetailsProjection> getSessionsByClassroomAndToday(Long id);
    List<SessionDetailsProjection> getSessionsByClassroom(Long id);
}
