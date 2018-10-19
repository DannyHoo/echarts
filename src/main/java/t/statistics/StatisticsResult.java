package t.statistics;

/**
 * @author Danny
 * @Title: StatisticsResult
 * @Description: 统计结果
 * @Created on 2017-10-12 11:24:36
 */
public class StatisticsResult {

    private String title;
    private int contractNum;
    private double percent;

    public StatisticsResult() {
    }

    public StatisticsResult(String title, int contractNum) {
        this.title = title;
        this.contractNum = contractNum;
    }

    public StatisticsResult(String title, int contractNum, double percent) {
        this.title = title;
        this.contractNum = contractNum;
        this.percent = percent;
    }

    public String getTitle() {
        return title;
    }

    public StatisticsResult setTitle(String title) {
        this.title = title;
        return this;
    }

    public int getContractNum() {
        return contractNum;
    }

    public StatisticsResult setContractNum(int contractNum) {
        this.contractNum = contractNum;
        return this;
    }

    public double getPercent() {
        return percent;
    }

    public StatisticsResult setPercent(double percent) {
        this.percent = percent;
        return this;
    }
}
