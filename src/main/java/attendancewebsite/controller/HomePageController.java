package attendancewebsite.controller;

import attendancewebsite.data.AttendanceRepository;
import attendancewebsite.data.UserRepository;
import attendancewebsite.model.Attendance;
import attendancewebsite.model.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

import static attendancewebsite.model.Student.loginStudent;

@Controller

public class HomePageController {
    @Autowired
    private UserRepository userRepository;
    @Autowired
    AttendanceRepository attendanceRepository;

    @RequestMapping(value = {"/homePage"}, method = RequestMethod.GET)
    public String home2(Model model2) {
        ModelAndView model = new ModelAndView();
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        System.out.println(SecurityContextHolder.getContext().getAuthentication().getName());
        String name = SecurityContextHolder.getContext().getAuthentication().getName();
        Student studentDetials = userRepository.findBystudentName(name);
        loginStudent = studentDetials;
        List<Attendance> a = attendanceRepository.findAllByStudentIdAndAttendanceState(studentDetials.getId(), 0);
        int countAb = attendanceRepository.countAllByAttendanceStateEqualsAndAndStudentId(0, studentDetials.getId());
        int countAtt = attendanceRepository.countAllByAttendanceStateEqualsAndAndStudentId(1, studentDetials.getId());
        model2.addAttribute("countAb", countAb);
        if (countAb!=0)
        model2.addAttribute("countAtt", countAtt);
        else
            model2.addAttribute("countAtt", 1);
        model2.addAttribute("studentDetails", studentDetials);
        model2.addAttribute("attList", a);
        model.setViewName("home");
        return "homePage";
    }



}
