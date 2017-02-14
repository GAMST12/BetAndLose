import org.springframework.context.support.ClassPathXmlApplicationContext;
import ua.skillsup.betandlose.dao.UserDao;
import ua.skillsup.betandlose.model.UserDto;

import java.util.List;

public class App {
    public static void main(String[] args) {
        ClassPathXmlApplicationContext context =
            new ClassPathXmlApplicationContext("app-context.xml");
        UserDao userDao = context.getBean(UserDao.class);
        //List<UserDto> list = userDao.findAll();
        //System.out.println(list);

        UserDto user = userDao.findById(1);
        System.out.println(user);

        context.stop();
        }
}
