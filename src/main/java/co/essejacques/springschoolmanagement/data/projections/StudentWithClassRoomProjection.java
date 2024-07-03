package co.essejacques.springschoolmanagement.data.projections;

public interface StudentWithClassRoomProjection extends StudentProjection {
   ClassRoomProjection getClassRoom();
}
