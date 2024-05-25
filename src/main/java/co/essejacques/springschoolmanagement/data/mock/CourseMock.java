//package co.essejacques.springschoolmanagement.data.mock;
//
//import co.essejacques.springschoolmanagement.data.entity.ClassRoom;
//import co.essejacques.springschoolmanagement.data.entity.Course;
//import co.essejacques.springschoolmanagement.data.enums.CourseStatus;
//import co.essejacques.springschoolmanagement.data.repository.ClassRoomRepository;
//import co.essejacques.springschoolmanagement.data.repository.CourseRepository;
//import lombok.Builder;
//import lombok.RequiredArgsConstructor;
//import org.springframework.boot.CommandLineRunner;
//import org.springframework.core.annotation.Order;
//import org.springframework.stereotype.Component;
//
//import java.util.ArrayList;
//import java.util.List;
//
//@Component
//@Builder
//@RequiredArgsConstructor
//@Order(2)
//public class CourseMock  implements CommandLineRunner {
//    public final CourseRepository courseRepository;
//    private final ClassRoomRepository classRoomRepository ;
//    @Override
//    public void run(String... args) throws Exception {
//
//        List<ClassRoom> classRooms = this.classRoomRepository.findAll();
//        for (ClassRoom classRoom : classRooms) {
//            for (int i = 1; i < 3; i++) {
//                Course course = Course.builder()
//                        .module("Module" + i)
//                        .status(CourseStatus.PLANNED)
//                        .professor("Professor " + i)
//                        .icon("https://img.freepik.com/free-vector/designer-girl-concept-illustration_114360-4455.jpg?w=2000")
//                        .classRoom(classRoom)
//                        .build();
//                courseRepository.save(course);
//            }
//        }
//    }
//}
