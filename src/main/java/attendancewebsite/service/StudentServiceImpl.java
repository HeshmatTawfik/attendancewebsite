package attendancewebsite.service;
import attendancewebsite.data.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.stereotype.Service;
import attendancewebsite.model.Student;
@Transactional
@Service("StudentService")
public class StudentServiceImpl implements StudentService {
   @Autowired
   private UserRepository userRepository;

    @Override
    public Student update(Student student) {
        return null;
    }
}
