package org.example.repository;

import org.example.config.BeanConfig;
import org.example.entity.UserEntity;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

public class RootsRepositoryImpl implements RootsRepository{
    private final Connection connection = BeanConfig.connection();

    private static RootsRepository instance;

    public static RootsRepository getInstance() {
        if(instance == null) {
            instance = new RootsRepositoryImpl();
        }
        return instance;
    }

    public List<String> getDistinctDates(UUID userId){
        List<String> distinctDates = new ArrayList<>(); // Bo'sh list yaratamiz

        try {
            PreparedStatement preparedStatement = connection.prepareStatement(DISTINCT_DATES);
            preparedStatement.setString(1, userId.toString());

            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                distinctDates.add(resultSet.getString(1));
            }

            return distinctDates;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
