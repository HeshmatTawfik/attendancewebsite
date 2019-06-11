package attendancewebsite.data;

import attendancewebsite.model.Student;
import org.springframework.data.repository.CrudRepository;


public interface UserRepository extends CrudRepository<Student,Integer> {
    Student findBystudentName(String studentName);
    Student findAllByStudentName(String studentName);

}
