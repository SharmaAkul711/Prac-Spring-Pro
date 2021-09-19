package com.pracSpringPro.Repositories;

import com.pracSpringPro.Entities.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface UserRepository extends JpaRepository<User,Long> {

    User findUserById(Long id);

}
