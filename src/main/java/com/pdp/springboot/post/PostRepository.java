package com.pdp.springboot.post;

import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author Doniyor Nishonov
 * @since 26/August/2024  18:47
 **/
public interface PostRepository extends JpaRepository<Post, Integer> {
}