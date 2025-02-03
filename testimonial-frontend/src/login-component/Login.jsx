import React from 'react'
import { Link } from 'react-router-dom';
import "../nav-style/style.css"

function Login() {
  return (
    <div className="home-page">
      <nav>
        <div className="logo">Testimonial</div>
        <ul>
          {/* <li className='profile'>${user}</li> */}
          <li><Link to="/signup" className="logout">Logout</Link></li>
        </ul>
      </nav>

      <div className='body'>
        fsd.
      </div>
    </div>
  )
}

export default Login;