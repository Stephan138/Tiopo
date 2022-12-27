package ru.shop.qatl;
import TestingSite.TestingSite;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.annotations.*;
import java.util.concurrent.TimeUnit;

public class Tests extends Data{

    private String chromeDriver = "webdriver.chrome.driver";
    private String pathToDriver = "C:\\Users\\Stepk\\IdeaProjects\\chromedriver.exe";
    private By alertDoneAuthorization = By.xpath("//div[@class='alert alert-success']");
    private By  alertNameWatch = By.tagName("h2");
    private By alertOrderMessage = By.xpath("//div[@class='alert alert-success']");
    private By alertBag = By.xpath("//*[@id=\"myModalLabel\"]");
    private String urlSite = "http://shop.qatl.ru/";
    private WebDriver driver;
    @BeforeMethod
    public void setUp() throws InterruptedException {
        System.setProperty(chromeDriver, pathToDriver);
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
        driver.get(urlSite);
        Thread.sleep(2000);
    }

    // переименовать методы
    @Test(description = "Авторизация")
    public void AuthorizationOnSite() {

        TestingSite testingSite = new TestingSite(driver);

        testingSite.tapButtonAccount()
                .tapButtonAuthorization()
                .enterLogin(login)
                .enterPassword(Password)
                .enterName(Name)
                .enterEmail(Email)
                .enterAddress(Address)
                .tapButtonRegister();

        WebElement alert = driver.findElement(alertDoneAuthorization);
        // Добавить message
        Assert.assertEquals(alert.getText(), Data.doneAuthorization, "Авторизация не пройдена, сообщение не было найдено");
    }

    @Test(description = "Поиск товара в каталоге")
    public void searchWatchByCatalog() {

        TestingSite testingSite = new TestingSite(driver);

        testingSite.tapButtonMen()
                .tapButtonCasio()
                .tapButtonMech()
                .sleep()
                .tapButtonBelt()
                .sleep()
                .tapButtonGlass()
                .sleep()
                .tapButtonFilterWatch();

        WebElement alert = driver.findElement(alertNameWatch);
        Assert.assertEquals(alert.getText(), Data.watch, "Товар по заданным кретериям не найден, наименование не совпало");
    }

    @Test(description = "Добавление товара в корзину")
    public void andToBagWatch() {

        TestingSite testingSite = new TestingSite(driver);

        testingSite.tapButtonWatch()
                .tapButtonChoiceColour()
                .tapButtonColour()
                .enterAmount(Amount)
                .tapButtonAddToCart()
                .sleep();

        WebElement alert1 = driver.findElement(By.xpath("//*[text()[contains(.,'Title #2 (Silver)')]]"));
        WebElement alert2 = driver.findElement(By.xpath("//td[@class='text-right cart-sum']"));
        Assert.assertEquals(alert1.getText(), Data.WatchSearch);
        Assert.assertEquals(alert2.getText(), Data.CoastInBag, "Выборанный товар не добавлен в корзину и не совпал с тем, который выбирали");

        testingSite.tapButtonBackToShopping()
                .tapButtonBag()
                .sleep();

        WebElement alert = driver.findElement(alertBag);
        // Добавить проверку, что добавили тот товар, который хотели
        Assert.assertEquals(alert.getText(), Data.Bag, "Текст корзины не совпал");
    }

    @Test(description = "Оформление заказа")
    public void buyWatchWithLoginAccount() {

        TestingSite testingSite = new TestingSite(driver);

        testingSite.tapButtonAccount()
                .tapButtonEnter()
                .sleep()
                .enterPassword(PasswordEnter)
                .sleep()
                .enterLogin(loginEnter)
                .sleep()
                .tapButtonEnterInAccount()
                .tapButtonMain()
                .tapButtonWatch()
                .tapButtonChoiceColour()
                .tapButtonColour()
                .tapButtonAddToCart()
                .sleep()
                .tapButtonBuyOrder();

        WebElement alert1 = driver.findElement(By.xpath("//*[text()[contains(.,'Title #2 (Silver)')]]"));
        WebElement alert2 = driver.findElement(By.xpath("//td[@class='text-right cart-sum']"));
        Assert.assertEquals(alert1.getText(), Data.WatchSearch);
        Assert.assertEquals(alert2.getText(), Data.CoastInOrder, "Товар не добавлен в корзину и не находииться на странице оформления товара, наименования не совпали");

        testingSite.enterNote(Note)
                .tapButtonBuy();

        WebElement alert = driver.findElement(alertOrderMessage);
        Assert.assertEquals(alert.getText(), Data.OrderMessage, "Сообщение об успешном оформлении заказа не подтверждено. Товар не оформлен.");
    }
}
