package com.ptsol.stress_system.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;

import com.ptsol.stress_system.model.User;
import com.ptsol.stress_system.service.CreateCompanySoshikiService;
import com.ptsol.stress_system.validation.ValidationGroups;

/**
 * 医師登録画面のコントローラクラス。
 */
@Controller
public class DoctorCreateController {

    private final CreateCompanySoshikiService createCompanySoshikiService;

    public DoctorCreateController(CreateCompanySoshikiService createCompanySoshikiService) {
        this.createCompanySoshikiService = createCompanySoshikiService;
    }

    /**
     * 医師登録画面を表示するメソッド。
     * 
     * @param hiddenCompanyCheck 会社名の入力欄が表示されているかどうか
     * @param hiddenSoshikiCheck 組織名の入力欄が表示されているかどうか
     * @param hiddenKengenCheck 権限の入力欄が表示されているかどうか
     * @param hiddenCompanyNameInput 会社名の入力欄に入力された値
     * @param hiddenSoshikiNameInput 組織名の入力欄に入力された値
     * @param hiddenCompanyNameOutput 会社名の出力欄に表示される値
     * @param hiddenSoshikiNameOutput 組織名の出力欄に表示される値
     * @param hiddenKengenKubun 権限の選択欄に選択された値
     * @param model Modelオブジェクト
     * @return 医師登録画面のテンプレートパス
     */
    @GetMapping("/doctor-create")
    public String main(@RequestParam(name = "hiddenCompanyCheck", required = false, defaultValue = "false") String hiddenCompanyCheck,
                        @RequestParam(name = "hiddenSoshikiCheck", required = false, defaultValue = "false") String hiddenSoshikiCheck,
                        @RequestParam(name = "hiddenKengenCheck", required = false, defaultValue = "false") String hiddenKengenCheck,
                        @RequestParam(name = "hiddenCompanyNameInput", required = false) String hiddenCompanyNameInput,
                        @RequestParam(name = "hiddenSoshikiNameInput", required = false) String hiddenSoshikiNameInput,
                        @RequestParam(name = "hiddenCompanyNameOutput", required = false) String hiddenCompanyNameOutput,
                        @RequestParam(name = "hiddenSoshikiNameOutput", required = false) String hiddenSoshikiNameOutput,
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
        model.addAttribute("hiddenSoshikiNameOutput", hiddenSoshikiNameOutput);
        model.addAttribute("hiddenKengenKubun", hiddenKengenKubun);
        return "/stress/doctor-create";
    }

    /**
     * フォームデータを受け取り、ユーザーを生成するメソッド。
     * 
     * @param user フォームから送信されたUserオブジェクト
     * @return リダイレクトURL
     * @throws Exception
     */
    @PostMapping("/doctor-create")
    public String createUser(@Validated(ValidationGroups.Create.class) @ModelAttribute User user, BindingResult bindingResult, Model model) {
        if (bindingResult.hasErrors()) {
            model.addAttribute("companyNames", createCompanySoshikiService.getCompanyNames());
            model.addAttribute("soshikiNames", createCompanySoshikiService.getSoshikiNames());
            
            bindingResult.getAllErrors().forEach(error -> {
                System.out.println("Error: " + error.getDefaultMessage());
            });
            
            return "stress/doctor-create";
        }
        createCompanySoshikiService.createUser(user);
        return "redirect:/doctor-list";
    }

}
