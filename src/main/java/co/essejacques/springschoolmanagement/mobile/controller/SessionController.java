package co.essejacques.springschoolmanagement.mobile.controller;

import co.essejacques.springschoolmanagement.data.entity.Session;
import co.essejacques.springschoolmanagement.data.enums.CourseStatus;
import co.essejacques.springschoolmanagement.data.projections.SessionDetailsProjection;
import co.essejacques.springschoolmanagement.services.interfaces.ISessionService;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springdoc.core.converters.models.Pageable;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RequestMapping("/sessions")
@RestController
@Tag(name = "Sessions", description = "Session API")
public class SessionController {

    private final ISessionService sessionService;

    @PostMapping()
    public Session saveSession(Session session)  {
        return this.sessionService.saveSession(session);
    }

    @GetMapping()
    public Page<SessionDetailsProjection> getSessions(
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "10") int size
    )  {
        return this.sessionService.getSessions(PageRequest.of(page, size));
    }

    @GetMapping("/status/{status}")
    public ResponseEntity<List<SessionDetailsProjection>> getSessionsByStatus(@PathVariable CourseStatus status)  {
        return ResponseEntity.ok(this.sessionService.getSessionsByStatus(status));
    }

    @GetMapping("/classroom/{id}")
    public List<SessionDetailsProjection> getSessionsByClassroom(@PathVariable Long id)  {
        return this.sessionService.getSessionsByClassroom(id);
    }

    @GetMapping("/classroom/{id}/today")
    public List<SessionDetailsProjection> getSessionsByClassroomAndToday(@PathVariable Long id)  {
        return this.sessionService.getSessionsByClassroomAndToday(id);
    }

    @GetMapping("/{id}")
    public Session getSessionById(@PathVariable Long id)  {
        return this.sessionService.getSessionById(id);
    }

    @DeleteMapping("/{id}")
    public void deleteSession(@PathVariable Long id)  {
        this.sessionService.deleteSession(id);
    }

}
