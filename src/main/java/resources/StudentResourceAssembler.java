package resources;

import attendancewebsite.controller.HomePageController;
import attendancewebsite.model.Student;
import org.springframework.hateoas.mvc.ResourceAssemblerSupport;

public class StudentResourceAssembler extends ResourceAssemblerSupport<Student,StudentResource> {
    public StudentResourceAssembler() {
        super(HomePageController.class, StudentResource.class);    }

    @Override
    public StudentResource toResource(Student student){
        return createResourceWithId(student.getId(),student);
    }

    @Override
    protected StudentResource instantiateResource(Student student) {
        return super.instantiateResource(student);
    }
}
