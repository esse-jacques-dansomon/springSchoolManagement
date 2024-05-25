package co.essejacques.springschoolmanagement.mobile.controller;


import co.essejacques.springschoolmanagement.data.entity.ClassRoom;
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
@Tag(name = "classroom", description = "ClassRoom API")
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
//            @RequestParam(defaultValue = "name,asc") String[] sort
    )  {

        return this.classroomService.findAll(
                PageRequest.of(page, size)) ;
//                PageRequest.of(page, size, Sort.by(sort))) ;
    }
    

    @GetMapping("/{id}")
    public ClassRoom getCourseById(@PathVariable Long id)  {
        return this.classroomService.getCourseById(id);
    }


}
