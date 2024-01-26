
# Todo List API

This project is a simple to-do list API without authentication.


## Database installation

The table is generated automatically, but you must create the MySQL database with the name 'todo-list-api'

```sql
  CREATE DATABASE todo_list_api;
```
    
## API Reference

#### Get all tasks

```
  GET /api/v1/tasks
```

#### Get task

```
  GET /api/v1/tasks/{taskId}
```

| Parameter | Type     | Description                       |
| :-------- | :------- | :-------------------------------- |
| `taskId`      | `int` | [**Required**] ID of task to fetch |

#### Create task

```
  POST /api/v1/tasks
```

| Parameter | Type     | Description                       |
| :-------- | :------- | :-------------------------------- |
| `description`      | `String` | [**Required**] Task description |
| `state`      | `ENUM(PENDING, COMPLETED)` | <Optional> Task state, default = PENDING |

#### Update task **description**

```
  POST /api/v1/tasks/{taskId}/description
```

| Parameter | Type     | Description                       |
| :-------- | :------- | :-------------------------------- |
| `taskId`      | `int` | [**Required**] ID of the task to update |
| `description`      | `String` | [**Required**] Task description |

#### Update task **state**

```
  PUT /api/v1/tasks/{taskId}/state
```

| Parameter | Type     | Description                       |
| :-------- | :------- | :-------------------------------- |
| `taskId`      | `int` | [**Required**] ID of the task to update |
| `state`      | `ENUM(PENDING, COMPLETED)` | [**Required**] Task state |

#### Delete task

```
  DELETE /api/v1/tasks/{taskId}
```

| Parameter | Type     | Description                       |
| :-------- | :------- | :-------------------------------- |
| `taskId`      | `int` | [**Required**] ID of the task to delete |


