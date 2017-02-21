package ua.skillsup.betandlose.dao.impl;

import org.hibernate.SessionFactory;
import org.hibernate.exception.ConstraintViolationException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import ua.skillsup.betandlose.converter.EntityDtoConverter;
import ua.skillsup.betandlose.dao.UserDao;
import ua.skillsup.betandlose.dao.entity.User;
import ua.skillsup.betandlose.model.UserDto;

import java.util.List;
import java.util.stream.Collectors;

import static ua.skillsup.betandlose.converter.EntityDtoConverter.convert;

@Repository
public class UserDaoImpl implements UserDao{
    @Autowired
    private SessionFactory sessionFactory;

    @Transactional(readOnly = true)
    public List<UserDto> findAll() {
        List<User> list = sessionFactory.getCurrentSession()
                .createQuery("from User").list();
        return list.stream()
                .map(EntityDtoConverter::convert)
                .collect(Collectors.toList());
    }

    @Transactional(readOnly = true)
    public UserDto findById(long id) {
        User user= (User) sessionFactory.getCurrentSession()
                .createQuery("select u from User u where u.id = :id").setLong("id", id).uniqueResult();
        return convert(user);
    }

    @Transactional(readOnly = true)
    public UserDto findByLogin(String login) {
        User user= (User) sessionFactory.getCurrentSession()
                .createQuery("select u from User u where u.login = :login").setString("login", login).uniqueResult();
        return convert(user);
    }

    @Transactional(readOnly = false)
    public long create(UserDto userDto) {
        User user = EntityDtoConverter.convert(userDto);
        try {
            sessionFactory.getCurrentSession().persist(user);
        } catch (ConstraintViolationException e) {
            System.out.println(e);
        }
        return user.getId();
    }

    public void update(UserDto userDto) {

    }
}
