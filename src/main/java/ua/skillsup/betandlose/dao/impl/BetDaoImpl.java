package ua.skillsup.betandlose.dao.impl;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.exception.ConstraintViolationException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import ua.skillsup.betandlose.converter.EntityDtoConverter;
import ua.skillsup.betandlose.dao.BetDao;
import ua.skillsup.betandlose.dao.entity.Bet;
import ua.skillsup.betandlose.model.BetDto;
import ua.skillsup.betandlose.model.ItemDto;
import ua.skillsup.betandlose.model.UserDto;

import java.util.List;
import java.util.stream.Collectors;

import static ua.skillsup.betandlose.converter.EntityDtoConverter.convert;

@Repository
public class BetDaoImpl implements BetDao{
    @Autowired
    private SessionFactory sessionFactory;


    @Transactional(readOnly = true)
    public List<BetDto> findAll() {
        List<Bet> list = sessionFactory.getCurrentSession()
                .createQuery("from Bet").list();
        return list.stream()
                .map(EntityDtoConverter::convert)
                .collect(Collectors.toList());
    }

    @Transactional(readOnly = true)
    public BetDto findById(long id) {
        Bet bet= (Bet) sessionFactory.getCurrentSession()
                .createQuery("select b from Bet b where b.id = :id").setLong("id", id).uniqueResult();
        return convert(bet);

    }

    @Transactional(readOnly = true)
    public List<BetDto> findByUser(UserDto userDto) {
        List<Bet> list =  sessionFactory.getCurrentSession()
                .createQuery("select b from Bet as b " +
                        "join b.user as user  " +
                        "with user.id = :userId").setLong("userId", userDto.getId()).list();
        return list.stream()
                .map(EntityDtoConverter::convert)
                .collect(Collectors.toList());
    }

    @Transactional(readOnly = true)
    public List<BetDto> findByItem(ItemDto itemDto) {
        List<Bet> list =  sessionFactory.getCurrentSession()
                .createQuery("select b from Bet as b " +
                        "join b.item as item  " +
                        "with item.id = :itemId").setLong("itemId", itemDto.getId()).list();
        return list.stream()
                .map(EntityDtoConverter::convert)
                .collect(Collectors.toList());

    }

    @Transactional(readOnly = false)
    public long create(BetDto betDto) {
        Bet bet = EntityDtoConverter.convert(betDto);
        Session session = sessionFactory.getCurrentSession();
        try {
            session.persist(bet);
        } catch (ConstraintViolationException e) {
            System.out.println(e);
        }
        return bet.getId();

    }

    @Transactional(readOnly = false)
    public void update(BetDto betDto) {
        Bet bet = EntityDtoConverter.convert(betDto);
        Session session = sessionFactory.getCurrentSession();
        try {
            session.saveOrUpdate(bet);
        } catch (ConstraintViolationException e) {
            System.out.println(e);
        }

    }

    @Transactional(readOnly = false)
    public void delete(BetDto betDto) {
        Bet bet = EntityDtoConverter.convert(betDto);
        Session session = sessionFactory.getCurrentSession();
        try {
            session.delete(bet);
        } catch (ConstraintViolationException e) {
            System.out.println(e);
        }

    }
}
