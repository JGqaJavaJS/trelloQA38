import dto.UserDTO;
import org.testng.annotations.Test;

public class LoginTest extends TestBase{

    UserDTO userDtoPositive = UserDTO.builder().email("juliagoryin@gmail.com")
            .password("123456Aa").build();

    @Test
    public void loginTestPositive() {
        app.getHelperLogin().login(userDtoPositive);
    }
}
