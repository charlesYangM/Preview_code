package reflection;

import java.lang.reflect.Field;

/**
 * Created by CharlesYang on 2018/7/9/009.
 */
public class SimpleMapperDemo {
    static class Student{
        String name;
        int age;
        double score;

        public Student() {
        }

        public Student(String name, int age, double score) {
            this.name = name;
            this.age = age;
            this.score = score;
        }

        public String getName() {
            return name;
        }

        @Override
        public String toString() {
            return "Student{" +
                    "name='" + name + '\'' +
                    ", age=" + age +
                    ", score=" + score +
                    '}';
        }

        public void setName(String name) {
            this.name = name;
        }

        public int getAge() {
            return age;
        }

        public void setAge(int age) {
            this.age = age;
        }

        public double getScore() {
            return score;
        }

        public void setScore(double score) {
            this.score = score;
        }


    }
    public static String toString(Object obj){
        try{
            Class<?> cls = obj.getClass();
            StringBuilder sb = new StringBuilder();
            sb.append(cls.getName() + "\n");
            for (Field f : cls.getDeclaredFields()){
                if (!f.isAccessible()){
                    f.setAccessible(true);
                }
                sb.append(f.getName() + "=" + f.get(obj).toString() + "\n");

            }
            return sb.toString();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
        return null;
    }

    public static Object fromString(String str){
        try{
            String[] lines = str.split("\n");
            if (lines.length < 1){
                throw new IllegalArgumentException(str);
            }
            Class<?> cls = Class.forName(lines[0]);
            Object obj = cls.newInstance();

            if (lines.length > 1){
                for (int i = 1; i < lines.length; i++) {
                    String[] fv = lines[i].split("=");
                    if (fv.length != 2){
                        throw new IllegalArgumentException(lines[i]);
                    }
                    Field f = cls.getDeclaredField(fv[0]);
                    if (!f.isAccessible()){
                        f.setAccessible(true);
                    }
                    setFieldValue(f, obj, fv[1]);
                }
            }
            return obj;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    private static void setFieldValue(Field f, Object obj, String value) throws Exception {
        Class<?> type = f.getType();
        if (type == int.class){
            f.setInt(obj, Integer.parseInt(value));
        }else if (type == String.class){
            f.set(obj, value);
        }else if (type == double.class){
            f.setDouble(obj, Double.parseDouble(value));
        }
    }
    public static void main(String[] args) {
        Student zhangsna = new Student("张三", 18, 89d);
        String str = SimpleMapperDemo.toString(zhangsna);
        Student zs2 = (Student) SimpleMapperDemo.fromString(str);
        System.out.println(zs2);
    }
}
