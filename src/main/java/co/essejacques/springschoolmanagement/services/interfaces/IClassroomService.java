package co.essejacques.springschoolmanagement.services.interfaces;

import co.essejacques.springschoolmanagement.data.entity.ClassRoom;
import co.essejacques.springschoolmanagement.data.projections.ClassRoomDetailsProjection;
import co.essejacques.springschoolmanagement.data.projections.ClassRoomProjection;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface IClassroomService {
    List<ClassRoom> getAllClassRooms();
    ClassRoom getCourseById(Long id);
    ClassRoomDetailsProjection getCourseDetailsById(Long id);
    ClassRoom saveClassRoom(ClassRoom ClassRoom);
    void deleteCourse(Long id);
    ClassRoom updateClassRoom(Long id, ClassRoom ClassRoom);
    Page<ClassRoomProjection> findAll(Pageable pageable);
}
