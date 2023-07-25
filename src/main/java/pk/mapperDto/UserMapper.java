package pk.mapperDto;

import org.mapstruct.Mapper;
import pk.entity.Order;
import pk.entity.User;
import pk.modelDto.OrderDto;
import pk.modelDto.UserDto;

import java.util.List;

@Mapper(uses = RoleMapper.class)
public interface UserMapper {
    UserDto userToUserDto(User user);
    User userDtoToUser(UserDto userDto);

    List<UserDto> usersToUsersDto(List<User> User);
    List<User> usersDtoToUsers( List<UserDto> UserDto);
}
