package com.nttdata.demobootcamp.infraestructure.repository;

import com.nttdata.demobootcamp.domain.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends CrudRepository<User, Integer> {
}
