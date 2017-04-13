package ua.skillsup.betandlose.dao.impl;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.exception.ConstraintViolationException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import ua.skillsup.betandlose.converter.EntityDtoConverter;
import ua.skillsup.betandlose.dao.KindSportDao;
import ua.skillsup.betandlose.dao.entity.KindSport;
import ua.skillsup.betandlose.model.KindSportDto;

import java.util.List;
import java.util.stream.Collectors;

import static ua.skillsup.betandlose.converter.EntityDtoConverter.convert;

@Repository
public class KindSportDaoImpl implements KindSportDao{
    @Autowired
    private SessionFactory sessionFactory;

    @Transactional(readOnly = true)
    public List<KindSportDto> findAll() {
        List<KindSport> list = sessionFactory.getCurrentSession()
                .createQuery("from KindSport").list();
        return list.stream()
                .map(EntityDtoConverter::convert)
                .collect(Collectors.toList());
    }

    @Transactional(readOnly = true)
    public KindSportDto findById(long id) {
        KindSport kindSport = (KindSport) sessionFactory.getCurrentSession()
                .createQuery("select k from KindSport k where k.id = :id").setLong("id", id).uniqueResult();
        return convert(kindSport);
    }

    @Transactional(readOnly = true)
    public KindSportDto findBySport(String sport) {
        KindSport kindSport= (KindSport) sessionFactory.getCurrentSession()
                .createQuery("select k from KindSport k where k.sport = :sport").setString("sport", sport).uniqueResult();
        return convert(kindSport);
    }

    @Transactional(readOnly = false)
    public long create(KindSportDto kindSportDto) {
        KindSport kindSport = EntityDtoConverter.convert(kindSportDto);
        Session session = sessionFactory.getCurrentSession();
        try {
            session.persist(kindSport);
        } catch (ConstraintViolationException e) {
            System.out.println(e);
        }
        return kindSport.getId();
    }

    @Transactional(readOnly = false)
    public void update(KindSportDto kindSportDto) {
        KindSport kindSport = EntityDtoConverter.convert(kindSportDto);
        Session session = sessionFactory.getCurrentSession();
        try {
            session.saveOrUpdate(kindSport);
        } catch (ConstraintViolationException e) {
            System.out.println(e);
        }
    }

    @Transactional(readOnly = false)
    public void delete(KindSportDto kindSportDto) {
        KindSport kindSport = EntityDtoConverter.convert(kindSportDto);
        try {
            sessionFactory.getCurrentSession().delete(kindSport);
        } catch (ConstraintViolationException e) {
            System.out.println(e);
        }
    }
}
