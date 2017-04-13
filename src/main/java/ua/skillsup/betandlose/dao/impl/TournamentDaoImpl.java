package ua.skillsup.betandlose.dao.impl;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.exception.ConstraintViolationException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import ua.skillsup.betandlose.converter.EntityDtoConverter;
import ua.skillsup.betandlose.dao.TournamentDao;
import ua.skillsup.betandlose.dao.entity.Tournament;
import ua.skillsup.betandlose.model.KindSportDto;
import ua.skillsup.betandlose.model.TournamentDto;

import java.util.List;
import java.util.stream.Collectors;

import static ua.skillsup.betandlose.converter.EntityDtoConverter.convert;

@Repository
public class TournamentDaoImpl implements TournamentDao{
    @Autowired
    private SessionFactory sessionFactory;

    @Transactional(readOnly = true)
    public List<TournamentDto> findAll() {
        List<Tournament> list = sessionFactory.getCurrentSession()
                .createQuery("from Tournament").list();
        return list.stream()
                .map(EntityDtoConverter::convert)
                .collect(Collectors.toList());
    }

    @Transactional(readOnly = true)
    public TournamentDto findById(long id) {
        Tournament tournament = (Tournament) sessionFactory.getCurrentSession()
                .createQuery("select t from Tournament t where t.id = :id").setLong("id", id).uniqueResult();
        return convert(tournament);

    }

    @Transactional(readOnly = true)
    public TournamentDto findByTournament(String tournament) {
        Tournament tourn = (Tournament) sessionFactory.getCurrentSession()
                .createQuery("select t from Tournament t where t.tournament = :tournament").setString("tournament", tournament).uniqueResult();
        return convert(tourn);

    }

    @Transactional(readOnly = true)
    public List<TournamentDto> findByKindSport(KindSportDto kindSportDto) {
        List<Tournament> list =  sessionFactory.getCurrentSession()
                .createQuery("select t from Tournament as t " +
                        "join t.kindSport as kindSport  " +
                        "with kindSport.id = :kindSportId").setLong("kindSportId", kindSportDto.getId()).list();
        return list.stream()
                .map(EntityDtoConverter::convert)
                .collect(Collectors.toList());

    }

    @Transactional(readOnly = false)
    public long create(TournamentDto tournamentDto) {
        Tournament tournament = EntityDtoConverter.convert(tournamentDto);
        Session session = sessionFactory.getCurrentSession();
        try {
            session.persist(tournament);
        } catch (ConstraintViolationException e) {
            System.out.println(e);
        }
        return tournament.getId();
    }

    @Transactional(readOnly = false)
    public void update(TournamentDto tournamentDto) {
        Tournament tournament = EntityDtoConverter.convert(tournamentDto);
        Session session = sessionFactory.getCurrentSession();
        try {
            session.saveOrUpdate(tournament);
        } catch (ConstraintViolationException e) {
            System.out.println(e);
        }

    }

    @Transactional(readOnly = false)
    public void delete(TournamentDto tournamentDto) {
        Tournament tournament = EntityDtoConverter.convert(tournamentDto);
        try {
            sessionFactory.getCurrentSession().delete(tournament);
        } catch (ConstraintViolationException e) {
            System.out.println(e);
        }
    }
}
