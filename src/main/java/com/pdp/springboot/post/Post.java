package com.pdp.springboot.post;

import jakarta.persistence.*;
import lombok.*;

/**
 * @author Doniyor Nishonov
 * @since 26/August/2024  18:45
 **/

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Post {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private Integer userId;
    private String title;
    @Column(length = 1000)
    private String body;
}
