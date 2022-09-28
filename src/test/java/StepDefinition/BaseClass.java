package StepDefinition;

import PageFactory.ObjectPageFactory;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class BaseClass {
    public static Properties prop;
    public static WebDriver driver;
    public static ObjectPageFactory objectPageFactory;

    public BaseClass()
    {

        try {
            prop = new Properties();
            FileInputStream ip = new FileInputStream("C:\\Users\\SandeepKaur\\IdeaProjects\\demo\\ThursdayTask\\src\\test\\java\\PropertiesFile\\config.properties");
            prop.load(ip);
        }
        catch (FileNotFoundException e)
        {
            e.printStackTrace();
        } catch (IOException e)
        {
            e.printStackTrace();
        }
    }

    @BeforeClass

    public void initialization()
    {
        String browsername = prop.getProperty("browser");

        if (browsername.equals("chrome"))
        {
            WebDriverManager.chromedriver().setup();
            driver = new ChromeDriver();
            driver.manage().window().maximize();
            driver.get(prop.getProperty("url"));
            objectPageFactory = new ObjectPageFactory(driver);
        }
        else if (browsername.equals("FireFox"))
        {
            WebDriverManager.firefoxdriver().setup();
            driver = new FirefoxDriver();
            driver.manage().window().maximize();
            driver.get(prop.getProperty("url"));
            objectPageFactory = new ObjectPageFactory(driver);
        }
    }

    @AfterClass

    public void closebrowser()
    {
        driver.close();
    }
}



