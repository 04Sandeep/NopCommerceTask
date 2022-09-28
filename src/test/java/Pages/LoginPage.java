package Pages;

import StepDefinition.BaseClass;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class LoginPage extends BaseClass {
    WebDriver driver;
    WebDriverWait wait;

    By enterEmail = By.name("Email");
    By enterPassword = By.name("Password");
    By loginButton = By.xpath("//button[@class='button-1 login-button']");
    By userLogout = By.xpath("//a[contains(text(), 'Logout')]");

    public LoginPage(WebDriver driver)
    {
        this.driver = driver;
        wait = new WebDriverWait(driver,4);
    }

    public void loginPage() throws IOException {

        wait.until(ExpectedConditions.elementToBeClickable(enterEmail));
        String path = System.getProperty("user.dir") + "/src/test/java/TestData/Book1.xlsx";
        FileInputStream prop1 = null;
        try {
            prop1 = new FileInputStream(path);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        XSSFWorkbook wb = new XSSFWorkbook(prop1);
        XSSFSheet sheet = wb.getSheet("Sheet1");
        String enteruserName = sheet.getRow(1).getCell(0).getStringCellValue();
        String enteruserPassword = sheet.getRow(1).getCell(1).getStringCellValue();
        driver.findElement(enterEmail).sendKeys(enteruserName);
        driver.findElement(enterPassword).sendKeys(enteruserPassword);
        driver.findElement(loginButton).click();
    }

    public void logout()
    {
        driver.findElement(userLogout).click();
    }
}



