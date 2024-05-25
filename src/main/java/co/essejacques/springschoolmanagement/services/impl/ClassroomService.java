package co.essejacques.springschoolmanagement.services.impl;

import co.essejacques.springschoolmanagement.data.entity.ClassRoom;
import co.essejacques.springschoolmanagement.data.repository.ClassRoomRepository;
import co.essejacques.springschoolmanagement.mobile.dtos.IClassroom;
import co.essejacques.springschoolmanagement.services.interfaces.IClassroomService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.crossstore.ChangeSetPersister;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.List;

@Service
public class ClassroomService implements IClassroomService {

    @Autowired
    private  ClassRoomRepository classRoomRepository;

    @Override
    public List<ClassRoom> getAllClassRooms() {
        return classRoomRepository.findAll();
    }

    @Override
    public ClassRoom getCourseById(Long id) {
        return classRoomRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Course not found"));

    }

    @Override
    public ClassRoom saveClassRoom(ClassRoom classRoom) {
        return this.classRoomRepository.save(classRoom);
    }

    @Override
    public void deleteCourse(Long id) {
        this.classRoomRepository.deleteById(id);
    }

    @Override
    public ClassRoom updateClassRoom(Long id, ClassRoom classRoom) {
        return this.classRoomRepository.save(classRoom);
    }

    @Override
    public Page<IClassroom> findAll(Pageable pageable) {
        return this.classRoomRepository.findAllProjectedBy(pageable);
    }

}
