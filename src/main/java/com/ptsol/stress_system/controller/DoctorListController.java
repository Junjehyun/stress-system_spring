package com.ptsol.stress_system.controller;

import com.ptsol.stress_system.model.KaisyaMst;
import com.ptsol.stress_system.model.User;
import com.ptsol.stress_system.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import com.ptsol.stress_system.service.KaisyaMstService;

import java.util.List;

@Controller
public class DoctorListController {
    private final UserService userService;
    private KaisyaMstService kaisyaMstService;

    public DoctorListController(UserService userService) {
        this.userService = userService;
    }

    /**
     * LeftJoinまでして結果を表示する。
     * @param model
     * @return
     */
    @GetMapping("/doctor-list")
    public String doctorList(Model model) {
        //List<User> users = userService.getAllUsers();
        List<User> users = userService.getAllUsersWithDetails();
        model.addAttribute("users", users);
        return "stress/doctor-list";
    }

    // 내일 여기서부터 다시
    @GetMapping("/company-search")
    @ResponseBody
    public List<KaisyaMst> companySearch(@RequestParam("name") String name) {
        return kaisyaMstService.searchCompaniesByName(name);
    }
}
