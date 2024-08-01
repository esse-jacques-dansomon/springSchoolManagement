package co.essejacques.springschoolmanagement.services.interfaces;

import co.essejacques.springschoolmanagement.data.entity.Session;
import co.essejacques.springschoolmanagement.data.enums.CourseStatus;
import co.essejacques.springschoolmanagement.data.projections.SessionDetailsProjection;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;

import java.sql.Date;
import java.time.LocalDate;
import java.util.List;

public interface ISessionService {

    Page<SessionDetailsProjection> getSessions(PageRequest pageRequest);
    List<SessionDetailsProjection> getSessionsByStatus(CourseStatus courseStatus);
    Session getSessionById(Long id);
    Session saveSession(Session session);
    void deleteSession(Long id);
    Session updateSession(Long id, Session session);
    List<SessionDetailsProjection> getSessionsByClassroomAndToday(Long id);
    List<SessionDetailsProjection> getSessionsByClassroom(Long id);
    List<SessionDetailsProjection> getSessionsByClassroomAndDate(Long id, LocalDate date);
}
