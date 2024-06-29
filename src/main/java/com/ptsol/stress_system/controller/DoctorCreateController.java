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
                        @RequestParam(name = "hiddenSoshikiCheck", required = false, defaultValue = "false") String hiddenSoshikiCheck,
                        @RequestParam(name = "hiddenKengenCheck", required = false, defaultValue = "false") String hiddenKengenCheck,
                        @RequestParam(name = "hiddenCompanyNameInput", required = false) String hiddenCompanyNameInput,
                        @RequestParam(name = "hiddenSoshikiNameINput", required = false) String hiddenSoshikiNameInput,
                        @RequestParam(name = "hiddenCompanyNameOutput", required = false) String hiddenCompanyNameOutput,
                        @RequestParam(name = "hiddenKengenKubun", required = false) String hiddenKengenKubun,
                        Model model) {

        Boolean companyCheck = Boolean.parseBoolean(hiddenCompanyCheck);

        model.addAttribute("companyNames", createCompanySoshikiService.getCompanyNames());
        model.addAttribute("soshikiNames", createCompanySoshikiService.getSoshikiNames());
        model.addAttribute("user", new User());

        model.addAttribute("hiddenCompanyCheck", companyCheck);
        model.addAttribute("hiddenSoshikiCheck", hiddenSoshikiCheck);
        model.addAttribute("hiddenKengenCheck", hiddenKengenCheck);
        model.addAttribute("companyNameInput", hiddenCompanyNameInput);
        model.addAttribute("soshikiNameInput", hiddenSoshikiNameInput);
        model.addAttribute("companyNameOutput", hiddenCompanyNameOutput);
        model.addAttribute("hiddenKengenKubun", hiddenKengenKubun);
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
