package classloader;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

/**
 * Created by CharlesYang on 2018/7/12/012.
 */
public class ConfigurableStrategyDemo {
    public static IService createService(){
        try{
            Properties prop = new Properties();
            String filename = "data/config.properties";
            prop.load(new FileInputStream(filename));
            String className = prop.getProperty("service");
            Class<?> cls = Class.forName(className);
            return (IService) cls.newInstance();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
        return null;
    }

    public static void main(String[] args) {
        IService is = createService();
        is.action();;
    }
}
