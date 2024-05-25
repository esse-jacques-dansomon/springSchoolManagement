//package co.essejacques.springschoolmanagement.data.mock;
//
//import co.essejacques.springschoolmanagement.data.repository.RoleRepository;
//import lombok.Builder;
//import lombok.RequiredArgsConstructor;
//import org.springframework.boot.CommandLineRunner;
//import org.springframework.core.annotation.Order;
//import org.springframework.stereotype.Component;
//import co.essejacques.springschoolmanagement.data.entity.Role;
//
//import java.util.Arrays;
//import java.util.List;
//
//@Component
//@RequiredArgsConstructor
//@Order(4)
//public class RoleMock  implements CommandLineRunner {
//    public final RoleRepository roleRepository;
//
//    List<String> roles = Arrays.asList("ROLE_STUDENT", "ROLE_PROFESSOR", "ROLE_MANAGER", "ROLE_ADMIN", "ROLE_SUPER_ADMIN");
//
//    @Override
//    public void run(String... args) throws Exception {
//        for (String role : roles) {
//            roleRepository.save(Role.builder()
//                   .name(role)
//                   .build());
//        }
//    }
//}
