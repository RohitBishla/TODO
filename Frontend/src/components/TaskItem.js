import React from 'react';
import axios from 'axios';
import { Link } from 'react-router-dom';

const formatDate = (dateString) => {
  const date = new Date(dateString);
  return date.toLocaleDateString(); // Adjust as per your formatting needs
};

const TaskItem = ({ task, setTasks }) => {
  const deleteTask = () => {
    axios.delete(`http://localhost:8080/api/tasks/${task.id}`)
      .then(() => {
        setTasks(prevTasks => prevTasks.filter(t => t.id !== task.id));
      })
      .catch(error => console.error('Error deleting task:', error));
  };

  return (
    <div className="task-item">
      <h3>{task.description}</h3>
      <p>Status: {task.status}</p>
      <p>Start Date: {formatDate(task.startDate)}</p>
      <p>Target Date: {formatDate(task.targetDate)}</p>
      <button onClick={deleteTask}>Delete</button>
      <Link to={`/tasks/${task.id}/edit`}><button>Edit</button></Link>
    </div>
  );
};

export default TaskItem;
