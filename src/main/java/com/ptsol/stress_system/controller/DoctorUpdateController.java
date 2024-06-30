package com.ptsol.stress_system.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.ptsol.stress_system.model.KaisyaMst;
import com.ptsol.stress_system.model.User;
import com.ptsol.stress_system.service.CreateCompanySoshikiService;
import com.ptsol.stress_system.service.KaisyaMstService;
import com.ptsol.stress_system.service.UpdateUserService;

import java.util.List;


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
        // 여기서 회사명 리스트 가져오는거부터 시작 하면 됨. 
        List<String> companyNames = createCompanySoshikiService.getCompanyNames();

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
        
        return "stress/doctor-edit";
    }

    @PostMapping("/update-user")
    public String updateUser(@ModelAttribute User user) {

        updateUserService.updateUser(user);

        return "redirect:/doctor-list";
    }

}
