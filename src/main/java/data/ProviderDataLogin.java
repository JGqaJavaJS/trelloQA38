package data;

import dto.UserDTO;
import org.testng.annotations.DataProvider;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class ProviderDataLogin {
    @DataProvider
    public Iterator<Object[]> userDtoWrongPassword(){
        List<Object[]> list = new ArrayList<>();
        list.add(new Object[]{
                UserDTO.builder().email("juliagordyin@gmail.com").password("123456AA").build()
        });
        list.add(new Object[]{
                UserDTO.builder().email("juliagordyin@gmail.com").password("123456aa").build()
        });
        return list.iterator();
    }

    @DataProvider
    public Iterator<Object[]> userDtoLogin(){
        List<Object[]> list = new ArrayList<>();
        list.add(new Object[]{
                UserDTO.builder().email("juliagordyin@gmail.com").password("123456Aa").build()
        });
        list.add(new Object[]{
                UserDTO.builder().email("juliagordyin@gmail.com").password("123456Aa").build()
        });
        return list.iterator();
    }

}
