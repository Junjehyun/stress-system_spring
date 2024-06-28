package com.ptsol.stress_system.controller;

import com.ptsol.stress_system.model.HyojiSearch;
import com.ptsol.stress_system.model.KaisyaMst;
import com.ptsol.stress_system.model.TaisyoSoshiki;
import com.ptsol.stress_system.model.User;
import com.ptsol.stress_system.service.HyojiBtnService;
import com.ptsol.stress_system.service.TaisyoSoshikiService;
import com.ptsol.stress_system.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import com.ptsol.stress_system.service.KaisyaMstService;

import java.util.List;

@Controller
public class DoctorListController {
    /**
     * UserServiceをDIする
     */
    @Autowired
    private final UserService userService;
    /**
     * KaisyaMstServiceをDIする
     */
    @Autowired
    private KaisyaMstService kaisyaMstService;
    /**
     * TaisyoSoshikiServiceをDIする
     */
    @Autowired
    private TaisyoSoshikiService taisyoSoshikiService;

    /**
     * HyojiBtnServiceをDIする
     */
    @Autowired
    private HyojiBtnService hyojiBtnService;

    public DoctorListController(UserService userService) {
        this.userService = userService;
    }

    /**
     * LeftJoinまでして結果を表示する。
     * @param model
     * @param companyCheck
     * @return
     */
    @GetMapping("/doctor-list")
    public String doctorList(@RequestParam(name = "companyCheck", required = false) Boolean companyCheck,
                            @RequestParam(name = "companyNameInput", required = false) String companyNameInput,
                            @RequestParam(name = "companyNameOutput", required = false) String companyNameOutput,
                            Model model) {
        //List<User> users = userService.getAllUsers();
        List<User> users = userService.getAllUsersWithDetails();

        model.addAttribute("companyCheck", companyCheck);
        model.addAttribute("companyNameInput", companyNameInput);
        model.addAttribute("companyNameOutput", companyNameOutput);
        model.addAttribute("users", users);
        return "stress/doctor-list";
    }

    /**
     * Ajaxで会社名検索を行うメソッド
     * 
     * @param name
     * @return
     */
    @GetMapping("/company-search")
    @ResponseBody
    public List<KaisyaMst> companySearch(@RequestParam("name") String name) {
        return kaisyaMstService.searchCompaniesByName(name);
    }

    /**
     * Ajaxで組織名検索を行うメソッド
     * 
     * @param soshikiName
     * @return
     */
    @GetMapping("/soshiki-search")
    @ResponseBody
    public List<TaisyoSoshiki> soshikiSearch(@RequestParam("soshikiName") String soshikiName) {
        return taisyoSoshikiService.searchSoshikiByName(soshikiName);
    }

    /**
     * 表示するボタンを押した時、設定した検索条件による、ユーザーリストを取得するメソッド
     * @param companyName 会社名
     * @param soshikiName 組織名
     * @param kengenKubun 権限区分
     * @Param Model model モデルオブジェクト
     * @return ユーザーリスト
     */
    @PostMapping("/hyoji-search")
    public String hyojiSearch(
            @RequestParam(name = "companyNameInput", required = false) String companyNameInput,
            @RequestParam(name = "companyNameOutput", required = false) String companyNameOutput,
            @RequestParam(name = "soshikiNameInput", required = false) String soshikiNameInput,
            @RequestParam(name = "soshikiNameOutput", required = false) String soshikiNameOutput,
            @RequestParam(name = "kengenKubun", required = false) Integer kengenKubun,
            @RequestParam(name = "companyCheck", required = false) Boolean companyCheck,
            @RequestParam(name = "soshikiCheck", required = false) Boolean soshikiCheck,
            @RequestParam(name = "kengenCheck", required = false) Boolean kengenCheck,
            Model model) {

        List<HyojiSearch> users = hyojiBtnService.hyojiSearchUsers(companyNameOutput, soshikiNameOutput, kengenKubun);

        model.addAttribute("companyNameInput", companyNameInput);
        model.addAttribute("companyNameOutput", companyNameOutput);
        model.addAttribute("soshikiNameInput", soshikiNameInput);
        model.addAttribute("soshikiNameOutput", soshikiNameOutput);
        model.addAttribute("kengenKubun", kengenKubun);
        model.addAttribute("users", users);
        model.addAttribute("companyCheck", companyCheck);
        model.addAttribute("soshikiCheck", soshikiCheck);
        model.addAttribute("kengenCheck", kengenCheck);

        List<KaisyaMst> companies = kaisyaMstService.searchCompaniesByName(companyNameInput);
        model.addAttribute("companies", companies);

        List<TaisyoSoshiki> soshikis = taisyoSoshikiService.searchSoshikiByName(soshikiNameInput);
        model.addAttribute("soshikis", soshikis);

        return "stress/doctor-list";
    }
}
