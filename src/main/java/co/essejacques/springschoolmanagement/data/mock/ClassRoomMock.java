package co.essejacques.springschoolmanagement.data.mock;

import co.essejacques.springschoolmanagement.data.entity.ClassRoom;
import co.essejacques.springschoolmanagement.data.repository.ClassRoomRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Component
@RequiredArgsConstructor
@Order(1)
public class ClassRoomMock  implements CommandLineRunner {
    public final ClassRoomRepository classRoomRepository;

    // Initialize list of 20 classroom names in the French system
    List<String> frenchClassrooms = new ArrayList<>(Arrays.asList(
            "CP (Cours Préparatoire)", "CE1 (Cours Élémentaire 1)", "CE2 (Cours Élémentaire 2)",
            "CM1 (Cours Moyen 1)", "CM2 (Cours Moyen 2)", "6ème (Sixième)", "5ème (Cinquième)",
            "4ème (Quatrième)", "3ème (Troisième)", "2nde (Seconde)", "1ère (Première)",
            "Terminale", "Maternelle Petite Section", "Maternelle Moyenne Section",
            "Maternelle Grande Section", "CP-CE1 (mixed grade class)", "CE1-CE2 (mixed grade class)",
            "CE2-CM1 (mixed grade class)", "CM1-CM2 (mixed grade class)", "Classe de Préparation (CPGE)"
    ));

    @Override
    public void run(String... args) throws Exception {
        if(classRoomRepository.findAll().isEmpty()) {
            for (int i = 0; i < frenchClassrooms.size(); i++) {
                ClassRoom classRoom = ClassRoom.builder()
                        .name(frenchClassrooms.get(i))
                        .level("Année " + (i + 1))
                        .division("Division " + (i + 1))
                        .build();
                classRoomRepository.save(classRoom);
            }
        }
    }
}
