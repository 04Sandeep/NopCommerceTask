package Pages;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import static StepDefinition.BaseClass.prop;

public class SearchingAProduct {
    WebDriver driver;

    By enterUserEmail = By.name("Email");
    By enterUserPassword = By.name("Password");
    By clickOnLogin = By.xpath("//button[@class= 'button-1 login-button']");
    By search = By.xpath("//input[@type='text']");
    By clickOnSearch = By.xpath("//button[@type='submit']");
    By clickOnLogout = By.xpath("//a[contains(text(), 'Log out')]");

    public SearchingAProduct(WebDriver driver) {
        this.driver = driver;
    }

    public void Login() {

        driver.findElement(enterUserEmail).sendKeys(prop.getProperty("Email"));
        driver.findElement(enterUserPassword).sendKeys(prop.getProperty("Password"));
        driver.findElement(clickOnLogin).click();
    }
    public void searchingAPage() throws IOException {

            String path = System.getProperty("user.dir") + "/src/test/java/TestData/Searching.xlsx";
            FileInputStream prop1 = null;
            try {
                prop1 = new FileInputStream(path);
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            }
            XSSFWorkbook wb = new XSSFWorkbook(prop1);
            XSSFSheet sheet = wb.getSheet("Sheet1");
            String searchingProduct = sheet.getRow(1).getCell(0).getStringCellValue();
            driver.findElement(search).sendKeys(searchingProduct);
            driver.findElement(clickOnSearch).click();
       }

       public void verifiction()
       {
           String actual = driver.findElement(By.xpath("//h1[contains(text(),'Search')]")).getText();
           Assert.assertEquals(actual.equals("Search"), "Expected result does not match with actual result");

       }
    public void logout()
    {
        driver.findElement(clickOnLogout).click();
    }
}
