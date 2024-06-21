package com.ptsol.stress_system.controller;

import com.ptsol.stress_system.model.User;
import com.ptsol.stress_system.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
public class DoctorListController {
    private final UserService userService;

    public DoctorListController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/doctor-list")
    public String doctorList(Model model) {
        List<User> users = userService.getAllUsers();
        model.addAttribute("users", users);
        return "stress/doctor-list";
    }
}
