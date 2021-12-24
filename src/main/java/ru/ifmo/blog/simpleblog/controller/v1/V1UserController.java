package ru.ifmo.blog.simpleblog.controller.v1;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.ifmo.blog.simpleblog.model.User;
import ru.ifmo.blog.simpleblog.service.UserService;

@RestController
@RequestMapping("v1/user/")
@RequiredArgsConstructor
@Slf4j
public class V1UserController {
    private final UserService userService;

    @ResponseBody
    @PostMapping("register")
    public User register(@RequestBody User user) {
        log.debug("Got request on register user: {}", user);

        return userService.registerUser(user);
    }

    @ResponseBody
    @GetMapping("{id}")
    public ResponseEntity<User> findUser(@PathVariable(name = "id") long id) {
        log.debug("Finding user by id: {}", id);

        var userOpt = userService.findUser(id);
        if (userOpt.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        return new ResponseEntity<>(userOpt.get(), HttpStatus.OK);
    }
}
