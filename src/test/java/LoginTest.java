import data.ProviderDataLogin;
import dto.UserDTO;
import manager.TestNgListener;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

@Listeners(TestNgListener.class)
public class LoginTest extends TestBase{

    UserDTO userDtoPositive = UserDTO.builder().email("juliagordyin@gmail.com")
            .password("123456Aa").build();

    UserDTO userDtoFromProperties;

    @BeforeMethod(alwaysRun = true)
    public void checkIsLogin() {
        if(userDtoFromProperties == null) {
            userDtoFromProperties = UserDTO.builder().email(app.getEmail())
                    .password(app.getPassword()).build();
        }

    //    app.getHelperLogin().changeImplicitlyTime(60);


//        boolean res;
//        try {
//            res = app.getHelperLogin().validateLoginSuccess();
//        }
//        catch(Exception e) {
//            res = false;
//        }
        // if(true)   if(1==1)
        if (app.getHelperLogin().validateLoginSuccess2()) { // will be res = true or res=false
            app.getHelperLogout().logout();
        } else {
            app.navigateToMainPage();
        }
    }

    @Test(invocationCount = 2)
    public void loginTestPositive() {
        app.getHelperLogin().login(userDtoPositive, app.getWait());
        Assert.assertTrue(app.getHelperLogin().validateLoginSuccess());
    }

    @Test
    public void loginTestPositiveProperties() {
        app.getHelperLogin().login(userDtoFromProperties, app.getWait());
        Assert.assertTrue(app.getHelperLogin().validateLoginSuccess());
    }

    @Test(groups = { "smoke" })
    public void loginTestPasswordInput() {
        logger.info("start test loginTestPasswordInput");
        app.getHelperLogin().openLoginPage();
        app.getHelperLogin().enterEmailLogin(userDtoFromProperties);
        app.getHelperLogin().clickContinueLogin();
        WebDriverWait wait = app.getWait();
      //  Assert.assertTrue(app.getHelperLogin().validatePasswordInputEnable(app.getWait()));
        Assert.assertTrue(app.getHelperLogin().validatePasswordInputEnable(wait));
        /*
        app.getWait()
        int varRes = 55;
        someFun(1, "str", varRes, callFunc() - return)
         */
    }

    @Test(dataProvider = "userDtoWrongPassword", dataProviderClass = ProviderDataLogin.class)
    public void loginWithIncorrectPassword(UserDTO userFromDataProvider) {
        app.getHelperLogin().login(userFromDataProvider, app.getWait());
        Assert.assertTrue(app.getHelperLogin().validatePasswordIncorrect());
    }

    @Test(dataProvider = "userDtoCSV", dataProviderClass = ProviderDataLogin.class)
    public void loginTest(UserDTO userFromCSVFile) {
        app.getHelperLogin().login(userFromCSVFile, app.getWait());
        Assert.assertTrue(app.getHelperLogin().validateLoginSuccess());
    }

    // list = 1 element, 2 element ..... iterator
    // array foreach

}
