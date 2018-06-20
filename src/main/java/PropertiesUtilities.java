import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class PropertiesUtilities {
    static Properties prop = new Properties();
    static InputStream input = null;

    public static void setPath() {

        try {
            input = new FileInputStream("./src/main/resources/apitests.properties");
            prop.load(input);
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }



    public static String getData(String data)

    {
        String prop_data = "";
        try {

            prop_data = prop.getProperty(data);


        } catch (Exception ex)

        {
            ex.printStackTrace();
        } finally {

            if (input != null) {
                try {
                    input.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }

        }
        return prop_data;
    }
}
