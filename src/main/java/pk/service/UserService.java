package pk.service;

import pk.entity.User;
import pk.modelDto.UserDto;

public interface UserService {
    public Long saveUser(UserDto userDto);
    public UserDto findByUserName(String userName);
}
