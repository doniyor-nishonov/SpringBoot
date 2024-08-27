package com.pdp.springboot.comment;

import jakarta.persistence.*;
import lombok.*;

/**
 * @author Doniyor Nishonov
 * @since 26/August/2024  18:43
 **/

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Comment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private Integer postId;
    private String name;
    private String email;
    @Column(length = 1000)
    private String body;
}
