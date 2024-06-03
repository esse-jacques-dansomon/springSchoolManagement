package co.essejacques.springschoolmanagement.mobile.controller;

import co.essejacques.springschoolmanagement.data.entity.Session;
import co.essejacques.springschoolmanagement.data.enums.CourseStatus;
import co.essejacques.springschoolmanagement.data.projections.SessionDetailsProjection;
import co.essejacques.springschoolmanagement.services.interfaces.ISessionService;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RequestMapping("/sessions")
@RestController
@Tag(name = "Sessions", description = "Session API")
public class SessionController {

    private final ISessionService seanceService;

    @PostMapping()
    public Session saveSeance(Session session)  {
        return this.seanceService.saveSeance(session);
    }

    @GetMapping()
    public List<SessionDetailsProjection> getSeances()  {
        return this.seanceService.getSeances();
    }

    @GetMapping("/status/{status}")
    public ResponseEntity<List<SessionDetailsProjection>> getSeancesByStatus(@PathVariable CourseStatus status)  {
        return ResponseEntity.ok(this.seanceService.getSeancesByStatus(status));
    }

    @GetMapping("/classroom/{id}")
    public List<SessionDetailsProjection> getSessionsByClassroom(@PathVariable Long id)  {
        return this.seanceService.getSessionsByClassroom(id);
    }

    @GetMapping("/classroom/{id}/today")
    public List<SessionDetailsProjection> getSessionsByClassroomAndToday(@PathVariable Long id)  {
        return this.seanceService.getSessionsByClassroomAndToday(id);
    }

    @GetMapping("/{id}")
    public Session getSeanceById(@PathVariable Long id)  {
        return this.seanceService.getSeanceById(id);
    }

    @DeleteMapping("/{id}")
    public void deleteSeance(@PathVariable Long id)  {
        this.seanceService.deleteSeance(id);
    }

}
