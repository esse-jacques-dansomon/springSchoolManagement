package co.essejacques.springschoolmanagement.mobile.controller;


import co.essejacques.springschoolmanagement.data.entity.ClassRoom;
import co.essejacques.springschoolmanagement.data.projections.ClassRoomDetailsProjection;
import co.essejacques.springschoolmanagement.mobile.dtos.IClassroom;
import co.essejacques.springschoolmanagement.services.interfaces.IClassroomService;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.web.bind.annotation.*;



@RequiredArgsConstructor
@RequestMapping("/classrooms")
@RestController
@Tag(name = "Classrooms", description = "ClassRooms API")
public class ClassRoomController {


    private final IClassroomService classroomService;


    @PostMapping("")
    public ClassRoom saveCourse(ClassRoom ClassRoom)  {
        return this.classroomService.saveClassRoom(ClassRoom);
    }

    @GetMapping()
    public Page<IClassroom> getCourses(
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "10") int size
    )  {
        return this.classroomService.findAll(
                PageRequest.of(page, size)) ;
    }
    

    @GetMapping("/{id}")
    public ClassRoomDetailsProjection getCourseById(@PathVariable Long id)  {
        return this.classroomService.getCourseDetailsById(id);
    }



}
