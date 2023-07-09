package JobDescription;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;


public class ProperDemo {

    public static void main(String[] args) throws IOException {

        String filepath = System.getProperty("user.dir");

        String filename = filepath + "/src/test/java/JobDescription/abc.properties";
        FileInputStream fis = null;
        try {
            Properties props = new Properties();
            fis = new FileInputStream(filename);
            props.load(fis);
            System.out.println(props.getProperty("Name"));

        } catch (Exception e) {

            System.out.println(e);
        }

    }
}
