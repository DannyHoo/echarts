package t.statistics;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Danny
 * @Title: BorrowerProfessionEnum
 * @Description: 客户职业枚举
 * @Created on 2017-10-17 10:14:04
 */
public enum BorrowerProfessionEnum implements AssetStatistics {
    DEFAULT(0,"默认"),
    GOVERNMENT_ENTERPRISE_INSTITUTION(10, "国家机关、企事业单位负责人"),
    PROFESSIONALS(20, "专业技术人员"),
    CLERKS(30, "办事人员和有关人员"),
    BUSINESS_OR_SERVICE(40, "商业、服务业人员"),
    AGRICULTURE_FORESTRY_HUSBANDRY_FISHERY(50, "农、林、牧、渔、水利业生产人员"),
    PRODUCE_TRANSPORT(60, "生产、运输设备操作人员及有关人员"),
    SOLDIER(70, "军人"),
    OTHER(80, "其他从业人员");

    private int code;
    private String description;

    BorrowerProfessionEnum(int code, String description) {
        this.code = code;
        this.description = description;
    }

    public int getCode() {
        return code;
    }

    public BorrowerProfessionEnum setCode(int code) {
        this.code = code;
        return this;
    }

    public String getDescription() {
        return description;
    }

    public BorrowerProfessionEnum setDescription(String description) {
        this.description = description;
        return this;
    }

    public Map<String, String> getValueMap() {
        Map<String, String> valueMap = new HashMap<String, String>();
        BorrowerProfessionEnum[] enums = BorrowerProfessionEnum.values();
        for (BorrowerProfessionEnum e : enums) {
            valueMap.put(String.valueOf(e.getCode()), e.getDescription());
        }
        return valueMap;
    }
}
