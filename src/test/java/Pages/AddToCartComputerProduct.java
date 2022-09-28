package Pages;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;


public class AddToCartComputerProduct {
    WebDriver driver;

    By clickOnLogin = By.xpath("//a[contains(text(), 'Log in')]");
    By enterUserEmail = By.name("Email");
    By enterUserPassword = By.name("Password");
    By ClickLoginButton = By.xpath("//button[@class= 'button-1 login-button']");
    By clickOnComputer = By.xpath("//a[contains(text(), 'Computers')]");
    By clickOnNotebooks = By.xpath("//a[@title = 'Show products in category Notebooks']");
    By clickonNotebookType = By.xpath("//a[contains(text(), 'Asus N551JK-XO076H Laptop')]");
    By clickOnAddToCart = By.xpath("//button[@class = 'button-2 product-box-add-to-cart-button']");
    By clickOnAddCartItem = By.xpath("//button[@class = 'button-1 add-to-cart-button']");
    By clickOnShoppingCart = By.xpath("//span[contains(text(), 'Shopping cart')]");
    By clickOnTerms = By.xpath("//input[@name = 'termsofservice']");
    By clickOnCheckout = By.xpath("//button[@name = 'checkout']");
    By clickonContinue = By.xpath("//a[@class='button-1 register-continue-button']");
    By addCountry = By.xpath("//select[@name='BillingNewAddress.CountryId']");
    By enterCity = By.xpath("//input[@name = 'BillingNewAddress.City']");
    By enterAddress = By.xpath("//input[@name = 'BillingNewAddress.Address1']");
    By enterPostCode = By.xpath("//input[@name = 'BillingNewAddress.ZipPostalCode']");
    By enterPhoneNumber = By.xpath("//input[@name = 'BillingNewAddress.PhoneNumber']");
    By save = By.xpath("//button[@name = 'save']");
    By continueButton = By.xpath("//button[@class = 'button-1 shipping-method-next-step-button']");
    By againContinue = By.xpath("//button[@class = 'button-1 payment-method-next-step-button']");
    By continueInfo = By.xpath("//button[@class = 'button-1 payment-info-next-step-button']");
    By clickOnConfirm = By.xpath("//button[@class = 'button-1 confirm-order-next-step-button']");
    By clickOnLogout= By.xpath("//a[contains(text(), 'Log out')]");

    public AddToCartComputerProduct(WebDriver driver)
    {
        this.driver = driver;
    }

    public void userLogin()
    {
        driver.findElement(clickOnLogin).click();
        driver.findElement(enterUserEmail).sendKeys("Karan1166@gmil.com");
        driver.findElement(enterUserPassword).sendKeys("karan00044");
        driver.findElement(ClickLoginButton).click();
    }

    public void verification1() {
        Assert.assertEquals(driver.findElement(By.xpath("//h1[contains(text(),'Thank you')]")).getText(),"Thank you");
    }

    public void addToCart() throws IOException {

        driver.findElement(clickOnComputer).click();
        driver.findElement(clickOnNotebooks).click();
        driver.findElement(clickonNotebookType).click();
        driver.findElement(clickOnAddToCart).click();
        driver.findElement(clickOnAddCartItem).click();
        driver.findElement(clickOnShoppingCart).click();
        driver.findElement(clickOnTerms).click();
        driver.findElement(clickOnCheckout).click();
        driver.findElement(clickonContinue).click();
        driver.findElement(clickOnTerms).click();
        driver.findElement(clickOnCheckout).click();
        String path = System.getProperty("user.dir") + "/src/test/java/TestData/Addtocart.xlsx";
        FileInputStream prop1 = null;
        try {
            prop1 = new FileInputStream(path);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        XSSFWorkbook wb = new XSSFWorkbook(prop1);
        XSSFSheet sheet = wb.getSheet("Sheet1");
        String enterCountry= sheet.getRow(1).getCell(0).getStringCellValue();
        String enterUserCity= sheet.getRow(1).getCell(1).getStringCellValue();
        String enterUserAddress = sheet.getRow(1).getCell(2).getStringCellValue();
        String enterUserPostcode= sheet.getRow(1).getCell(3).getStringCellValue();
        String enterUserPhoneNumber= sheet.getRow(1).getCell(4).getStringCellValue();
        driver.findElement(addCountry).sendKeys(enterCountry);
        driver.findElement(enterCity).sendKeys(enterUserCity);
        driver.findElement(enterAddress).sendKeys(enterUserAddress);
        driver.findElement(enterPostCode).sendKeys(enterUserPostcode);
        driver.findElement(enterPhoneNumber).sendKeys(enterUserPhoneNumber);
        driver.findElement(save).click();
        driver.findElement(continueButton).click();
        driver.findElement(againContinue).click();
        driver.findElement(continueInfo).click();
        driver.findElement(clickOnConfirm).click();
    }

    public void userLogout()
        {
            driver.findElement(clickOnLogout).click();
        }
    }



