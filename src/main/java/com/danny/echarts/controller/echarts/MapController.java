package com.danny.echarts.controller.echarts;

import com.danny.echarts.controller.BaseController;
import com.github.abel533.echarts.*;
import com.github.abel533.echarts.Data;
import com.github.abel533.echarts.code.*;
import com.github.abel533.echarts.data.*;
import com.github.abel533.echarts.feature.DataView;
import com.github.abel533.echarts.feature.Feature;
import com.github.abel533.echarts.feature.Restore;
import com.github.abel533.echarts.feature.SaveAsImage;
import com.github.abel533.echarts.json.GsonUtil;
import com.github.abel533.echarts.series.EMap;
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
 * @Title: MapController
 * @Description:
 * @Created on 2017-09-27 17:49:26
 */
@Controller
@RequestMapping("/echarts/map")
public class MapController extends BaseController {

    @RequestMapping("/map")
    public String map() {
        return prefix + "/map/echarts-map";
    }

    @RequestMapping(value="/getData_EChartsMap",method = RequestMethod.GET, produces = "text/json;charset=UTF-8")
    @ResponseBody
    public String getData_EChartsMap(){
        //地址：http://gallery.echartsjs.com/editor.html?c=map-china-dataRange
        Option option = new Option();

        Title title = new Title();
        title.text("客户区域分布");
        title.subtext("实时统计");
        title.x("center");
        option.title(title);

        Tooltip tooltip = new Tooltip();
        tooltip.trigger(Trigger.item);
        option.tooltip(tooltip);

        Legend legend = new Legend();
        legend.orient(Orient.vertical);
        legend.x(X.left);
        legend.data("客户区域分布");
        option.legend(legend);

        VisualMap visualMap = new VisualMap();
        visualMap.min();
        visualMap.max();
        visualMap.left();
        visualMap.top();
        String[] visualMapText = new String[]{"高", "低"};
        visualMap.text(visualMapText);
        visualMap.calculable(true);
        visualMap.max(1000);
        visualMap.min(0);
        List<VisualMap> visualMapList = new ArrayList<VisualMap>();
        visualMapList.add(visualMap);
        option.visualMap(visualMapList);

        Toolbox toolbox = new Toolbox();
        toolbox.show(true);
        toolbox.orient(Orient.vertical);
        toolbox.left(X.right);
        toolbox.top(Y.center);
        Feature feature = new Feature();
        List<Feature> featureList = new ArrayList<Feature>();
        DataView dataView = new DataView();
        dataView.readOnly(true);
        Restore restore = new Restore();
        SaveAsImage saveAsImage = new SaveAsImage();
        featureList.add(dataView);
        featureList.add(restore);
        featureList.add(saveAsImage);
        toolbox.feature(featureList);
        option.toolbox(toolbox);

        EMap map = new EMap("客户区域分布");
        map.type(SeriesType.map);
        map.mapType("china");//中国地图用china；省份地图用汉语简称如"北京"、"河北"等
        map.roam(false);
        /*Label label=new Label();
        Normal normal=new Normal().show(true);
        Emphasis emphasis=new Emphasis().show(true);*/
        map.label().normal(new Normal().show(true));
        map.label().emphasis(new Emphasis().show(true));

        // TODO: 17/10/19
        //map.addData(getDataList());//data方法一次只能放一条数据，如果放多条数据，循环放入

        option.series(map);

        String str = GsonUtil.format(option);
        return str;
    }

    public List<com.github.abel533.echarts.data.Data> getDataList() {
        List<com.github.abel533.echarts.data.Data> dataList = new ArrayList();
        dataList.add(new com.github.abel533.echarts.data.Data("北京").value(Math.round(Math.random() * 1000)));
        dataList.add(new com.github.abel533.echarts.data.Data("天津").value(Math.round(Math.random() * 1000)));
        dataList.add(new com.github.abel533.echarts.data.Data("上海").value(Math.round(Math.random() * 1000)));
        dataList.add(new com.github.abel533.echarts.data.Data("重庆").value(Math.round(Math.random() * 1000)));
        dataList.add(new com.github.abel533.echarts.data.Data("河北").value(Math.round(Math.random() * 1000)));
        dataList.add(new com.github.abel533.echarts.data.Data("河南").value(Math.round(Math.random() * 1000)));
        dataList.add(new com.github.abel533.echarts.data.Data("云南").value(Math.round(Math.random() * 1000)));
        dataList.add(new com.github.abel533.echarts.data.Data("辽宁").value(Math.round(Math.random() * 1000)));
        dataList.add(new com.github.abel533.echarts.data.Data("黑龙江").value(Math.round(Math.random() * 1000)));
        dataList.add(new com.github.abel533.echarts.data.Data("湖南").value(Math.round(Math.random() * 1000)));
        dataList.add(new com.github.abel533.echarts.data.Data("安徽").value(Math.round(Math.random() * 1000)));
        dataList.add(new com.github.abel533.echarts.data.Data("山东").value(Math.round(Math.random() * 1000)));
        dataList.add(new com.github.abel533.echarts.data.Data("新疆").value(Math.round(Math.random() * 1000)));
        dataList.add(new com.github.abel533.echarts.data.Data("江苏").value(Math.round(Math.random() * 1000)));
        dataList.add(new com.github.abel533.echarts.data.Data("浙江").value(Math.round(Math.random() * 1000)));
        dataList.add(new com.github.abel533.echarts.data.Data("江西").value(Math.round(Math.random() * 1000)));
        dataList.add(new com.github.abel533.echarts.data.Data("湖北").value(Math.round(Math.random() * 1000)));
        dataList.add(new com.github.abel533.echarts.data.Data("广西").value(Math.round(Math.random() * 1000)));
        dataList.add(new com.github.abel533.echarts.data.Data("甘肃").value(Math.round(Math.random() * 1000)));
        dataList.add(new com.github.abel533.echarts.data.Data("山西").value(Math.round(Math.random() * 1000)));
        dataList.add(new com.github.abel533.echarts.data.Data("内蒙古").value(Math.round(Math.random() * 1000)));
        dataList.add(new com.github.abel533.echarts.data.Data("陕西").value(Math.round(Math.random() * 1000)));
        dataList.add(new com.github.abel533.echarts.data.Data("吉林").value(Math.round(Math.random() * 1000)));
        dataList.add(new com.github.abel533.echarts.data.Data("福建").value(Math.round(Math.random() * 1000)));
        dataList.add(new com.github.abel533.echarts.data.Data("贵州").value(Math.round(Math.random() * 1000)));
        dataList.add(new com.github.abel533.echarts.data.Data("广东").value(Math.round(Math.random() * 1000)));
        dataList.add(new com.github.abel533.echarts.data.Data("青海").value(Math.round(Math.random() * 1000)));
        dataList.add(new com.github.abel533.echarts.data.Data("西藏").value(Math.round(Math.random() * 1000)));
        dataList.add(new com.github.abel533.echarts.data.Data("四川").value(Math.round(Math.random() * 1000)));
        dataList.add(new com.github.abel533.echarts.data.Data("宁夏").value(Math.round(Math.random() * 1000)));
        dataList.add(new com.github.abel533.echarts.data.Data("海南").value(Math.round(Math.random() * 1000)));
        dataList.add(new com.github.abel533.echarts.data.Data("台湾").value(Math.round(Math.random() * 1000)));
        dataList.add(new com.github.abel533.echarts.data.Data("香港").value(Math.round(Math.random() * 1000)));
        dataList.add(new com.github.abel533.echarts.data.Data("澳门").value(Math.round(Math.random() * 1000)));
        return dataList;
    }
}
