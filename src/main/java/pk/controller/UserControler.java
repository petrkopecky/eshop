package pk.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import pk.modelDto.ProductDto;
import pk.modelDto.UserDto;
import pk.service.ProductService;
import pk.service.UserService;

import java.util.List;

@RestController
public class UserControler {
    private final UserService userService;

    public UserControler(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/users")
    List<UserDto> users() {
        return userService.getUserList();
    }
}
