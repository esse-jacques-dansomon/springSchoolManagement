package co.essejacques.springschoolmanagement.services.interfaces;

import co.essejacques.springschoolmanagement.data.entity.Seance;
import co.essejacques.springschoolmanagement.data.enums.CourseStatus;

import java.util.List;

public interface ISeanceService {

    List<Seance> getSeances();
    List<Seance> getSeancesByStatus(CourseStatus courseStatus);
    Seance getSeanceById(Long id);
    Seance saveSeance(Seance seance);
    void deleteSeance(Long id);
    Seance updateSeance(Long id, Seance seance);

}
