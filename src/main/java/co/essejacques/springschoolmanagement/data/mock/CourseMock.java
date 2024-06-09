package co.essejacques.springschoolmanagement.data.mock;

import co.essejacques.springschoolmanagement.data.entity.ClassRoom;
import co.essejacques.springschoolmanagement.data.entity.Course;
import co.essejacques.springschoolmanagement.data.enums.CourseStatus;
import co.essejacques.springschoolmanagement.data.repository.ClassRoomRepository;
import co.essejacques.springschoolmanagement.data.repository.CourseRepository;
import lombok.Builder;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

@Component
@Builder
@RequiredArgsConstructor
@Order(2)
public class CourseMock implements CommandLineRunner {
    public final CourseRepository courseRepository;
    private final ClassRoomRepository classRoomRepository;

    @Override
    public void run(String... args) throws Exception {

        if (courseRepository.findAll().isEmpty()) {


            // Initialize list of 20 courses
            List<String> coursesStrings = new ArrayList<>(Arrays.asList(
                    "Mathematics", "Physics", "Chemistry", "Biology", "English Literature",
                    "History", "Geography", "Computer Science", "Physical Education", "Art",
                    "Music", "Economics", "Psychology", "Sociology", "Philosophy",
                    "Political Science", "Anthropology", "Environmental Science", "Business Studies", "Law"
            ));

            // Initialize list of 20 professor names
            List<String> professorNames = new ArrayList<>(Arrays.asList(
                    "Dr. Alice Johnson", "Prof. Robert Smith", "Dr. Emily Davis", "Prof. John Brown",
                    "Dr. Susan Wilson", "Prof. Michael Miller", "Dr. Jennifer Moore", "Prof. David Taylor",
                    "Dr. Jessica Anderson", "Prof. William Thomas", "Dr. Laura Jackson", "Prof. Richard White",
                    "Dr. Sarah Harris", "Prof. Charles Martin", "Dr. Karen Thompson", "Prof. Christopher Garcia",
                    "Dr. Lisa Martinez", "Prof. Daniel Robinson", "Dr. Nancy Clark", "Prof. Paul Rodriguez"
            ));

            // Initialize list of course statuses
            List<CourseStatus> courseStatuses = new ArrayList<>(Arrays.asList(CourseStatus.PLANNED, CourseStatus.STARTED));

            // Initialize list of different image URLs
            List<String> imageUrls = new ArrayList<>(Arrays.asList(
                    "https://img.freepik.com/free-vector/designer-girl-concept-illustration_114360-4455.jpg?w=2000",
                    "https://img.freepik.com/free-vector/teacher-explaining-mathematics-students_74855-5656.jpg?w=2000",
                    "https://img.freepik.com/free-vector/illustration-scientific-experiment_53876-20699.jpg?w=2000",
                    "https://img.freepik.com/free-vector/biology-concept-illustration_114360-2581.jpg?w=2000",
                    "https://img.freepik.com/free-vector/literature-concept_74855-6266.jpg?w=2000",
                    "https://img.freepik.com/free-vector/online-history-lesson-concept_23-2148598121.jpg?w=2000",
                    "https://img.freepik.com/free-vector/geography-lesson-concept-illustration_114360-6667.jpg?w=2000",
                    "https://img.freepik.com/free-vector/computer-engineering-concept-illustration_114360-4417.jpg?w=2000",
                    "https://img.freepik.com/free-vector/kids-playing-soccer-illustration_1284-25455.jpg?w=2000",
                    "https://img.freepik.com/free-vector/painting-hobby-concept_52683-70735.jpg?w=2000",
                    "https://img.freepik.com/free-vector/music-concept-illustration_114360-1595.jpg?w=2000",
                    "https://img.freepik.com/free-vector/economy-concept-illustration_114360-1234.jpg?w=2000",
                    "https://img.freepik.com/free-vector/psychologist-concept-illustration_114360-2958.jpg?w=2000",
                    "https://img.freepik.com/free-vector/sociology-concept-illustration_114360-3941.jpg?w=2000",
                    "https://img.freepik.com/free-vector/philosophy-concept-illustration_114360-1288.jpg?w=2000",
                    "https://img.freepik.com/free-vector/politics-concept-illustration_114360-1774.jpg?w=2000",
                    "https://img.freepik.com/free-vector/anthropology-concept-illustration_114360-1715.jpg?w=2000",
                    "https://img.freepik.com/free-vector/environmental-science-concept-illustration_114360-2584.jpg?w=2000",
                    "https://img.freepik.com/free-vector/business-concept-illustration_114360-4617.jpg?w=2000",
                    "https://img.freepik.com/free-vector/law-concept-illustration_114360-2592.jpg?w=2000"
            ));

            Random random = new Random();

            List<ClassRoom> classRooms = this.classRoomRepository.findAll();
            for (ClassRoom classRoom : classRooms) {
                for (int i = 0; i < random.nextInt(15, coursesStrings.size()); i++) {
                    Course course = Course.builder()
                            .module(coursesStrings.get(i))
                            .status(courseStatuses.get(random.nextInt(courseStatuses.size())))
                            .professor(professorNames.get(i))
                            .icon(imageUrls.get(i))
                            .classRoom(classRoom)
                            .build();
                    courseRepository.save(course);
                }
            }
        }
    }
}
