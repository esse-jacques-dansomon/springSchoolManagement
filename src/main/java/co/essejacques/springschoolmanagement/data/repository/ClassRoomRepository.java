package co.essejacques.springschoolmanagement.data.repository;

import co.essejacques.springschoolmanagement.data.entity.ClassRoom;
import co.essejacques.springschoolmanagement.data.projections.ClassRoomDetailsProjection;
import co.essejacques.springschoolmanagement.data.projections.ClassRoomProjection;
import co.essejacques.springschoolmanagement.mobile.dtos.IClassroom;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;


public interface ClassRoomRepository extends JpaRepository<ClassRoom, Long> {

    @Query(value = "SELECT c.id AS id, c.name AS name, c.division AS division, c.level AS level FROM class_room c",
            countQuery = "SELECT COUNT(c) FROM class_room c",
            nativeQuery = true)
    Page<IClassroom> findAllProjectedBy(Pageable pageable);

    List<ClassRoomProjection> findAllByLevel(String level);

    Optional<ClassRoomDetailsProjection> findProjectedById(Long id);
}