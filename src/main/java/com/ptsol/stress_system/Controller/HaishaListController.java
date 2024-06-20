package com.ptsol.stress_system.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HaishaListController {

    @GetMapping("/haisha-list")
    public String HaishaList() {
        return "stress/haisha-list";
    }
}
