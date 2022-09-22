package com.nttdata.demobootcamp.application;

import com.nttdata.demobootcamp.domain.User;
import com.nttdata.demobootcamp.infraestructure.repository.UserRepository;
import com.nttdata.demobootcamp.infraestructure.rest.UserController;
import lombok.AllArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@AllArgsConstructor
public class UserService {

    final Logger logger = LoggerFactory.getLogger(UserService.class);
    private final UserRepository userRepository;

    @Cacheable(value = "userCache")
    public User getUserForId(Integer id) {
        logger.info("Getting user with ID {}.", id);
        return userRepository.findById(id)
                .orElseThrow(RuntimeException::new);
    }

    public User getUserId(Integer id) {
        Optional<User> optional = userRepository.findById(id);
        return optional.get();
    }

}
