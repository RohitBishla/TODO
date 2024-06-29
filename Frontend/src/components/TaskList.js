import React, { useState, useEffect } from 'react';
import axios from 'axios';
import TaskItem from './TaskItem';
import { Link } from 'react-router-dom';

const TaskList = () => {
  const [tasks, setTasks] = useState([]);

  useEffect(() => {
    axios.get('http://localhost:8080/api/tasks')
      .then(response => setTasks(response.data))
      .catch(error => console.error('Error fetching tasks:', error));
  }, []);

  return (
    <div>
      <h2>Task List</h2>
      <Link to="/tasks/new"><button>Add New Task</button></Link>
      {tasks.map(task => (
        <TaskItem key={task.id} task={task} setTasks={setTasks} />
      ))}
    </div>
  );
};

export default TaskList;
