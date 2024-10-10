package org.example.repository;

import org.example.config.BeanConfig;
import org.example.entity.UserEntity;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.Optional;
import java.util.UUID;


public class UserRepositoryImpl implements UserRepository{

    private final Connection connection = BeanConfig.connection();

    private static UserRepository instance;

    public static UserRepository getInstance() {
        if(instance == null) {
            instance = new UserRepositoryImpl();
        }
        return instance;
    }

    @Override
    public String save(UserEntity user) {
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(ADD_USER);
            preparedStatement.setString(1, user.getId().toString());
            preparedStatement.setString(2, user.getUsername());
            preparedStatement.setString(3, user.getPassword());
            preparedStatement.setString(4, user.getCreatedDate().toString());
            preparedStatement.setString(5, user.getUpdatedDate().toString());

            ResultSet resultSet = preparedStatement.executeQuery();
            resultSet.next();
            return resultSet.getString("add_user");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public Optional<UserEntity> getById(UUID id) {
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(GET_BY_ID);
            preparedStatement.setString(1, id.toString());

            ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                return Optional.of(UserEntity.map(resultSet));
            }
            return Optional.empty();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public List<UserEntity> getAll() {
        return null;
    }
}
