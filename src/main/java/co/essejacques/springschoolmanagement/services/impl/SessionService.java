package co.essejacques.springschoolmanagement.services.impl;

import co.essejacques.springschoolmanagement.data.entity.Session;
import co.essejacques.springschoolmanagement.data.enums.CourseStatus;
import co.essejacques.springschoolmanagement.data.projections.SessionDetailsProjection;
import co.essejacques.springschoolmanagement.data.repository.SeanceRepository;
import co.essejacques.springschoolmanagement.services.interfaces.ISessionService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
@RequiredArgsConstructor
public class SessionService implements ISessionService {
    private final SeanceRepository seanceRepository;

    @Override
    public List<SessionDetailsProjection> getSeances() {
        return seanceRepository.findAllProjected();
    }

    @Override
    public List<SessionDetailsProjection> getSeancesByStatus(CourseStatus courseStatus) {
        return seanceRepository.findAllByStatus(courseStatus);
    }

    @Override
    public Session getSeanceById(Long id) {
        return seanceRepository.findById(id).orElseThrow(() -> new RuntimeException("Session not found"));
    }

    @Override
    public Session saveSeance(Session session) {
        return seanceRepository.save(session);
    }

    @Override
    public void deleteSeance(Long id) {
        seanceRepository.deleteById(id);
    }

    @Override
    public Session updateSeance(Long id, Session session) {
        return seanceRepository.save(session);
    }

    /**
     * @param id
     * @return
     */
    @Override
    public List<SessionDetailsProjection> getSessionsByClassroomAndToday(Long id) {
        return seanceRepository.findAllByCourse_ClassRoom_IdAndDateIs(id, LocalDate.now());
    }

    /**
     * @param id
     * @return
     */
    @Override
    public List<SessionDetailsProjection> getSessionsByClassroom(Long id) {
        return seanceRepository.findAllByCourse_ClassRoom_Id(id);
    }
}
