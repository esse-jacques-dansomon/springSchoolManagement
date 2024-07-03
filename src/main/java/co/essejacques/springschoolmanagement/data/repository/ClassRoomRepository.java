package co.essejacques.springschoolmanagement.data.repository;

import co.essejacques.springschoolmanagement.data.entity.ClassRoom;
import co.essejacques.springschoolmanagement.data.projections.ClassRoomDetailsProjection;
import co.essejacques.springschoolmanagement.data.projections.ClassRoomProjection;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.Optional;

public interface ClassRoomRepository extends JpaRepository<ClassRoom, Long> {
    Page<ClassRoomProjection> findPagedProjectedBy(Pageable pageable);

    Optional<ClassRoomDetailsProjection> findProjectedById(Long id);
}