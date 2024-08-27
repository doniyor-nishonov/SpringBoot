package com.pdp.springboot;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.pdp.springboot.comment.Comment;
import com.pdp.springboot.comment.CommentRepository;
import com.pdp.springboot.post.Post;
import com.pdp.springboot.post.PostRepository;
import com.pdp.springboot.todo.Todo;
import com.pdp.springboot.todo.TodoRepository;
import io.swagger.v3.oas.annotations.ExternalDocumentation;
import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Contact;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.info.License;
import io.swagger.v3.oas.annotations.servers.Server;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.net.URL;
import java.util.List;

@SpringBootApplication
@OpenAPIDefinition(
        info = @Info(
                title = "Spring 6 Swagger With Annotation Config",
                version = "${api.version}",
                contact = @Contact(
                        name = "Doniyor Nishonov", email = "nishonovd80@gmail.com", url = "https://github.com/doniyor-nishonov"
                ),
                license = @License(
                        name = "Apache 2.0",
                        url = "https://springdoc.org"),
                termsOfService = "http://swagger.io/terms/",
                description = "Spring 6 Swagger Simple Application"
        ),
        externalDocs = @ExternalDocumentation(
                description = "Spring 6 Wiki Documentation", url = "https://springshop.wiki.github.org/docs"
        ),
        servers = {
                @Server(
                        url = "http://localhost:8080",
                        description = "Production-Server"
                ),
                @Server(
                        url = "http://localhost:9090",
                        description = "Test-Server"
                )
        }
)
public class Application {

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }
    /*@Bean
    CommandLineRunner commandLineRunner(
            PostRepository postRepository,
            CommentRepository commentRepository,
            TodoRepository todoRepository,
            ObjectMapper objectMapper
    ) {
        return args -> {
            List<Todo> todos = objectMapper.readValue(new URL("https://jsonplaceholder.typicode.com/todos"), new TypeReference<>() {});
            todoRepository.saveAll(todos);
            List<Post> posts = objectMapper.readValue(new URL("https://jsonplaceholder.typicode.com/posts"), new TypeReference<>() {});
            postRepository.saveAll(posts);
            List<Comment> comments = objectMapper.readValue(new URL("https://jsonplaceholder.typicode.com/comments"), new TypeReference<>() {});
            commentRepository.saveAll(comments);
        };
    }*/
}
