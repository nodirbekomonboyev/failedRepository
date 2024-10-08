package org.example.repository;

import java.util.*;
import java.util.UUID;


public interface RootsRepository {
//    @Query("SELECT DISTINCT r.createdDate FROM roots r WHERE r.owner.username = :username")
//    List<String> findDistinctCreatedDates(@Param("username") String username);
    String ADD_USER = "SELECT DISTINCT r.createdDate FROM roots r WHERE r.owner.username = ?";
}
