package components;

import com.github.abel533.echarts.*;
import com.github.abel533.echarts.code.*;
import com.github.abel533.echarts.data.*;
import com.github.abel533.echarts.feature.DataView;
import com.github.abel533.echarts.feature.Feature;
import com.github.abel533.echarts.feature.Restore;
import com.github.abel533.echarts.feature.SaveAsImage;
import com.github.abel533.echarts.series.EMap;
import com.github.abel533.echarts.style.itemstyle.Emphasis;
import com.github.abel533.echarts.style.itemstyle.Normal;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Danny
 * @Title: MapChartFactory
 * @Description:
 * @Created on 2017-09-28 10:28:35
 */
public class MapChartFactory {

    public static Option createDefaultMapOption(String titleText,List<com.github.abel533.echarts.data.Data> mapData){

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
        legend.data("客户区域分布");//名字要和Series-Map的name一致
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
        map.label().normal(new Normal().show(true));
        map.label().emphasis(new Emphasis().show(true));

//        map.addData(mapData);//data方法一次只能放一条数据，如果放多条数据，循环放入 // TODO: 此处修改了源码

        option.series(map);

        return option;
    }
}
