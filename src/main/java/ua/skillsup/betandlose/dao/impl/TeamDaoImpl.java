package ua.skillsup.betandlose.dao.impl;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.exception.ConstraintViolationException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import ua.skillsup.betandlose.converter.EntityDtoConverter;
import ua.skillsup.betandlose.dao.TeamDao;
import ua.skillsup.betandlose.dao.entity.Team;
import ua.skillsup.betandlose.model.KindSportDto;
import ua.skillsup.betandlose.model.TeamDto;

import java.util.List;
import java.util.stream.Collectors;

import static ua.skillsup.betandlose.converter.EntityDtoConverter.convert;

@Repository
public class TeamDaoImpl implements TeamDao{
    @Autowired
    private SessionFactory sessionFactory;


    @Transactional(readOnly = true)
    public List<TeamDto> findAll() {
        List<Team> list = sessionFactory.getCurrentSession()
                .createQuery("from Team").list();
        return list.stream()
                .map(EntityDtoConverter::convert)
                .collect(Collectors.toList());
    }

    @Transactional(readOnly = true)
    public TeamDto findById(long id) {
        Team team = (Team) sessionFactory.getCurrentSession()
                .createQuery("select t from Team t where t.id = :id").setLong("id", id).uniqueResult();
        return convert(team);

    }

    @Transactional(readOnly = true)
    public TeamDto findByTeamCityCountrySex(String team, String city, String country, String sex) {
        Team tm = (Team) sessionFactory.getCurrentSession()
                .createQuery("select t from Team t where t.team = :team " +
                        "and t.city = :city " +
                        "and t.country = :country " +
                        "and t.sex = :sex")
                .setString("team", team)
                .setString("city", city)
                .setString("country", country)
                .setString("sex", sex)
                .uniqueResult();
        return convert(tm);

    }

    @Override
    public List<TeamDto> findByTeam(String team) {
        List<Team> list = sessionFactory.getCurrentSession()
                .createQuery("select t from Team t where t.team = :team ")
                .setString("team", team)
                .list();
        return list.stream()
                .map(EntityDtoConverter::convert)
                .collect(Collectors.toList());

    }

    @Transactional(readOnly = true)
    public List<TeamDto> findByCity(String city) {
        List<Team> list = sessionFactory.getCurrentSession()
                .createQuery("select t from Team t where t.city = :city ")
                .setString("city", city)
                .list();
        return list.stream()
                .map(EntityDtoConverter::convert)
                .collect(Collectors.toList());
    }

    @Transactional(readOnly = true)
    public List<TeamDto> findByCountry(String country) {
        List<Team> list = sessionFactory.getCurrentSession()
                .createQuery("select t from Team t where t.country = :country ")
                .setString("country", country)
                .list();
        return list.stream()
                .map(EntityDtoConverter::convert)
                .collect(Collectors.toList());
    }

    @Transactional(readOnly = true)
    public List<TeamDto> findByKindSport(KindSportDto kindSportDto) {
        List<Team> list =  sessionFactory.getCurrentSession()
                .createQuery("select t from Team as t " +
                        "left join t.kindSport as kindSport  " +
                        "with kindSport.id = :kindSportId").setLong("kindSportId", kindSportDto.getId()).list();
        return list.stream()
                .map(EntityDtoConverter::convert)
                .collect(Collectors.toList());

    }

    @Transactional(readOnly = false)
    public long create(TeamDto teamDto) {
        Team team = EntityDtoConverter.convert(teamDto);
        Session session = sessionFactory.getCurrentSession();
        try {
            session.persist(team);
        } catch (ConstraintViolationException e) {
            System.out.println(e);
        }
        return team.getId();

    }

    @Transactional(readOnly = false)
    public void update(TeamDto teamDto) {
        Team team = EntityDtoConverter.convert(teamDto);
        Session session = sessionFactory.getCurrentSession();
        try {
            session.saveOrUpdate(team);
        } catch (ConstraintViolationException e) {
            System.out.println(e);
        }

    }

    @Transactional(readOnly = false)
    public void delete(TeamDto teamDto) {
        Team team = EntityDtoConverter.convert(teamDto);
        try {
            sessionFactory.getCurrentSession().delete(team);
        } catch (ConstraintViolationException e) {
            System.out.println(e);
        }

    }
}
