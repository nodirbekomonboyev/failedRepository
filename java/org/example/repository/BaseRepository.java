package org.example.repository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface BaseRepository<T> {

    String save(T t);

    Optional<T> getById(UUID id);

    List<T> getAll();


}
