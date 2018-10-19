package t;

/**
 * @author Danny
 * @Title: BorrowerAgeScaleEnum
 * @Description: 客户年龄刻度枚举
 * @Created on 2017-10-10 18:25:05
 */
public enum BorrowerAgeScaleEnum{

    SCALE_3_YEARS_0_TO_18("3岁","18岁（含）以下",0,18),
    SCALE_3_YEARS_18_TO_21("3岁","18岁~21岁（含）",18,21),
    SCALE_3_YEARS_21_TO_24("3岁","21岁~24岁（含）",21,24),
    ;

    private String scale;//刻度
    private String description;//描述
    private Integer min;//最小值
    private Integer max;//最大值

    BorrowerAgeScaleEnum(String scale, String description, Integer min, Integer max) {
        this.scale = scale;
        this.description = description;
        this.min = min;
        this.max = max;
    }

    public String getScale() {
        return scale;
    }

    public BorrowerAgeScaleEnum setScale(String scale) {
        this.scale = scale;
        return this;
    }

    public String getDescription() {
        return description;
    }

    public BorrowerAgeScaleEnum setDescription(String description) {
        this.description = description;
        return this;
    }

    public Integer getMin() {
        return min;
    }

    public BorrowerAgeScaleEnum setMin(Integer min) {
        this.min = min;
        return this;
    }

    public Integer getMax() {
        return max;
    }

    public BorrowerAgeScaleEnum setMax(Integer max) {
        this.max = max;
        return this;
    }
}
