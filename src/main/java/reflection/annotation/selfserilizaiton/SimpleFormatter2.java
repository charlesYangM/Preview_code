package reflection.annotation.selfserilizaiton;

import java.lang.reflect.Field;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.TimeZone;

/**
 * Created by CharlesYang on 2018/7/10/010.
 */
public class SimpleFormatter2 {


    public static void main(String[] args) throws Exception {

        System.out.println("hah ");

        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-mm-dd");
        Student zhangs = new Student("张三", sdf.parse("1990-12-12"), 90.2);
        System.out.println(SimpleFormatter2.format(zhangs));
    }

    public static final String format(Object obj){
        try {
            Class<?> cls = obj.getClass();
            StringBuilder sb = new StringBuilder();

            for (Field f : cls.getDeclaredFields()){
                if (!f.isAccessible()){
                    f.setAccessible(true);
                }

                Label label = f.getAnnotation(Label.class);
                String name = label != null ? label.value() : f.getName();
                Object value = f.get(obj);
                if (value != null && f.getType() == Date.class){
                    value = formatDate(f, value);
                }

                sb.append(name + ": " + value + "\n");
            }
            return sb.toString();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
        return null;
    }

    private static Object formatDate(Field f, Object value) {

        Format format = f.getAnnotation(Format.class);
        if (format != null){
            SimpleDateFormat sdf = new SimpleDateFormat(format.pattern());
            sdf.setTimeZone(TimeZone.getTimeZone(format.timezone()));
            return sdf.format(value);
        }
        return value;
    }

}
