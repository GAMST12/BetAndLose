package ua.skillsup.betandlose.converter;

import ua.skillsup.betandlose.dao.entity.Account;
import ua.skillsup.betandlose.dao.entity.User;
import ua.skillsup.betandlose.model.AccountDto;
import ua.skillsup.betandlose.model.UserDto;

public final class EntityDtoConverter {
    private EntityDtoConverter() {
    }

    public static User convert(UserDto userDto) {
        if (userDto == null) {
            return null;
        }
        User user = new User();
        user.setId(userDto.getId());
        user.setLogin(userDto.getLogin());
        user.setFirstName(userDto.getFirstName());
        user.setLastName(userDto.getLastName());
        user.setRole(userDto.getRole());
        return user;
    }

    public static UserDto convert(User user) {
        if (user == null) {
            return null;
        }
        UserDto userDto = new UserDto();
        userDto.setId(user.getId());
        userDto.setLogin(user.getLogin());
        userDto.setFirstName(user.getFirstName());
        userDto.setLastName(user.getLastName());
        userDto.setRole(user.getRole());
        return userDto;
    }

    public static Account convert(AccountDto accountDto) {
        if (accountDto == null) {
            return null;
        }
        Account account = new Account();
        account.setUser(convert(accountDto.getUser()));
        account.setOkv(accountDto.getOkv());
        return account;
    }

    public static AccountDto convert(Account account) {
        if (account == null) {
            return null;
        }
        AccountDto accountDto = new AccountDto();
        accountDto.setUser(convert(account.getUser()));
        accountDto.setOkv(account.getOkv());
        return accountDto;
    }

}
