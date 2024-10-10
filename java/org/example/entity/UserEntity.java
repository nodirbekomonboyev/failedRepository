package org.example.entity;

import lombok.*;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.UUID;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class UserEntity extends BaseEntity {
    private String username;
    private String password;

    public static UserEntity map(ResultSet resultSet) throws SQLException {
        UserEntity user = UserEntity.builder()
                .username(resultSet.getString("username"))
                .password(resultSet.getString("password"))
                .build();
        user.setId(UUID.fromString(resultSet.getString("id")));
        user.setCreatedDate(resultSet.getTimestamp("created_date").toLocalDateTime());
        user.setUpdatedDate(resultSet.getTimestamp("updated_date").toLocalDateTime());
        return user;
    }
}
