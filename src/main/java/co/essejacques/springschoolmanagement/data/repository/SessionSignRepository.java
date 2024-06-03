package co.essejacques.springschoolmanagement.data.repository;

import co.essejacques.springschoolmanagement.data.entity.SessionSign;
import co.essejacques.springschoolmanagement.data.projections.SessionSignDetailsProjection;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import java.util.List;
import java.util.Optional;

public interface SessionSignRepository extends JpaRepository<SessionSign, Long>, JpaSpecificationExecutor<SessionSign> {
    List<SessionSignDetailsProjection> findBySessionId(Long sessionId);

    List<SessionSignDetailsProjection> findByStudentId(Long sessionStudentId);

    List<SessionSignDetailsProjection> findAllBySession_Course_Id(Long sessionCourseId);

    Optional<SessionSignDetailsProjection> findProjectedById(Long sessionSessionId);
}