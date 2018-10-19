package com.danny.echarts.controller.echarts;

import com.danny.echarts.controller.BaseController;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author Danny
 * @Title: LineController
 * @Description:
 * @Created on 2017-09-27 17:49:15
 */
@Controller
@RequestMapping("/echarts/line")
public class LineController extends BaseController {

    @RequestMapping("/line")
    public String line() {
        return prefix + "/line/echarts-line";
    }


}
