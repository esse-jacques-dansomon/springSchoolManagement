package co.essejacques.springschoolmanagement.services.interfaces;

import co.essejacques.springschoolmanagement.data.entity.Session;
import co.essejacques.springschoolmanagement.data.enums.CourseStatus;
import co.essejacques.springschoolmanagement.data.projections.SessionDetailsProjection;

import java.util.List;

public interface ISessionService {

    List<SessionDetailsProjection> getSeances();
    List<SessionDetailsProjection> getSeancesByStatus(CourseStatus courseStatus);
    Session getSeanceById(Long id);
    Session saveSeance(Session session);
    void deleteSeance(Long id);
    Session updateSeance(Long id, Session session);
    List<SessionDetailsProjection> getSessionsByClassroomAndToday(Long id);
    List<SessionDetailsProjection> getSessionsByClassroom(Long id);
}
