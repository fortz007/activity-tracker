<h1>Activity Tracker API using Spring Boot</h1>
Activity Tracker is an API built using Spring Boot and PostgreSQL that allows users to track their daily activities. With this application, users can create, view, edit, and delete tasks, as well as move them between categories like pending, done, and in progress.

<h2>Tools Used</h2>
<li>Spring Boot 3.0.6</li>
<li>PostgreSQL</li>
<li>Git</li>
<li>Spring Data JPA</li>
<li>Postman</li>

<h2>Tasks</h2>
<li>POST /api/tasks: Create a new task with the provided title, description, and status. Returns the created task with a unique ID.</li>
<li>GET /api/tasks: Get a list of all tasks.</li>
<li>GET /api/tasks/{taskId}: Get the task with the specified ID.</li>
<li>GET /api/tasks/pending: Get a list of all pending tasks.</li>
<li>GET /api/tasks/done: Get a list of all tasks marked as done.</li>
<li>GET /api/tasks/inprogress: Get a list of all tasks marked as in progress.</li>
<li>PUT /api/tasks/{taskId}: Update the task with the specified ID. Only the title, description, and status can be updated.
</li>
<li>DELETE /api/tasks/{taskId}: Delete the task with the specified ID.</li>

<h2>Task Status</h2>
<li>PUT /api/tasks/{taskId}/pending: Move the task with the specified ID to pending status.</li>
<li>PUT /api/tasks/{taskId}/done: Move the task with the specified ID to done status.</li>
<li>PUT /api/tasks/{taskId}/inprogress: Move the task with the specified ID to in progress status.</li>


<h2>Conclusion</h2>
This Activity Tracker API built using Spring Boot provides a simple and efficient way for users to create and manage their daily activities. With the provided endpoints and data schema, developers can build scalable and maintainable applications that can be easily extended and customized to meet specific needs.


