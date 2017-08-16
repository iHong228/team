package svc;

import dao.AccountDAO;
import exception.AutholizationException;
import exception.CountOverException;
import exception.WrongPasswordException;
import vo.Account;

import javax.naming.PartialResultException;
import java.sql.SQLException;
import java.util.List;

/**
 * Created by user on 2017-08-14.
 */
public class AccountService {

    public int Login(String email, String pw) {
        AccountDAO dao = new AccountDAO();
        List<Account> list = dao.read("email", email);
        try {

            if (list.get(0).getEmail() == null) throw new Exception();
            if (list.get(0).getAutholization() == 0) throw new AutholizationException();
            if (!list.get(0).getPassword().equals(pw)) throw new WrongPasswordException();
            if (list.get(0).getCount() == 5) throw new CountOverException();

            list.get(0).setCount(0);
            dao.update(list.get(0));

            return 0;

        } catch (AutholizationException e) {
            return 3;
        } catch (WrongPasswordException e) {
            return 1;
        } catch (CountOverException e) {
            return 4;
        } catch (Exception e) {
            return 2;
        }

    }
}
