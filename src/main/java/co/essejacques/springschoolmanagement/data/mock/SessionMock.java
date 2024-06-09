package co.essejacques.springschoolmanagement.data.mock;

import co.essejacques.springschoolmanagement.data.entity.Course;
import co.essejacques.springschoolmanagement.data.entity.Session;
import co.essejacques.springschoolmanagement.data.enums.CourseStatus;
import co.essejacques.springschoolmanagement.data.repository.ClassRoomRepository;
import co.essejacques.springschoolmanagement.data.repository.CourseRepository;
import co.essejacques.springschoolmanagement.data.repository.SessionRepository;
import lombok.Builder;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Component
@Builder
@RequiredArgsConstructor
@Order(3)
public class SessionMock implements CommandLineRunner {

    public final CourseRepository courseRepository;
    public final SessionRepository sessionRepository;

    @Override
    public void run(String... args) throws Exception {
        if (sessionRepository.findAll().isEmpty()) {
            for (Course course: courseRepository.findAll()) {
                for (int i = 0; i < 4; i++) {
                    LocalDateTime now = LocalDateTime.now();
                    Session session = Session.builder()
                            .date(LocalDate.from(now.plusDays(0)))
                            .startTime(LocalDateTime.of(now.getYear(), now.getMonth(), now.getDayOfMonth(), 9, 0))
                            .endTime(LocalDateTime.of(now.getYear(), now.getMonth(), now.getDayOfMonth(), 12, 0))
                            .status(CourseStatus.PLANNED) // or any other status you want to assign
                            .course(course)
                            .build();
                    sessionRepository.save(session);
                }
            }
        }
    }
}
