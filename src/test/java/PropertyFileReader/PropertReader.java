package PropertyFileReader;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class PropertReader {

    private Properties prop ;

    public void readPropertyfile() {


        prop = new Properties();

        try
        {
            FileInputStream file = new FileInputStream("D:\\Users\\Sairaghavendra\\IdeaProjects\\LearningSelenium\\src\\test\\resources\\Properties\\Config.properties");

            prop.load(file);

        } catch (FileNotFoundException e) {
            System.out.println(e.getMessage());


        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }


    public String  getProperty(String key) {


        return prop.getProperty(key);
    }

}
