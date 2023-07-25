package pk.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import pk.entity.User;
import pk.modelDto.UserDto;
import pk.repository.UserJpaRepository;

import java.util.Optional;


@Service
public class UserServiceImpl implements UserService {
    private BCryptPasswordEncoder passwordEncoder;
    private UserJpaRepository userJpaRepository;

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
        User user = getUser(userDto);
        User newUser = userJpaRepository.save(user);
        return newUser.getId();
    }

    @Override
    public UserDto findByUserName(String userName) {
        Optional<User> userOptinal = userJpaRepository.findUserByUserName(userName);
        if (userOptinal.isEmpty()) {
            throw new UsernameNotFoundException("User with email: " + userName + " not found !");

        } else {
            UserDto userDto = getUserDto(userOptinal.get());
            return userDto;
        }

    }
