import React from 'react'
import { Link } from 'react-router-dom';
import "../nav-style/style.css"
import '../body/bodyStyle.css'

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

      <div className='body-container'>
        fsd.
      </div>
    </div>
  )
}

export default Login;