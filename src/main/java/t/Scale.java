package t;

/**
 * @author Danny
 * @Title: Scale
 * @Description:
 * @Created on 2017-10-11 14:46:22
 */
public class Scale {
    private String range;
    private Integer min;
    private Integer max;

    public Scale() {
    }

    public Scale(String range, Integer min, Integer max) {
        this.range = range;
        this.min = min;
        this.max = max;
    }

    public String getRange() {
        return range;
    }

    public Scale setRange(String range) {
        this.range = range;
        return this;
    }

    public Integer getMin() {
        return min;
    }

    public Scale setMin(Integer min) {
        this.min = min;
        return this;
    }

    public Integer getMax() {
        return max;
    }

    public Scale setMax(Integer max) {
        this.max = max;
        return this;
    }
}
