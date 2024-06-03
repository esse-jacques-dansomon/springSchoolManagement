package co.essejacques.springschoolmanagement.services.impl;

import co.essejacques.springschoolmanagement.data.entity.SessionSign;
import co.essejacques.springschoolmanagement.data.projections.SessionSignDetailsProjection;
import co.essejacques.springschoolmanagement.data.repository.SessionSignRepository;
import co.essejacques.springschoolmanagement.services.interfaces.ISessionSignService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class SessionSignService  implements ISessionSignService {
    private final SessionSignRepository sessionSignRepository;

    /**
     * @param sessionSign
     * @return
     */
    @Override
    public SessionSign createSessionSign(SessionSign sessionSign) {
        return this.sessionSignRepository.save(sessionSign);
    }

    /**
     * @param sessionSign
     * @return
     */
    @Override
    public SessionSign updateSessionSign(SessionSign sessionSign) {
        return  this.sessionSignRepository.save(sessionSign);
    }

    /**
     * @param sessionSignId
     */
    @Override
    public void deleteSessionSign(Long sessionSignId) {
        this.sessionSignRepository.deleteById(sessionSignId);
    }

    /**
     * @param sessionSessionId
     * @return
     */
    @Override
    public Optional<SessionSignDetailsProjection> getSessionSign(Long sessionSessionId) {
        return this.sessionSignRepository.findProjectedById(sessionSessionId);
    }

    /**
     * @param sessionId
     * @return
     */
    @Override
    public List<SessionSignDetailsProjection> getSessionSignBySession(Long sessionId) {
        return this.sessionSignRepository.findBySessionId(sessionId);
    }

    /**
     * @param sessionStudentId
     * @return
     */
    @Override
    public List<SessionSignDetailsProjection> getSessionSignByStudent(Long sessionStudentId) {
        return this.sessionSignRepository.findByStudentId(sessionStudentId);
    }

    /**
     * @param sessionCourseId
     * @return
     */
    @Override
    public List<SessionSignDetailsProjection> getSessionSignByCourse(Long sessionCourseId) {
        return this.sessionSignRepository.findAllBySession_Course_Id(sessionCourseId);
    }
}
