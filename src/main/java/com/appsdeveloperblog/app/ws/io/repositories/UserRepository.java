package com.appsdeveloperblog.app.ws.io.repositories;

import com.appsdeveloperblog.app.ws.io.entity.UserEntity;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends PagingAndSortingRepository<UserEntity, Long> {

    // To declare custom method we need to write exactly "find" keyword "By" "Email" -> Email is name field from UserEntity
    UserEntity findByEmail(String email);

    UserEntity findByUserId(String id);
}
