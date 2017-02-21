import org.h2.jdbc.JdbcSQLException;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import ua.skillsup.betandlose.dao.AccountDao;
import ua.skillsup.betandlose.dao.UserDao;
import ua.skillsup.betandlose.model.AccountDto;
import ua.skillsup.betandlose.model.UserDto;

import java.util.List;

public class App {
    public static void main(String[] args) {
        ClassPathXmlApplicationContext context =
            new ClassPathXmlApplicationContext("app-context.xml");
        UserDao userDao = context.getBean(UserDao.class);

        UserDto userById = userDao.findById(1);
        System.out.println("userById:" + userById);

        UserDto userByLogin = userDao.findByLogin("GAMST");
        System.out.println("userByLogin:" + userByLogin);

        UserDto newUser = new UserDto();
        newUser.setLogin("admin");
        newUser.setFirstName("admin");
        newUser.setLastName("admin");
        newUser.setRole("A");
        Long id = userDao.create(newUser);
        System.out.println(id);

        UserDto newUserById = userDao.findById(id);
        System.out.println("newUserById:" + newUserById);

        List<UserDto> userList = userDao.findAll();
        System.out.println(userList);


        AccountDao accountDao = context.getBean(AccountDao.class);
        List<AccountDto> accountList = accountDao.findAll();
        System.out.println(accountList);

        context.stop();
        }
}
