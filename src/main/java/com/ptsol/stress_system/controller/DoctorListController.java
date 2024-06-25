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
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import com.ptsol.stress_system.service.KaisyaMstService;

import javax.naming.directory.SearchResult;
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
     * @return
     */
    @GetMapping("/doctor-list")
    public String doctorList(Model model) {
        //List<User> users = userService.getAllUsers();
        List<User> users = userService.getAllUsersWithDetails();
        model.addAttribute("users", users);
        return "stress/doctor-list";
    }

    @GetMapping("/company-search")
    @ResponseBody
    public List<KaisyaMst> companySearch(@RequestParam("name") String name) {
        return kaisyaMstService.searchCompaniesByName(name);
    }

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
            @RequestParam(name = "companyNameOutput", required = false) String companyName,
            @RequestParam(name = "soshikiNameOutput", required = false) String soshikiName,
            @RequestParam(name = "kengenKubun", required = false) Integer kengenKubun,
            Model model) {

            List<HyojiSearch> users = hyojiBtnService.hyojiSearchUsers(companyName, soshikiName, kengenKubun);
            model.addAttribute("users", users);
            return "stress/doctor-list";
        }
}
