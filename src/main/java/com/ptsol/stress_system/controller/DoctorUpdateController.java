package com.ptsol.stress_system.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.ptsol.stress_system.model.User;
import com.ptsol.stress_system.service.UpdateUserService;


@Controller
@RequestMapping("/doctor-edit")
public class DoctorUpdateController {

    @Autowired
    private UpdateUserService updateUserService;
    
    @GetMapping("/{id}")
    public String showEditPage(Model model, @PathVariable("id") String userId) {

        User user = updateUserService.getUserById(userId);

        model.addAttribute("user", user);
        
        return "stress/doctor-edit";
    }

    @PostMapping("/update-user")
    public String updateUser(@ModelAttribute User user) {

        updateUserService.updateUser(user);

        return "redirect:/doctor-list";
    }

}
