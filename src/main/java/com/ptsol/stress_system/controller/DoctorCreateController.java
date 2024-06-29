package com.ptsol.stress_system.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.validation.BindingResult;

import com.ptsol.stress_system.model.User;
import com.ptsol.stress_system.service.CreateCompanySoshikiService;

import jakarta.validation.Valid;

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
        model.addAttribute("hiddenCompanyNameOutput", hiddenCompanyNameOutput);
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
    public String createUser(@Valid @ModelAttribute User user, BindingResult bindingResult, Model model) {
        if (bindingResult.hasErrors()) {
            model.addAttribute("companyNames", createCompanySoshikiService.getCompanyNames());
            model.addAttribute("soshikiNames", createCompanySoshikiService.getSoshikiNames());
            
            bindingResult.getAllErrors().forEach(error -> {
                System.out.println("Error: " + error.getDefaultMessage());
            });
            
            // 유효성 검사 오류 처리
            return "stress/doctor-create"; // 폼 페이지로 리다이렉트 (예시)
        }
        createCompanySoshikiService.createUser(user);
        return "redirect:/doctor-list";
    }

}
