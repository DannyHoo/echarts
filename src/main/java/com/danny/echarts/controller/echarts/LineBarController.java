package com.danny.echarts.controller.echarts;

import com.alibaba.fastjson.JSON;
import com.danny.echarts.controller.BaseController;
import com.github.abel533.echarts.*;
import com.github.abel533.echarts.axis.CategoryAxis;
import com.github.abel533.echarts.axis.ValueAxis;
import com.github.abel533.echarts.code.*;
import com.github.abel533.echarts.data.LineData;
import com.github.abel533.echarts.data.PointData;
import com.github.abel533.echarts.feature.*;
import com.github.abel533.echarts.json.GsonUtil;
import com.github.abel533.echarts.series.Bar;
import com.github.abel533.echarts.series.Funnel;
import com.github.abel533.echarts.series.Line;
import com.github.abel533.echarts.series.Pie;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author Danny
 * @Title: LineBarController
 * @Description:
 * @Created on 2017-09-27 17:49:57
 */
@Controller
@RequestMapping("/echarts/line_bar")
public class LineBarController extends BaseController {

    public static void main(String[] args) throws Exception {

        System.out.println(new LineBarController().getData_EChartsLineBar());

        /*String formatterFunction = new StringBuffer()
                .append("function(params) {")
                .append("var tooltipName=params[0].name;")
                .append("var res= tooltipName+\"<br/>\"+params[0].seriesName+\"：\"+params[0].data+\"<br/>\";")
                .append("var myseries = option.series;")
                .append("var data=myseries[0].data;")
                .append("var total=0;")
                .append("for (var i = 0; i < data.length; i++) {")
                .append("total+=data[i];")
                .append("}")
                .append("var percent=params[0].data/total;")
                .append("percent=Number(percent*100).toFixed(2)+\"%\";")
                .append("res+=params[1].seriesName+\"：\"+percent;")
                .append("return res;")
                .append("}")
                .toString();
        String a = "function(params) {var tooltipName=params[0].name;var res= tooltipName+\"<br/>\"+params[0].seriesName+\"：\"+params[0].data+\"<br/>\";var myseries = option.series;var data=myseries[0].data;var total=0;for (var i = 0; i < data.length; i++) {total+=data[i];}var percent=params[0].data/total;percent=Number(percent*100).toFixed(2)+\"%\";res+=params[1].seriesName+\"：\"+percentreturn res;}";
        System.out.println(formatterFunction);*/
    }

    @RequestMapping("/line-bar")
    public String line_bar() {
        return prefix + "/line-bar/echarts-line-bar";
    }

    @RequestMapping(value = "/getData_EChartsLineBar", method = RequestMethod.GET, produces = "text/json;charset=UTF-8")
    @ResponseBody
    public String getData_EChartsLineBar() throws Exception {

        Thread.sleep(1000);

        Option option = new Option();

        Title title = new Title();
        title.text("客户职业分布");
        title.subtext("实时统计");
        option.title(title);

        Tooltip tooltip = new Tooltip();
        tooltip.trigger(Trigger.axis);
        String formatterFunction = new StringBuffer()
                .append("function(params) {")
                .append("var tooltipName=params[0].name;")
                .append("var res= tooltipName+\"<br/>\"+params[0].seriesName+\"：\"+params[0].data+\"<br/>\";")
                .append("var myseries = option.series;")
                .append("var data=myseries[0].data;")
                .append("var total=0;")
                .append("for (var i = 0; i < data.length; i++) {")
                .append("total+=data[i];")
                .append("}")
                .append("var percent=params[0].data/total;")
                .append("percent=Number(percent*100).toFixed(2)+\"%\";")
                .append("res+=params[1].seriesName+\"：\"+percent;")
                .append("return res;")
                .append("}")
                .toString();
        tooltip.formatter(formatterFunction);
        option.tooltip(tooltip);

        Legend legend = new Legend();
        legend.data("人数", "占比");
        option.legend(legend);

        Toolbox toolbox = new Toolbox();
        toolbox.show(true);
        List<Feature> featureList = new ArrayList<Feature>();
        Mark mark = new Mark();
        mark.show(true);
        DataView dataView = new DataView();
        dataView.readOnly(true).readOnly(false);
        MagicType magicType = new MagicType(Magic.line, Magic.bar);
        magicType.show(true);
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

        option.xAxis(new CategoryAxis().type(AxisType.category).data("会计", "教师", "厨师", "理发师", "司机", "程序员"));
        option.yAxis(new ValueAxis());

        Bar bar = new Bar("人数").type(SeriesType.bar);
        List<Integer> list = Arrays.asList(20, 25, 30, 15, 10, 40);
        bar.setData(list);
        bar.markPoint().data(new PointData().name("最大值").type(MarkType.max), new PointData().name("最小值").type(MarkType.min));
        bar.markLine().data(new PointData().type(MarkType.average).name("平均值"));
        option.series(bar);

        Line line = new Line("占比").type(SeriesType.line);
        //line.addData(Arrays.asList(20, 25, 30, 15, 10, 40));
        line.markPoint().data(new PointData().name("最大值").type(MarkType.max), new PointData().name("最小值").type(MarkType.min));
        line.markLine().data(new PointData().type(MarkType.average).name("平均值"));
        option.series(line);


        String str = GsonUtil.format(option);
        str=str.replaceAll("\\\\", "");//去掉符号"\"
        return str;
    }


}
