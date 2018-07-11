package reflection.annotation.selfserilizaiton;

import java.util.Date;

/**
 * Created by CharlesYang on 2018/7/10/010.
 */
public class Student {

    @Label("姓名")
    String name;

    @Label("出生日期")
    @Format(pattern = "yyyy/mm/ss")
    Date born;

    @Label("分数")
    double score;

    public Student(String name, Date born, double score) {
        this.name = name;
        this.born = born;
        this.score = score;
    }
}
