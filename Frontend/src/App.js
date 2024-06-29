import React, { useState } from 'react';
import { BrowserRouter as Router, Routes, Route, Link } from 'react-router-dom';
import TaskList from './components/TaskList';
import TaskForm from './components/TaskForm';
import './App.css'; // Importing the CSS file

const App = () => {
  const [tasks, setTasks] = useState([]);

  return (
    <Router>
      <div className="container">
        <Link to="/" className="logo-button">
          <h1>TODO App</h1>
        </Link>
        <Routes>
          <Route path="/tasks/new" element={<TaskForm setTasks={setTasks} />} />
          <Route path="/tasks/:id/edit" element={<TaskForm setTasks={setTasks} />} />
          <Route path="/" element={<TaskList setTasks={setTasks} />} />
        </Routes>
      </div>
    </Router>
  );
};

export default App;
