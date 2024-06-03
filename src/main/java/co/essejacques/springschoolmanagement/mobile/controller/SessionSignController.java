package co.essejacques.springschoolmanagement.mobile.controller;

import co.essejacques.springschoolmanagement.data.entity.SessionSign;
import co.essejacques.springschoolmanagement.data.projections.SessionSignDetailsProjection;
import co.essejacques.springschoolmanagement.services.interfaces.ISessionSignService;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/session-signs")
@Tag(name = "SessionSigns", description = "Sessionss Sign API")

@AllArgsConstructor
public class SessionSignController {

    private final ISessionSignService sessionSignService;

    @PostMapping
    public ResponseEntity<SessionSign> createSessionSign(@RequestBody SessionSign sessionSign) {
        SessionSign createdSessionSign = sessionSignService.createSessionSign(sessionSign);
        return ResponseEntity.ok(createdSessionSign);
    }

    @PutMapping
    public ResponseEntity<SessionSign> updateSessionSign(@RequestBody SessionSign sessionSign) {
        SessionSign updatedSessionSign = sessionSignService.updateSessionSign(sessionSign);
        return ResponseEntity.ok(updatedSessionSign);
    }

    @DeleteMapping("/{sessionSignId}")
    public ResponseEntity<Void> deleteSessionSign(@PathVariable Long sessionSignId) {
        sessionSignService.deleteSessionSign(sessionSignId);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/{sessionSignId}")
    public ResponseEntity<Optional<SessionSignDetailsProjection>> getSessionSign(@PathVariable Long sessionSignId) {
        Optional<SessionSignDetailsProjection> sessionSign = sessionSignService.getSessionSign(sessionSignId);
        return ResponseEntity.ok(sessionSign);
    }

    @GetMapping("/sessions/{sessionId}")
    public ResponseEntity<List<SessionSignDetailsProjection>> getSessionSignBySession(@PathVariable Long sessionId) {
        List<SessionSignDetailsProjection> sessionSigns = sessionSignService.getSessionSignBySession(sessionId);
        return ResponseEntity.ok(sessionSigns);
    }

    @GetMapping("/students/{studentId}")
    public ResponseEntity<List<SessionSignDetailsProjection>> getSessionSignByStudent(@PathVariable Long studentId) {
        List<SessionSignDetailsProjection> sessionSigns = sessionSignService.getSessionSignByStudent(studentId);
        return ResponseEntity.ok(sessionSigns);
    }

    @GetMapping("/courses/{courseId}")
    public ResponseEntity<List<SessionSignDetailsProjection>> getSessionSignByCourse(@PathVariable Long courseId) {
        List<SessionSignDetailsProjection> sessionSigns = sessionSignService.getSessionSignByCourse(courseId);
        return ResponseEntity.ok(sessionSigns);
    }
}
