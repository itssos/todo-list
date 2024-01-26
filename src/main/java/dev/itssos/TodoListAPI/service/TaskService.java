package dev.itssos.TodoListAPI.service;

import dev.itssos.TodoListAPI.exception.TaskNotFoundException;
import dev.itssos.TodoListAPI.model.Task;
import dev.itssos.TodoListAPI.model.TaskState;
import dev.itssos.TodoListAPI.repository.TaskRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TaskService {
    @Autowired
    private TaskRepository taskRepository;

    public List<Task> getAllTasks(){
        return taskRepository.findAll();
    }

    public Task getTaskById(int taskId){
        if (taskRepository.existsById(taskId)){
            return taskRepository.findById(taskId).orElse(null);
        }else{
            throw new TaskNotFoundException("Invalid task ID");
        }
    }

    public Task create(Task task){
        return taskRepository.save(task);
    }

    public void delete(int taskId){
        if (taskRepository.existsById(taskId)){
            taskRepository.deleteById(taskId);
        }else{
            throw new TaskNotFoundException("Invalid task ID");
        }
    }

    public Task updateDescription(int taskId, String newDescription) {
        Task existingTask = taskRepository.findById(taskId).orElse(null);
        if (existingTask != null) {
            if (newDescription != null && !newDescription.trim().isBlank()) {
                existingTask.setDescription(newDescription);
                return taskRepository.save(existingTask);
            } else {
                throw new IllegalArgumentException("Invalid task DESCRIPTION");
            }
        } else {
            throw new TaskNotFoundException("Invalid task ID");
        }
    }

    public Task updateState(int taskId, String newState) {
        Task existingTask = taskRepository.findById(taskId).orElse(null);

        if (existingTask != null) {
            if(newState.equals("COMPLETED") || newState.equals("PENDING")){
                TaskState state = TaskState.valueOf(newState);
                existingTask.setState(state);
                return taskRepository.save(existingTask);
            }
            throw new TaskNotFoundException("Invalid task STATE");
        } else {
            throw new TaskNotFoundException("Invalid task ID");
        }
    }

}
