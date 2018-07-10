package entity;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 * Created by CharlesYang on 2018/7/3/003.
 */
public class User {

    @NotNull
    @Max(5)
    @Min(2)
    private int age;

    @Override
    public String toString() {
        return "User{" +
                "age=" + age +
                ", username='" + username + '\'' +
                '}';
    }

    @NotNull
    @Size(min = 5, max = 18)
    private String username;

    public User(int age, String username){
        this.age = age;
        this.username =username;
    }
    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }
}
