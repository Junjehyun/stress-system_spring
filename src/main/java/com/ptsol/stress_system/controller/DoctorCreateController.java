package com.ptsol.stress_system.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.ptsol.stress_system.model.User;
import com.ptsol.stress_system.service.CreateCompanySoshikiService;

@Controller
public class DoctorCreateController {

    private final CreateCompanySoshikiService createCompanySoshikiService;

    public DoctorCreateController(CreateCompanySoshikiService createCompanySoshikiService) {
        this.createCompanySoshikiService = createCompanySoshikiService;
    }

    @GetMapping("/doctor-create")
    public String main(@RequestParam(name = "hiddenCompanyCheck", required = false, defaultValue = "false") String hiddenCompanyCheck,
                        @RequestParam(name = "hiddenCompanyNameInput", required = false) String hiddenCompanyNameInput,
                        @RequestParam(name = "hiddenCompanyNameOutput", required = false) String hiddenCompanyNameOutput,
                        Model model) {

        Boolean companyCheck = Boolean.parseBoolean(hiddenCompanyCheck);

        model.addAttribute("companyNames", createCompanySoshikiService.getCompanyNames());
        model.addAttribute("soshikiNames", createCompanySoshikiService.getSoshikiNames());
        model.addAttribute("user", new User());

        model.addAttribute("hiddenCompanyCheck", companyCheck);
        model.addAttribute("companyNameInput", hiddenCompanyNameInput);
        model.addAttribute("companyNameOutput", hiddenCompanyNameOutput);

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
