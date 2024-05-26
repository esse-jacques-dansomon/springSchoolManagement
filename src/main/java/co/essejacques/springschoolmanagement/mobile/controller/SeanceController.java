package co.essejacques.springschoolmanagement.mobile.controller;

import co.essejacques.springschoolmanagement.data.entity.Seance;
import co.essejacques.springschoolmanagement.data.enums.CourseStatus;
import co.essejacques.springschoolmanagement.data.projections.SeanceDetailsProjection;
import co.essejacques.springschoolmanagement.services.interfaces.ISeanceService;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RequestMapping("/seances")
@RestController
@Tag(name = "Seances", description = "Seance API")
public class SeanceController {

    private final ISeanceService seanceService;

    @PostMapping()
    public Seance saveSeance(Seance seance)  {
        return this.seanceService.saveSeance(seance);
    }

    @GetMapping()
    public List<Seance> getSeances()  {
        return this.seanceService.getSeances();
    }

    @GetMapping("/status/{status}")
    public List<Seance> getSeancesByStatus(@PathVariable CourseStatus status)  {
        return this.seanceService.getSeancesByStatus(status);
    }

    @GetMapping("/classroom/{id}")
    public List<SeanceDetailsProjection> getSessionsByClassroom(@PathVariable Long id)  {
        return this.seanceService.getSessionsByClassroom(id);
    }

    @GetMapping("/classroom/{id}/today")
    public List<SeanceDetailsProjection> getSessionsByClassroomAndToday(@PathVariable Long id)  {
        return this.seanceService.getSessionsByClassroomAndToday(id);
    }

    @GetMapping("/{id}")
    public Seance getSeanceById(@PathVariable Long id)  {
        return this.seanceService.getSeanceById(id);
    }

    @DeleteMapping("/{id}")
    public void deleteSeance(@PathVariable Long id)  {
        this.seanceService.deleteSeance(id);
    }

}
