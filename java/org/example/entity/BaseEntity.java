package org.example.entity;

import lombok.*;
import java.time.LocalDateTime;
import java.util.UUID;

@Getter
@Setter
public abstract class BaseEntity {
    {
        this.id = UUID.randomUUID();
        this.createdDate = LocalDateTime.now();
        this.updatedDate = this.createdDate;
    }
    protected UUID id;
    protected LocalDateTime createdDate;
    protected LocalDateTime updatedDate;

}

