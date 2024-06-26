package com.ptsol.stress_system.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.ptsol.stress_system.model.User;
import com.ptsol.stress_system.service.CreateCompanySoshikiService;

@Controller
public class DoctorCreateController {

    private final CreateCompanySoshikiService createCompanySoshikiService;

    public DoctorCreateController(CreateCompanySoshikiService createCompanySoshikiService) {
        this.createCompanySoshikiService = createCompanySoshikiService;
    }

    @GetMapping("/doctor-create")
    public String main(Model model) {

        model.addAttribute("companyNames", createCompanySoshikiService.getCompanyNames());
        model.addAttribute("soshikiNames", createCompanySoshikiService.getSoshikiNames());
        model.addAttribute("user", new User());

        return "/stress/doctor-create";
    }

    /**
     * フォームデータを受け取り、ユーザーを生成するメソッド。
     * 
     * @param user フォームから送信されたUserオブジェクト
     * @return リダイレクトURL
     */
    @PostMapping("/doctor-create")
    public String createUser(@ModelAttribute User user) {
        createCompanySoshikiService.CreateUser(user);
        return "redirect:/doctor-list";
    }

}
