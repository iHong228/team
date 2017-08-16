package test;

import dao.AccountDAO;
import org.junit.Test;
import svc.AccountService;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 * Created by user on 2017-08-16.
 */
public class TestSVC {

    @Test
    public void loginTest(){
        AccountService login = new AccountService();
        AccountDAO dao = new AccountDAO();

        assertThat(login.Login("apple","12345"), is(3));

    }
}
