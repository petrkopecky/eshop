package pk.service;

import pk.entity.User;
import pk.modelDto.UserDto;

import java.util.List;

public interface UserService {


    public UserDto addUser(UserDto userDto);
    public UserDto findByUserNameDto(String userName);
    public User findByUserName(String userName);

    public List<UserDto> getUserList();
}
