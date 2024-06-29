import React, { useState, useEffect } from 'react';
import axios from 'axios';
import { useNavigate, useParams } from 'react-router-dom';

const formatDateForInput = (dateString) => {
  const date = new Date(dateString);
  return date.toISOString().split('T')[0]; // Formats date for input type="date"
};

const TaskForm = ({ setTasks }) => {
  const { id } = useParams();
  const navigate = useNavigate();
  const [description, setDescription] = useState('');
  const [status, setStatus] = useState('TODO');
  const [startDate, setStartDate] = useState('');
  const [targetDate, setTargetDate] = useState('');

  useEffect(() => {
    if (id) {
      axios.get(`http://localhost:8080/api/tasks/${id}`)
        .then(response => {
          const task = response.data;
          setDescription(task.description);
          setStatus(task.status);
          setStartDate(formatDateForInput(task.startDate));
          setTargetDate(formatDateForInput(task.targetDate));
        })
        .catch(error => console.error('Error fetching task:', error));
    }
  }, [id]);

  const handleSubmit = (event) => {
    event.preventDefault();
    const taskData = { description, status, startDate, targetDate };

    if (id) {
      axios.put(`http://localhost:8080/api/tasks/${id}`, taskData)
        .then(response => {
          setTasks(prevTasks => prevTasks.map(t => t.id === id ? response.data : t));
          navigate('/');
        })
        .catch(error => console.error('Error updating task:', error));
    } else {
      axios.post('http://localhost:8080/api/tasks', taskData)
        .then(response => {
          setTasks(prevTasks => [...prevTasks, response.data]);
          navigate('/');
        })
        .catch(error => console.error('Error creating task:', error));
    }
  };

  return (
    <form onSubmit={handleSubmit}>
      <div>
        <label>Description:</label>
        <input
          type="text"
          value={description}
          onChange={(e) => setDescription(e.target.value)}
          required
        />
      </div>
      <div>
        <label>Status:</label>
        <select value={status} onChange={(e) => setStatus(e.target.value)}>
          <option value="TODO">TODO</option>
          <option value="WIP">WIP</option>
          <option value="DONE">DONE</option>
        </select>
      </div>
      <div>
        <label>Start Date:</label>
        <input
          type="date"
          value={startDate}
          onChange={(e) => setStartDate(e.target.value)}
          required
        />
      </div>
      <div>
        <label>Target Date:</label>
        <input
          type="date"
          value={targetDate}
          onChange={(e) => setTargetDate(e.target.value)}
          required
        />
      </div>
      <button type="submit">Save Task</button>
    </form>
  );
};

export default TaskForm;
