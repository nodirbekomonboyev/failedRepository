package org.example.repository;

import java.util.*;
import java.util.UUID;


public interface RootsRepository {

    String DISTINCT_DATES = "SELECT DISTINCT r.createdDate FROM roots r WHERE r.owner.username = ?";
}
