package org.example.repository;

import org.example.entity.UserEntity;

import java.util.Optional;


public interface UserRepository extends BaseRepository<UserEntity> {

    String ADD_USER = "select * from add_user(?, ?, ?, ?, ?);";

    String GET_BY_ID = "select * from users u where u.id = ?;";

    String CHECK_PASSWORD = "select u.id from users u where u.username = ? and u.password = ?";

}
