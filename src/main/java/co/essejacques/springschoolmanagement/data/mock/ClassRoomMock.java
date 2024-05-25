//package co.essejacques.springschoolmanagement.data.mock;
//
//import co.essejacques.springschoolmanagement.data.entity.ClassRoom;
//import co.essejacques.springschoolmanagement.data.repository.ClassRoomRepository;
//import lombok.Builder;
//import lombok.RequiredArgsConstructor;
//import org.springframework.boot.CommandLineRunner;
//import org.springframework.core.annotation.Order;
//import org.springframework.stereotype.Component;
//
//@Component
//@Builder
//@RequiredArgsConstructor
//@Order(1)
//public class ClassRoomMock  implements CommandLineRunner {
//    public final ClassRoomRepository classRoomRepository;
//    @Override
//    public void run(String... args) throws Exception {
//        for (int i = 1; i < 15; i++) {
//            ClassRoom classRoom = ClassRoom.builder()
//                    .name("Classe " + i)
//                    .level("Level " + i)
//                    .division("Division "+ i)
//                    .build();
//            classRoomRepository.save(classRoom);
//        }
//    }
//}
