package pk.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import pk.entity.User;
import pk.modelDto.UserDto;
import pk.repository.UserJpaRepository;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {


    private final UserJpaRepository userJpaRepository;

    @Autowired
    public UserDetailsServiceImpl(UserJpaRepository userJpaRepository) {
        this.userJpaRepository = userJpaRepository;
    }


    @Override
    public UserDetails loadUserByUsername(String userName) throws UsernameNotFoundException {
        Optional<User> userOptinal = userJpaRepository.findUserByUserName(userName);
        if (userOptinal.isEmpty()) {
            throw new UsernameNotFoundException("User with email: " + userName + " not found !");

        } else {
            User user = userOptinal.get();
            return new org.springframework.security.core.userdetails.User(
                    user.getUserName(),
                    user.getPasswordHash(),
                    user.getRoles()
                            .stream()
                            .map(role -> new SimpleGrantedAuthority(role.getName()))
                            .collect(Collectors.toSet())

            );
        }
    }



}
