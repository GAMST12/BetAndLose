package ua.skillsup.betandlose.dao;

import ua.skillsup.betandlose.model.KindSportDto;

import java.util.List;

public interface KindSportDao {
        List<KindSportDto> findAll();
        KindSportDto findById(long id);
        KindSportDto findBySport(String sport);
        long create(KindSportDto kindSportDto);
        void update(KindSportDto kindSportDto);
        void delete(KindSportDto kindSportDto);
}
