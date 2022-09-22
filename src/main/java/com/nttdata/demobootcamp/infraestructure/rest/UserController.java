package com.nttdata.demobootcamp.infraestructure.rest;

import com.nttdata.demobootcamp.application.UserService;
import com.nttdata.demobootcamp.domain.User;
import lombok.AllArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/redis")
@AllArgsConstructor
public class UserController {

    final Logger logger = LoggerFactory.getLogger(UserController.class);

    private final UserService userService;

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public User getUserById(@PathVariable("id") Integer id) {
        return userService.getUserForId(id);
    }

    @RequestMapping(value = "/sin/{userId}", method = RequestMethod.GET)
    public User getById(@PathVariable("userId") Integer id) {
        logger.info("Getting user with ID {}.", id);
        return userService.getUserId(id);
    }

}
