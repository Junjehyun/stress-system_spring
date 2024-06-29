package com.ptsol.stress_system.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.ptsol.stress_system.model.User;
import com.ptsol.stress_system.service.UpdateUserService;


@Controller
public class DoctorUpdateController {

    @Autowired
    private UpdateUserService updateUserService;
    
    @GetMapping("/doctor-edit/{id}")
    public String showEditPage(Model model, @PathVariable("id") String userId) {

        User user = updateUserService.getUserById(userId);

        System.out.println("User ID: " + user.getUserId());
        System.out.println("User Name: " + user.getName());

        model.addAttribute("user", user);
        
        return "stress/doctor-edit";
    }

}
