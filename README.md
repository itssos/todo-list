
# Todo List API

This project is a simple to-do list API without authentication.


## Database installation

The table is generated automatically, but you must create the MySQL database with the name 'todo-list-api'

```sql
  CREATE DATABASE todo_list_api;
```
    
## API Reference

#### Get all tasks

```api
  GET /api/v1/tasks
```

#### Get task

```http
  GET /api/v1/tasks/{taskId}
```

| Parameter | Type     | Description                       |
| :-------- | :------- | :-------------------------------- |
| `taskId`      | `int` | [**Required**] Id of task to fetch |

#### Create task

```http
  POST /api/v1/tasks
```

| Parameter | Type     | Description                       |
| :-------- | :------- | :-------------------------------- |
| `description`      | `String` | [**Required**] Task description |
| `state`      | `ENUM(PENDING, COMPLETED)` | <Optional> Task state, default = PENDING |

