package co.essejacques.springschoolmanagement.services.impl;

import co.essejacques.springschoolmanagement.data.entity.Session;
import co.essejacques.springschoolmanagement.data.enums.CourseStatus;
import co.essejacques.springschoolmanagement.data.projections.SessionDetailsProjection;
import co.essejacques.springschoolmanagement.data.repository.SessionRepository;
import co.essejacques.springschoolmanagement.services.interfaces.ISessionService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
@RequiredArgsConstructor
public class SessionService implements ISessionService {

    private final SessionRepository sessionRepository;

    @Override
    public Page<SessionDetailsProjection> getSessions(PageRequest pageRequest) {
        return sessionRepository.findPagedProjectedBy(pageRequest);
    }

    @Override
    public List<SessionDetailsProjection> getSessionsByStatus(CourseStatus courseStatus) {
        return sessionRepository.findAllByStatus(courseStatus);
    }

    @Override
    public Session getSessionById(Long id) {
        return sessionRepository.findById(id).orElseThrow(() -> new RuntimeException("Session not found"));
    }

    @Override
    public Session saveSession(Session session) {
        return sessionRepository.save(session);
    }

    @Override
    public void deleteSession(Long id) {
        sessionRepository.deleteById(id);
    }

    @Override
    public Session updateSession(Long id, Session session) {
        return sessionRepository.save(session);
    }

    /**
     * @param id
     * @return
     */
    @Override
    public List<SessionDetailsProjection> getSessionsByClassroomAndToday(Long id) {
        return sessionRepository.findAllByCourse_ClassRoom_IdAndDateIs(id, LocalDate.now());
    }

    /**
     * @param id
     * @return
     */
    @Override
    public List<SessionDetailsProjection> getSessionsByClassroom(Long id) {
        return sessionRepository.findAllByCourse_ClassRoom_Id(id);
    }
}
