package ua.skillsup.betandlose.dao;


import ua.skillsup.betandlose.model.AccountDto;
import ua.skillsup.betandlose.model.UserDto;
import java.util.List;

public interface AccountDao {
    List<AccountDto> findAll();
    AccountDto findById(long id);
    long create(AccountDto accountDto);
    void update(AccountDto accountDto);
}
