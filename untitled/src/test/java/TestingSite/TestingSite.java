package TestingSite;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class TestingSite{
    private WebDriver driver;

    private By enterLoginLink = By.className("form-control");
    private By enterPassword = By.id("pasword");
    private By enterName = By.id("name");
    private By enterEmail = By.id("email");
    private By enterAddress = By.id("address");
    private By ButtonRegister = (By.xpath("//*[@id=\"signup\"]/button"));
    private By ButtonWatch = (By.xpath("//a[@href = 'product/title-2-2']"));
    private By ButtonChoiceColour = (By.className("available"));
    private By ButtonColour = (By.xpath("//option[@value = '5']"));
    private By enterAmount = (By.xpath("//input[@name = 'quantity']"));
    private By ButtonBackToShopping = (By.xpath("//button[@class = 'btn btn-default']"));
    private By ButtonBag = (By.className("total"));
    private By ButtonEnterInAccount = (By.xpath("//button[@class = 'btn btn-default']"));
    private By ButtonMain = (By.className("logo"));
    private By ButtonBuyOrder = (By.xpath("//a[@class = 'btn btn-primary']"));
    private By ButtonBuy = (By.xpath("//button[@class = 'btn btn-default']"));
    private By enterNote = (By.className("form-control"));
    private By ButtonAddToCart = (By.id("productAdd"));
    private By ButtonEnter = (By.linkText("Вход"));
    private By ButtonAccount = (By.className("dropdown-toggle"));
    private By ButtonAuthorization = (By.linkText("Регистрация"));
    private By ButtonMen = (By.className("menu-dropdown-icon"));
    private By ButtonCasio = (By.linkText("Casio"));
    private By ButtonMech = (By.xpath("//*[text()[contains(.,'Кварцевый от солнечного аккумулятора                ')]]"));
    private By ButtonGlass = (By.xpath("//*[text()[contains(.,'Полимерное                ')]]"));
    private By ButtonBelt = (By.xpath("//*[text()[contains(.,'Кожаный                ')]]"));
    private By ButtonFilterWatch = (By.xpath("//a[@href = 'product/casio-ga-1000-1aer-3']"));


    // Вынести в константы xpath и сократить их

    public TestingSite(WebDriver driver){
        this.driver = driver;
    }
    public TestingSite enterLogin(String login){
        WebElement loginInput = driver.findElement(enterLoginLink);
        loginInput.sendKeys(login);
        return this;
    }

    public TestingSite enterPassword(String password){
        WebElement passwordInput = driver.findElement(enterPassword);
        passwordInput.sendKeys(password);
        return this;
    }

    public TestingSite enterName(String name){
        WebElement nameInput = driver.findElement(enterName);
        nameInput.sendKeys(name);
        return this;
    }

    public TestingSite enterEmail(String email){
        WebElement emailInput = driver.findElement(enterEmail);
        emailInput.sendKeys(email);
        return this;
    }

    public TestingSite enterAddress(String address){
        WebElement addressInput = driver.findElement(enterAddress);
        addressInput.sendKeys(address);
        return this;
    }

    public TestingSite tapButtonRegister(){
        WebElement registerButton = driver.findElement(ButtonRegister);
        registerButton.click();
        return this;
    }

    public TestingSite tapButtonEnter(){
        WebElement enterButton = driver.findElement(ButtonEnter);
        enterButton.click();
        return this;
    }

    public TestingSite tapButtonAccount(){
        WebElement accountButton = driver.findElement(ButtonAccount);
        accountButton.click();
        return this;
    }
    public TestingSite tapButtonAuthorization(){
        WebElement authorizationButton = driver.findElement(ButtonAuthorization);
        authorizationButton.click();
        return this;
    }
    public TestingSite tapButtonMen(){
        Actions actions = new Actions(driver);
        WebElement menButton = driver.findElement(ButtonMen);
        actions.moveToElement(menButton)
                .moveByOffset(5,0)
                .release()
                .perform();
        return this;
    }

    public TestingSite tapButtonCasio(){
        WebElement casioButton = driver.findElement(ButtonCasio);
        casioButton.click();
        return this;
    }

    public TestingSite tapButtonMech(){
        WebElement mechButton = driver.findElement(ButtonMech);
        mechButton.click();
        return this;
    }

    public TestingSite tapButtonGlass(){
        WebElement glassButton = driver.findElement(ButtonGlass);
        glassButton.click();
        return this;
    }

    public TestingSite tapButtonBelt(){
        WebElement beltButton = driver.findElement(ButtonBelt);
        beltButton.click();
        return this;
    }

    public TestingSite tapButtonFilterWatch(){
        driver.navigate().refresh();
        WebElement filterWatchButton = driver.findElement(ButtonFilterWatch);
        filterWatchButton.click();
        return this;
    }
    public TestingSite sleep() {
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        return this;
    }
    public TestingSite tapButtonWatch(){
        WebElement watchButton = driver.findElement(ButtonWatch);
        watchButton.click();
        return this;
    }

    public TestingSite tapButtonChoiceColour(){
        WebElement choiceColourButton = driver.findElement(ButtonChoiceColour);
        choiceColourButton.click();
        return this;
    }
    public TestingSite tapButtonColour(){
        WebElement colourButton = driver.findElement(ButtonColour);
        colourButton.click();
        return this;
    }
    public TestingSite enterAmount(String amount){
        WebElement amountInput = driver.findElement(enterAmount);
        amountInput.clear();
        amountInput.sendKeys(amount);
        return this;
    }
    public TestingSite tapButtonAddToCart(){
        WebElement addToCartButton = driver.findElement(ButtonAddToCart);
        addToCartButton.click();
        return this;
    }
    public TestingSite tapButtonBackToShopping(){
        WebElement shoppingButton = driver.findElement(ButtonBackToShopping);
        shoppingButton.click();
        return this;
    }
    public TestingSite tapButtonBag(){
        WebElement bagButton = driver.findElement(ButtonBag);
        bagButton.click();
        return this;
    }
    public TestingSite tapButtonEnterInAccount(){
        WebElement enterButton = driver.findElement(ButtonEnterInAccount);
        enterButton.click();
        return this;
    }
    public TestingSite tapButtonMain(){
        WebElement mainButton = driver.findElement(ButtonMain);
        mainButton.click();
        return this;
    }
    public TestingSite tapButtonBuyOrder(){
        WebElement orderButton = driver.findElement(ButtonBuyOrder);
        orderButton.click();
        return this;
    }
    public TestingSite tapButtonBuy(){
        WebElement buyButton = driver.findElement(ButtonBuy);
        buyButton.click();
        return this;
    }
    public TestingSite enterNote(String note){
        WebElement enterInput = driver.findElement(enterNote);
        enterInput.sendKeys(note);
        return this;
    }
}