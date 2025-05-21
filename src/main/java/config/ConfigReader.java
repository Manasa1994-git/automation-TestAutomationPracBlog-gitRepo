package config;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class ConfigReader {
    private Properties prop;

    public ConfigReader() {
        try {
            prop = new Properties();
            FileInputStream fis = new FileInputStream("config/config.properties");
            prop.load(fis);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public String getBaseUrl() {
        return prop.getProperty("baseUrl");
    }

    public String getBrowser() {
        return prop.getProperty("browser");
    }

    public int getImplicitWait() {
        return Integer.parseInt(prop.getProperty("implicitWait"));
    }
}
