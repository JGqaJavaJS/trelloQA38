package manager;

import dto.UserDTO;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

public class HelperLogin extends HelperBase{

    public HelperLogin(WebDriver driver) {
        super(driver);
    }

    By OPEN_LOGIN_PAGE_BTN = By.xpath("//a[contains(text(), 'Log in')]");
    By INPUT_EMAIL = By.xpath("//input[@id='user']");
    By BTN_LOGIN = By.xpath("//input[@id='login']");
    By INPUT_PASSWORD = By.xpath("//input[@name='password']");
    By CONFIRM_PASSWORD_BTN = By.xpath("//button[@id='login-submit']");
    By TEXT_WORKSPACE_AFTER_LOGIN = By.xpath("//span[@data-testid='home-team-tab-name']");


    /*
    1. open login
    2. enter email
    3. click on btn continue
    4. enter password
    5. click login
    6. assert for workspace
     */

    public void login(UserDTO userDTO) {
        openLoginPage();
        enterEmailLogin(userDTO);
        clickContinueLogin();
        typePasswordLogin(userDTO);
        clickConfirmPasswordButton();
    }

    public void openLoginPage() {
        click(OPEN_LOGIN_PAGE_BTN);
    }

    public void enterEmailLogin(UserDTO userDTO) {
        type(INPUT_EMAIL, userDTO.getEmail());
    }

    public void clickContinueLogin() {
        click(BTN_LOGIN);
    }

    public void typePasswordLogin(UserDTO userDTO) {
        type(INPUT_PASSWORD, userDTO.getPassword());
    }

    public void clickConfirmPasswordButton() {
        click(CONFIRM_PASSWORD_BTN);
    }

}
