package t.statistics;

import com.alibaba.fastjson.JSON;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * @author Danny
 * @Title: Main
 * @Description:
 * @Created on 2017-10-12 15:39:59
 */
public class Main {
    public static void main(String[] args) {

        Map<String, String> valueMap=getValueMap(BorrowerProfessionEnum.DEFAULT);
        List<StatisticsResult> statisticsResultList = getStatisticsResultList();
        filter(statisticsResultList);
        System.out.println(JSON.toJSONString(statisticsResultList));
    }

    private static Map<String,String> getValueMap(AssetStatistics a) {
        Map<String, String> valueMap=a.getValueMap();
        return valueMap;
    }

    private static List<StatisticsResult> getStatisticsResultList() {
        List<StatisticsResult> statisticsResultList = new ArrayList<>();
        statisticsResultList.add(new StatisticsResult("北京市", 30));
        statisticsResultList.add(new StatisticsResult("河北省", 30));
        statisticsResultList.add(new StatisticsResult("云南省", 30));
        statisticsResultList.add(new StatisticsResult("", 10));//未统计
        //statisticsResultList.add(new StatisticsResult("河南省", 10));
        return statisticsResultList;
    }

    public static void filter(List<StatisticsResult> statisticsResultList){
        int contractTotalNum=0;
        double totalPercent=0;

        //计算合同总数
        for (StatisticsResult s:statisticsResultList){
            contractTotalNum+=s.getContractNum();
        }
        //设置每个统计项所占比例
        for (int i=0;i<statisticsResultList.size();i++){
            DecimalFormat df = new DecimalFormat("0.00");//保留两位小数
            String strPercent = df.format((float)statisticsResultList.get(i).getContractNum()/contractTotalNum);
            double percent=Double.valueOf(strPercent);
            if (i==statisticsResultList.size()-1){//最后一项
                double nowPercent=Double.valueOf(df.format(1-totalPercent));
                statisticsResultList.get(i).setPercent(nowPercent);
            }else{
                statisticsResultList.get(i).setPercent(percent);
            }
            totalPercent+=percent;

            //判断本行是否为"未统计"
            if (isBlank(statisticsResultList.get(i).getTitle())){
                statisticsResultList.get(i).setTitle("未统计");
            }
        }

        statisticsResultList.add(new StatisticsResult("合计",contractTotalNum,1));
    }

    public static boolean isBlank(String str){
        if (str==null||str.equals("")){
            return true;
        }
        return false;
    }
}
