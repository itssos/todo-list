package dev.itssos.TodoListAPI.repository;

import dev.itssos.TodoListAPI.model.Task;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TaskRepository extends JpaRepository<Task, Integer> {
}
