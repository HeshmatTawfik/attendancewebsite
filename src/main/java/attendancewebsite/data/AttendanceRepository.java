package attendancewebsite.data;

import attendancewebsite.model.Attendance;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface AttendanceRepository extends CrudRepository<Attendance,Integer> {
    List<Attendance>findAllByStudentIdAndAttendanceState(int studentId,int attendanceState);
    List<Attendance>findAttendancesByStudentIdAndAndAttendanceState(int studentId,int attendanceState);
   int countAllByAttendanceStateEqualsAndAndStudentId(int AttendanceState,int studentId);
}
