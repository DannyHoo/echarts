package t;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Danny
 * @Title: AgeScale
 * @Description:
 * @Created on 2017-10-11 14:48:59
 */
public class AgeScale {
    private static AgeScale ageScale;
    private static List<Scale> YEARS_3;
    private static List<Scale> YEARS_5;
    private static List<Scale> YEARS_10;

    private AgeScale(){}

    public static AgeScale getInstalce(){
        if (ageScale==null){
            synchronized (AgeScale.class){
                ageScale=new AgeScale();
                init(ageScale);
            }
        }
        return ageScale;
    }

    private static void init(AgeScale ageScale) {
        ageScale.YEARS_3=getYears3();

        ageScale.YEARS_5=new ArrayList<Scale>(10);
        ageScale.YEARS_10=new ArrayList<Scale>(6);
    }

    private static List<Scale> getYears3(){
        List<Scale> scaleList=new ArrayList<>(16);
        scaleList.add(new Scale("18岁（含）以下",0,18));
        scaleList.add(new Scale("18岁~21岁（含）",0,18));
        scaleList.add(new Scale("21岁~24岁（含）",0,18));
        scaleList.add(new Scale("24岁~27岁（含）",0,18));
        scaleList.add(new Scale("27岁~30岁（含）",0,18));
        scaleList.add(new Scale("30岁~33岁（含）",0,18));
        scaleList.add(new Scale("33岁~36岁（含）",0,18));
        scaleList.add(new Scale("36岁~39岁（含）",0,18));
        scaleList.add(new Scale("39岁~42岁（含）",0,18));
        scaleList.add(new Scale("42岁~45岁（含）",0,18));
        scaleList.add(new Scale("45岁~48岁（含）",0,18));
        scaleList.add(new Scale("48岁~51岁（含）",0,18));
        scaleList.add(new Scale("51岁~54岁（含）",0,18));
        scaleList.add(new Scale("54岁~57岁（含）",0,18));
        scaleList.add(new Scale("57岁~60岁（含）",0,18));
        scaleList.add(new Scale("60岁以上",0,18));
        return scaleList;
    }

    private static List<Scale> getYears5(){
        List<Scale> scaleList=new ArrayList<>(10);
        scaleList.add(new Scale("18岁（含）以下",0,18));
        scaleList.add(new Scale("18岁~21岁（含）",0,18));
        scaleList.add(new Scale("21岁~24岁（含）",0,18));
        scaleList.add(new Scale("24岁~27岁（含）",0,18));
        scaleList.add(new Scale("27岁~30岁（含）",0,18));
        scaleList.add(new Scale("30岁~33岁（含）",0,18));
        scaleList.add(new Scale("33岁~36岁（含）",0,18));
        scaleList.add(new Scale("36岁~39岁（含）",0,18));
        scaleList.add(new Scale("39岁~42岁（含）",0,18));
        scaleList.add(new Scale("42岁~45岁（含）",0,18));
        scaleList.add(new Scale("45岁~48岁（含）",0,18));
        scaleList.add(new Scale("48岁~51岁（含）",0,18));
        scaleList.add(new Scale("51岁~54岁（含）",0,18));
        scaleList.add(new Scale("54岁~57岁（含）",0,18));
        scaleList.add(new Scale("57岁~60岁（含）",0,18));
        scaleList.add(new Scale("60岁以上",0,18));
        return scaleList;
    }

    private static List<Scale> getYears10(){
        List<Scale> scaleList=new ArrayList<>(6);
        scaleList.add(new Scale("18岁（含）以下",0,18));
        scaleList.add(new Scale("18岁~21岁（含）",0,18));
        scaleList.add(new Scale("21岁~24岁（含）",0,18));
        scaleList.add(new Scale("24岁~27岁（含）",0,18));
        scaleList.add(new Scale("27岁~30岁（含）",0,18));
        scaleList.add(new Scale("30岁~33岁（含）",0,18));
        scaleList.add(new Scale("33岁~36岁（含）",0,18));
        scaleList.add(new Scale("36岁~39岁（含）",0,18));
        scaleList.add(new Scale("39岁~42岁（含）",0,18));
        scaleList.add(new Scale("42岁~45岁（含）",0,18));
        scaleList.add(new Scale("45岁~48岁（含）",0,18));
        scaleList.add(new Scale("48岁~51岁（含）",0,18));
        scaleList.add(new Scale("51岁~54岁（含）",0,18));
        scaleList.add(new Scale("54岁~57岁（含）",0,18));
        scaleList.add(new Scale("57岁~60岁（含）",0,18));
        scaleList.add(new Scale("60岁以上",0,18));
        return scaleList;
    }

    public static List<Scale> getYEARS_3(){
        return YEARS_3;
    }
    public static List<Scale> getYEARS_5(){
        return YEARS_5;
    }
    public static List<Scale> getYEARS_10(){
        return YEARS_10;
    }
}
