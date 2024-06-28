package com.ptsol.stress_system.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class DoctorUpdateController {
    
    @GetMapping("/doctor-edit")
    public String main() {
        return "/stress/doctor-edit";
    }
}
