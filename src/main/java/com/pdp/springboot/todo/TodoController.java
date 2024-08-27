package com.pdp.springboot.todo;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author Doniyor Nishonov
 * @since 26/August/2024  18:49
 **/

@RestController
@RequestMapping("/api/todo")
@Tag(name = "Todo Controller",description = "Ushbu Controller Todo entity bilan ishlash uchun yaratilgan")
public class TodoController {
    private final TodoRepository todoRepository;

    public TodoController(TodoRepository todoRepository) {
        this.todoRepository = todoRepository;
    }

    @Operation(summary = "Id bo'yicha Todoni topuvchi endpoint",description = "Ushbu endpoint orqali id bilan Todoni qidirish mumkin va malumotlar JSON formatda qaytadi")
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "Berilgan Id bo'yicha Todo topildi", content = {
                    @Content(mediaType = MediaType.APPLICATION_JSON_VALUE,
                            schema = @Schema(implementation = Todo.class))
            }),
            @ApiResponse(responseCode = "400", description = "Berilgan Id bo'yicha Todo topilmadi", content = {
                    @Content(mediaType = MediaType.APPLICATION_JSON_VALUE,
                            schema = @Schema(implementation = EntityNotFoundException.class))
            }),
            @ApiResponse(responseCode = "500", description = "Server da xatolik", content = {
                    @Content(mediaType = MediaType.APPLICATION_JSON_VALUE,
                            schema = @Schema(implementation = RuntimeException.class))
            })
    })
    @GetMapping("/{id}")
    public ResponseEntity<Todo> getTodo(@PathVariable Integer id) {
        Todo todo = todoRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Todo Not Found With ID: " + id));
        return ResponseEntity.ok(todo);
    }

    @GetMapping("/")
    public ResponseEntity<List<Todo>> getAllTodo() {
        List<Todo> todos = todoRepository.findAll();
        return ResponseEntity.ok(todos);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteTodo(@PathVariable Integer id) {
        Todo todo = todoRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Todo Not Found With ID: " + id));
        todoRepository.delete(todo);
        return ResponseEntity.notFound().build();
    }

    @PostMapping("/")
    public ResponseEntity<Todo> saveTodo(@RequestBody Todo todo) {
        return ResponseEntity.status(HttpStatus.CREATED).body(todoRepository.save(todo));
    }
}
