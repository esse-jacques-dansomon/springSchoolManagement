//package co.essejacques.springschoolmanagement.data.mock;
//
//import co.essejacques.springschoolmanagement.data.entity.ClassRoom;
//import co.essejacques.springschoolmanagement.data.entity.Role;
//import co.essejacques.springschoolmanagement.data.entity.Student;
//import co.essejacques.springschoolmanagement.data.entity.User;
//import co.essejacques.springschoolmanagement.data.repository.ClassRoomRepository;
//import co.essejacques.springschoolmanagement.data.repository.RoleRepository;
//import co.essejacques.springschoolmanagement.data.repository.StudentRepository;
//import co.essejacques.springschoolmanagement.data.repository.UserRepository;
//import lombok.Builder;
//import lombok.RequiredArgsConstructor;
//import org.springframework.boot.CommandLineRunner;
//import org.springframework.core.annotation.Order;
//import org.springframework.stereotype.Component;
//
//import java.util.Arrays;
//import java.util.List;
//import java.util.Set;
//
//import static co.essejacques.springschoolmanagement.config.SpringSecurityConfig.passwordEncoder;
//
//@Component
//@RequiredArgsConstructor
//@Order(5)
//public class StudentMock implements CommandLineRunner {
//    public final RoleRepository roleRepository;
//    public final StudentRepository studentRepository;
//    public final ClassRoomRepository classRoomRepository;
//
//    List<String> roles = Arrays.asList("esse", "junior", "stephane", "jordane");
//
//    @Override
//    public void run(String... args) throws Exception {
//        for (String name : roles) {
//            String email = name.toLowerCase() + "@example.com";
//            Set<Role> roles = roleRepository.findAllByName("ROLE_STUDENT");
//            ClassRoom classRoom = classRoomRepository.findAll().get(1);
//            Student student = Student.builder()
//                    .email(email)
//                    .password(passwordEncoder().encode("password"))
//                    .firstName(name)
//                    .lastName("Cauris")
//                    .address("123 Main St" + name)
//                    .registrationNumber(name + "123456")
//                    .classRoom(classRoom)
//                    .build();
//            studentRepository.save(student);
//
//            student.setRoles(roles);
//            studentRepository.save(student);
//        }
//    }
//}
