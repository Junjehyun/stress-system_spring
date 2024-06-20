package com.ptsol.stress_system.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class IndexController {

    /*
     * 産業医メニューページへ移動する
     * @return
     */
    @GetMapping("/index")
    public String Index() {
        return "stress/index";
    }
    /*
     * 空ページへ移動する
     * @return
     */
    @GetMapping("/blank")
    public String Blank() {
        return "stress/blank";
    }
}
