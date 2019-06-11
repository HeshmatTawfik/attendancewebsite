package resources;


import attendancewebsite.model.Student;
import lombok.Getter;
import org.springframework.hateoas.ResourceSupport;

public class StudentResource extends ResourceSupport {
    @Getter
    private String name;

    public StudentResource(Student student) {
    this.name=student.getStudentName();
    }

}
