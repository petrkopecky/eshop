package pk.service;

import pk.modelDto.UserDto;

import java.util.List;

public interface UserService {


    public UserDto addUser(UserDto userDto);
    public UserDto findByUserName(String userName);

    public List<UserDto> getUserList();
}
