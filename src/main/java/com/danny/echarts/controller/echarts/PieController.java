package com.danny.echarts.controller.echarts;

import com.danny.echarts.controller.BaseController;
import com.github.abel533.echarts.*;
import com.github.abel533.echarts.Data;
import com.github.abel533.echarts.code.*;
import com.github.abel533.echarts.data.*;
import com.github.abel533.echarts.feature.*;
import com.github.abel533.echarts.json.GsonUtil;
import com.github.abel533.echarts.series.EMap;
import com.github.abel533.echarts.series.Funnel;
import com.github.abel533.echarts.series.Pie;
import com.github.abel533.echarts.style.itemstyle.Emphasis;
import com.github.abel533.echarts.style.itemstyle.Normal;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Danny
 * @Title: PieController
 * @Description:
 * @Created on 2017-09-27 17:49:46
 */
@Controller
@RequestMapping("/echarts/pie")
public class PieController extends BaseController {

    @RequestMapping("/pie")
    public String pie() {
        return prefix + "/pie/echarts-pie";
    }

    @RequestMapping(value = "/getData_EChartsPie", method = RequestMethod.GET, produces = "text/json;charset=UTF-8")
    @ResponseBody
    public String getData_EChartsPie() throws Exception {
        Option option = new Option();

        Title title = new Title();
        title.text("客户性别分布");
        title.subtext("实时统计");
        title.x("center");
        option.title(title);

        Tooltip tooltip = new Tooltip();
        tooltip.trigger(Trigger.item);
        tooltip.formatter("{a} <br/>{b} : {c} ({d}%)");
        option.tooltip(tooltip);

        Legend legend = new Legend();
        legend.orient(Orient.vertical);
        legend.x(X.left);
        legend.data("男", "女");
        option.legend(legend);

        Toolbox toolbox = new Toolbox();
        toolbox.show(true);

        toolbox.orient(Orient.vertical);
        toolbox.left(X.right);
        toolbox.top(Y.center);
        List<Feature> featureList = new ArrayList<Feature>();
        Mark mark = new Mark();
        mark.show(true);
        DataView dataView = new DataView();
        dataView.readOnly(true).readOnly(false);

        MagicType magicType = new MagicType(Magic.pie, Magic.funnel);
        magicType.show(true);
        Funnel funnel = new Funnel();
        funnel.x("25%").width("50%").funnelAlign(X.left).max(1548);
        MagicType.Option maticTypeOption = new MagicType.Option();
        maticTypeOption.funnel(funnel);
        magicType.option(maticTypeOption);
        Restore restore = new Restore();
        restore.show(true);
        SaveAsImage saveAsImage = new SaveAsImage();
        saveAsImage.show(true);
        featureList.add(mark);
        featureList.add(dataView);
        featureList.add(magicType);
        featureList.add(restore);
        featureList.add(saveAsImage);
        toolbox.feature(featureList);
        option.toolbox(toolbox);

        option.calculable(true);

        Pie pie=new Pie("客户性别分布");
        pie.type(SeriesType.pie).radius("55%").center("50%","60%");
        //pie.addData(getDataList());

        option.series(pie);

        String str = GsonUtil.format(option);
        return str;
    }

    public List<com.github.abel533.echarts.data.Data> getDataList() {
        List<com.github.abel533.echarts.data.Data> dataList = new ArrayList();
        dataList.add(new com.github.abel533.echarts.data.Data("男").value(345));
        dataList.add(new com.github.abel533.echarts.data.Data("女").value(354));
        return dataList;
    }
}
