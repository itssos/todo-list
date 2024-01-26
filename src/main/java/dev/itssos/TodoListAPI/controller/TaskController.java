package dev.itssos.TodoListAPI.controller;

import dev.itssos.TodoListAPI.model.Task;
import dev.itssos.TodoListAPI.model.TaskState;
import dev.itssos.TodoListAPI.service.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/api/v1/tasks")
public class TaskController {
    @Autowired
    private TaskService taskService;

    @GetMapping
    public ResponseEntity<List<Task>> getAllTasks(){
        return ResponseEntity.ok(taskService.getAllTasks());
    }

    @GetMapping("/{taskId}")
    public ResponseEntity<Task> getTaskById(@PathVariable int taskId){
        return ResponseEntity.ok(taskService.getTaskById(taskId));
    }

    @PostMapping
    public ResponseEntity<Task> create(@RequestBody Task task){
        return new ResponseEntity<>(taskService.create(task), HttpStatus.CREATED);
    }

    @PutMapping("/{taskId}/description")
    public ResponseEntity<Task> updateDescription(@RequestBody String newDescription, @PathVariable int taskId){
        if (newDescription != null && !newDescription.trim().isBlank()) {
            return ResponseEntity.ok(taskService.updateDescription(taskId, newDescription));
        } else {
            throw new IllegalArgumentException("Invalid task DESCRIPTION");
        }
    }

    @PutMapping("/{taskId}/state")
    public ResponseEntity<Task> updateState(@RequestBody String newState, @PathVariable int taskId){
        return ResponseEntity.ok(taskService.updateState(taskId, newState));
    }

    @DeleteMapping("/{taskId}")
    public ResponseEntity<String> delete(@PathVariable int taskId){
        taskService.delete(taskId);
        return ResponseEntity.ok("Task deleted successfully");
    }

}
