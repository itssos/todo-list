package dev.itssos.TodoListAPI.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;
/**
 * Excepción lanzada cuando no se encuentra una tarea.
 */
@ResponseStatus(HttpStatus.NOT_FOUND)
public class TaskNotFoundException extends RuntimeException{
    /**
     * Construye una nueva excepción con el mensaje específico.
     *
     * @param message Mensaje que describe la razón de la excepción.
     */
    public TaskNotFoundException(String message){
        super(message);
    }
}
