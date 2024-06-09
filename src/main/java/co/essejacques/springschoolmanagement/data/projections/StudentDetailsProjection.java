package co.essejacques.springschoolmanagement.data.projections;

import java.util.Set;

public interface StudentDetailsProjection  extends StudentProjection{
    ClassRoomProjection getClassRoom();
    Set<SessionProjection> getAttendances();
}
