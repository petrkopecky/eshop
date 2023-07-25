package pk.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import pk.entity.User;
import pk.repository.UserJpaRepository;

import java.util.Optional;
import java.util.stream.Collectors;

public class UserDetailServiceImpl implements UserDetailsService {
    private final UserService userService;


    @Autowired
    public UserDetailServiceImpl(UserService userService) {
        this.userService = userService;
    }


    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        UserDto userDto userService.findByUserName(username);
        return new org.springframework.security.core.userdetails.User(
                userDto.getUserName(),
                userDto.getPassword(),
                userDto.getRoles()
                        .stream()
                        .map(role -> new SimpleGrantedAuthority(role))
                        .collect(Collectors.toSet())
        );


    }
}
