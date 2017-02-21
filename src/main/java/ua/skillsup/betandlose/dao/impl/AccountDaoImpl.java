package ua.skillsup.betandlose.dao.impl;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import ua.skillsup.betandlose.converter.EntityDtoConverter;
import ua.skillsup.betandlose.dao.AccountDao;
import ua.skillsup.betandlose.dao.entity.Account;
import ua.skillsup.betandlose.model.AccountDto;

import java.util.List;
import java.util.stream.Collectors;

@Repository
public class AccountDaoImpl implements AccountDao {
    @Autowired
    private SessionFactory sessionFactory;

    @Transactional(readOnly = true)
    public List<AccountDto> findAll() {
        List<Account> list = sessionFactory.getCurrentSession()
                .createQuery("from Account").list();
        return list.stream()
                .map(EntityDtoConverter::convert)
                .collect(Collectors.toList());

    }

    @Override
    public AccountDto findById(long id) {
        return null;
    }

    @Override
    public long create(AccountDto accountDto) {
        return 0;
    }

    @Override
    public void update(AccountDto accountDto) {

    }
}
