package Pages;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class RegisteringAUser {

    WebDriver driver;

    By clickonLogin = By.xpath("//a[contains(text(), 'Log in')]");
    By clickOnRegister = By.xpath("//button[@class='button-1 register-button']");
    By selectFemale = By.xpath("//label[contains(text(),'Female')]");
    By addFirstName = By.xpath("//input[@name = 'FirstName']");
    By addLastName = By.xpath("//input[@Name = 'LastName']");
    By addDate = By.xpath("//select[@Name = 'DateOfBirthDay']");
    By addMonth = By.xpath("//select[@Name = 'DateOfBirthMonth']");
    By addyear = By.xpath("//select[@Name = 'DateOfBirthYear']");
    By addEmail = By.xpath("//input[@Name = 'Email']");
    By addCompany = By.xpath("//input[@Name = 'Company']");
    By addpassword = By.xpath("//input[@Name = 'Password']");
    By addConfirmPasword = By.xpath("//input[@Name = 'ConfirmPassword']");
    By register = By.xpath("//button[@Name = 'register-button']");

    public RegisteringAUser(WebDriver driver)
    {
        this.driver = driver;
    }

    public void verify()
    {
        Assert.assertEquals(driver.findElement(By.xpath("//div[contains(text(), 'Your registration completed')]")).getText(),"Your registration completed");
    }

    public void signup()
    {
        driver.findElement(clickonLogin).click();
    }

    public void registeringAUser() throws IOException {

        driver.findElement(clickOnRegister).click();
        driver.findElement(selectFemale).click();
        driver.findElement(addFirstName).sendKeys("Karan");
        driver.findElement(addLastName).sendKeys("Singh");
        driver.findElement(addDate).sendKeys("4");
        driver.findElement(addMonth).sendKeys("October");
        driver.findElement(addyear).sendKeys("1995");
        driver.findElement(addEmail).sendKeys("Karan1555881@gmil.com");
        driver.findElement(addCompany).sendKeys("Infostride");
        String path = System.getProperty("user.dir") + "/src/test/java/TestData/Registration.xlsx";
        FileInputStream prop1 = null;
        try {
            prop1 = new FileInputStream(path);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        XSSFWorkbook wb = new XSSFWorkbook(prop1);
        XSSFSheet sheet = wb.getSheet("Sheet1");
        String enterPassword= sheet.getRow(1).getCell(0).getStringCellValue();
        String enterConfirmPassword= sheet.getRow(1).getCell(1).getStringCellValue();
        driver.findElement(addpassword).sendKeys(enterPassword);
        driver.findElement(addConfirmPasword).sendKeys(enterConfirmPassword);
        driver.findElement(register).click();
    }
}
