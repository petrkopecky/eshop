package pk.service;

import pk.entity.User;
import pk.modelDto.ProductDto;
import pk.modelDto.UserDto;

import java.util.List;

public interface UserService {


    public UserDto addUser(UserDto userDto);
    public UserDto findByUserName(String userName);

    public List<UserDto> getUserList();
}
