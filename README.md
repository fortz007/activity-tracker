<h1>Activity Tracker API using Spring Boot</h1>
Activity Tracker is an API built using Spring Boot and PostgreSQL that allows users to track their daily activities. With this application, users can create, view, edit, and delete tasks, as well as move them between categories like pending, done, and in progress.

<h2>Tools Used</h2>
<li>Spring Boot 3.0.6</li>
<li>PostgreSQL</li>
<li>Git</li>
<li>Spring Data JPA</li>
<li>Postman</li>

<h2>Tasks</h2>
<li>POST /api/v1/activity-tracker/create-task: Create a new task with the provided title, description, and status. Returns the created task with a unique ID.</li>
<li>GET /api/v1/activity-tracker/my-tasks: Get a list of all tasks.</li>
<li>GET /api/v1/activity-tracker/task/{taskId}: Get the task with the specified ID.</li>
<li>GET /api/v1/activity-tracker/my-tasks/{status}: Get a list of tasks by status.</li>
<li>PUT /api/v1/activity-tracker/update-task-title-description/{taskId}: Update the task title description with the specified ID.</li>
<li>PUT /api/v1/activity-tracker/update-task-status/{taskId}: Update the task status with the specified ID.</li>
<li>DELETE /api/tasks//delete-task/{taskId}: Delete the task with the specified ID.</li>



<h2>Conclusion</h2>
This Activity Tracker API built using Spring Boot provides a simple and efficient way for users to create and manage their daily activities. With the provided endpoints and data schema, developers can build scalable and maintainable applications that can be easily extended and customized to meet specific needs.


