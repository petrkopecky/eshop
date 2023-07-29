package pk.service;

import org.mapstruct.factory.Mappers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import pk.entity.User;
import pk.mapperDto.UserMapper;
import pk.modelDto.UserDto;
import pk.repository.UserJpaRepository;

import java.util.List;
import java.util.Optional;


@Service
public class UserServiceImpl implements UserService {
    private BCryptPasswordEncoder passwordEncoder;
    private UserJpaRepository userJpaRepository;
    private UserMapper userMapper= Mappers.getMapper(UserMapper .class);

    @Autowired
    public UserServiceImpl(BCryptPasswordEncoder passwordEncoder, UserJpaRepository userJpaRepository) {
        this.passwordEncoder = passwordEncoder;
        this.userJpaRepository = userJpaRepository;

    }

    @Override
    public UserDto addUser(UserDto userDto) {
        String password = userDto.getPassword();
        String encodedPasswod = passwordEncoder.encode(password);
        userDto.setPasswordHash(encodedPasswod);
        User user = userMapper.userDtoToUser(userDto);
        User newUser = userJpaRepository.save(user);
        return userMapper.userToUserDto(newUser);
    }


    @Override
    public UserDto findByUserNameDto(String userName) {
           return userMapper.userToUserDto(findByUserName(userName));
    }

    @Override
    public User findByUserName(String userName) {
       return userJpaRepository.findUserByUserName(userName).orElseThrow(
                () -> new UsernameNotFoundException("User with userName: " + userName + " not found !"));
    }

    @Override
    public List<UserDto> getUserList() {
        return userMapper.usersToUsersDto(userJpaRepository.findAll());
    }
}