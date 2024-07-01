package com.ptsol.stress_system.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.ptsol.stress_system.model.User;
import com.ptsol.stress_system.service.CreateCompanySoshikiService;
import com.ptsol.stress_system.service.UpdateUserService;
import com.ptsol.stress_system.validation.ValidationGroups;


import java.util.List;
/**
 * 修正画面へ移動する
 * 
 * @param model
 * @param userId
 * @param companyCheck
 * @param soshikiCheck
 * @param kengenCheck
 * @param companyNameInput
 * @param soshikiNameInput
 * @param companyNameOutput
 * @param soshikiNameOutput
 * @param kengenKubun
 * @return stress/doctor-edit
 */
@Controller
@RequestMapping("/doctor-edit")
public class DoctorUpdateController {

    @Autowired
    private UpdateUserService updateUserService;
    @Autowired
    private CreateCompanySoshikiService createCompanySoshikiService;

    @GetMapping("/{id}")
    public String showEditPage(Model model, 
                            @PathVariable("id") String userId,
                            @RequestParam(name = "companyCheck", required = false) String companyCheck,
                            @RequestParam(name = "soshikiCheck", required = false) String soshikiCheck,
                            @RequestParam(name = "kengenCheck", required = false) String kengenCheck,
                            @RequestParam(name = "companyNameInput", required = false) String companyNameInput,
                            @RequestParam(name = "soshikiNameInput", required = false) String soshikiNameInput,
                            @RequestParam(name = "companyNameOutput", required = false) String companyNameOutput,
                            @RequestParam(name = "soshikiNameOutput", required = false) String soshikiNameOutput,
                            @RequestParam(name = "kengenKubun", required = false) String kengenKubun) {

        User user = updateUserService.getUserById(userId);

        List<String> companyNames = createCompanySoshikiService.getCompanyNames();
        List<String> soshikiNames = createCompanySoshikiService.getSoshikiNames();

        model.addAttribute("user", user);
        model.addAttribute("companyCheck", companyCheck);
        model.addAttribute("soshikiCheck", soshikiCheck);
        model.addAttribute("kengenCheck", kengenCheck);
        model.addAttribute("companyNameInput", companyNameInput);
        model.addAttribute("soshikiNameInput", soshikiNameInput);
        model.addAttribute("companyNameOutput", companyNameOutput);
        model.addAttribute("soshikiNameOutput", soshikiNameOutput);
        model.addAttribute("kengenKubun", kengenKubun);
        model.addAttribute("companyNames", companyNames);
        model.addAttribute("soshikiNames", soshikiNames);
        
        return "stress/doctor-edit";
    }

    /**
     * ユーザー情報を更新する
     * 
     * @param user
     * @param result
     * @param model
     * @return redirect:/doctor-list
     */
    @PostMapping("/update-user")
    public String updateUser(@Validated(ValidationGroups.Update.class) @ModelAttribute("user") User user, BindingResult result, Model model) {
        if (result.hasErrors()) {
            model.addAttribute("companyNames", createCompanySoshikiService.getCompanyNames());
            model.addAttribute("soshikiNames", createCompanySoshikiService.getSoshikiNames());

        User existingUser = updateUserService.getUserById(user.getUserId());
        user.setCompanyName(existingUser.getCompanyName());
        user.setOrganizationName(existingUser.getOrganizationName());
        user.setKengenCheck(existingUser.getKengenCheck());
        user.setKengenKubun(existingUser.getKengenKubun());

            return "stress/doctor-edit";
        }
        updateUserService.updateUser(user);
        return "redirect:/doctor-list";
    }

}
