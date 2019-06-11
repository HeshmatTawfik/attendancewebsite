package attendancewebsite.controller;

import attendancewebsite.data.UserRepository;
import attendancewebsite.model.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.ui.Model;




@Controller
public class ChangePasswordController {
    @Autowired
    private UserRepository userRepository;

    @RequestMapping(value = {"/changepassword"}, method = RequestMethod.GET)
    public String changePass() {
        return "changepassword";
    }

    @RequestMapping(value = {"/changepassword"}, method = RequestMethod.POST)
    public String changePassword(@RequestParam("currentPassword") String currentPassword,
                                 @RequestParam("newPassword") String newPassword, Model model) {
        String name = SecurityContextHolder.getContext().getAuthentication().getName();
        Student changePass = userRepository.findBystudentName(name);
        if (!changePass.getPassword().equals(currentPassword)) {
            model.addAttribute("passw", "current password is incorrect");
            return "changepassword";
        }
        changePass.setPassword(newPassword);
        userRepository.save(changePass);
        model.addAttribute("correctPass", "password has changed successfully");
        return "changepassword";
    }


}
