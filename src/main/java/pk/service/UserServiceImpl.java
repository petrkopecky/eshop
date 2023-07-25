package pk.service;

import org.mapstruct.factory.Mappers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import pk.entity.Role;
import pk.entity.User;
import pk.mapperDto.ProductMapper;
import pk.mapperDto.UserMapper;
import pk.modelDto.UserDto;
import pk.repository.UserJpaRepository;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;


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
    public Long saveUser(UserDto userDto) {
        String password = userDto.getPassword();
        String encodedPasswod = passwordEncoder.encode(password);
        userDto.setPasswordHash(encodedPasswod);
        User user = userMapper.userDtoToUser(userDto);
        User newUser = userJpaRepository.save(user);
        return newUser.getId();
    }

    @Override
    public UserDto findByUserName(String userName) {
        Optional<User> userOptinal = userJpaRepository.findUserByUserName(userName);
        if (userOptinal.isEmpty()) {
            throw new UsernameNotFoundException("User with email: " + userName + " not found !");

        } else {
            UserDto userDto = userMapper.userToUserDto(userOptinal.get());
            return userDto;
        }

    }

    List<String> gerRoleNames(List<Role> roles) {
        List<String> rolesName = roles.stream().map(Role::getName).collect(Collectors.toList());
        return rolesName;
    }
}