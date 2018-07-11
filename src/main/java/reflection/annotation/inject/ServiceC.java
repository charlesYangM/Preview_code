package reflection.annotation.inject;

/**
 * Created by CharlesYang on 2018/7/10/010.
 */
@SimpleSingleton
public class ServiceC {
    public void actionC(){
        System.out.println(this.hashCode());
    }
}
