import React, { useState, useEffect } from 'react';
import { Link } from 'react-router-dom';
import axios from 'axios';
import "../nav-style/style.css";
import '../body/bodyStyle.css';

function Login() {
  const [user, setUser] = useState(null);

  useEffect(() => {
    console.log("Fetching user session...");
    const fetchUserData = async () => {
      try {
        const response = await axios.get("http://localhost:4000/users/login", {
          withCredentials: true,
        });
        setUser(response.data);
        console.log("User data received:", response.data);
        console.log("User data received:", user);
      } catch (error) {
        console.error("Error fetching user session:", error);
      }
    };
  
    fetchUserData();
  }, []);

  return (
    <div className="home-page">
      <nav>
        <div className="logo">Testimonial</div>
        <ul>
          <li>{user ? user.username : "Guest"}</li>
          <li><Link to="/" className="logout">Logout</Link></li>
        </ul>
      </nav>

      <div className='body-container'>
        Welcome, {user ? user.username : "Guest"}!
      </div>
    </div>
  );
}

export default Login;
