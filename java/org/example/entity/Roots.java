package org.example.entity;


import lombok.*;

import java.util.UUID;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class Roots extends BaseEntity {

    private UUID owner;
    private String eng;
    private String uz;
}
