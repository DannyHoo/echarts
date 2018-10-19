package com.danny.echarts.controller.echarts;

import com.danny.echarts.controller.BaseController;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author Danny
 * @Title: BarController
 * @Description:
 * @Created on 2017-09-27 17:49:07
 */
@Controller
@RequestMapping("/echarts/bar")
public class BarController  extends BaseController {

    @RequestMapping("/echarts-bar")
    public String bar1() {
        return prefix + "/bar/echarts-bar";
    }

}
