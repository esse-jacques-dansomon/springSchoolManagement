package co.essejacques.springschoolmanagement.data.projections;

public interface AttendanceDetailsProjection extends AttendanceProjection {
    StudentProjection getStudent();
    SessionDetailsProjection getSession();
}
