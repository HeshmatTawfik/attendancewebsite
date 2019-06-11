package attendancewebsite.controller;
import attendancewebsite.data.AttendanceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import java.security.Principal;
@Controller
public class LoginController {

    @Autowired
    AttendanceRepository attendanceRepository;

    @RequestMapping(value = {"/"}, method = RequestMethod.GET)
    public String login(Principal principal, Model model) {
        return "redirect:/homePage";
    }}
