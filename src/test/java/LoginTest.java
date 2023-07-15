import dto.UserDTO;
import manager.TestNgListener;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

@Listeners(TestNgListener.class)
public class LoginTest extends TestBase{

    UserDTO userDtoPositive = UserDTO.builder().email("juliagordyin@gmail.com")
            .password("123456Aa").build();

    @BeforeMethod
    public void checkIsLogin() {
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
    public void loginTestPasswordInput() {
        logger.info("start test loginTestPasswordInput");
        app.getHelperLogin().openLoginPage();
        app.getHelperLogin().enterEmailLogin(userDtoPositive);
        app.getHelperLogin().clickContinueLogin();
        Assert.assertTrue(app.getHelperLogin().validatePasswordInputEnable(app.getWait()));
    }

}
