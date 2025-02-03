import React from 'react';
import { Link } from 'react-router-dom';
import '../nav-style/style.css';

function HomePage() {
  return (
    <div className="home-page">
      <nav>
        <div className="logo">Testimonial</div>
        <ul>
          <li><a href="#">Customers</a></li>
          <li><a href="#">Features</a></li>
          <li><a href="#">Integrations</a></li>
          <li><a href="#">Pricing</a></li>
          <li><a href="#">EN</a></li>
          <li><a href="#" className="sign-in">Sign in</a></li>
          <li><Link to="/signup" className="sign-up">Sign up</Link></li>
        </ul>
      </nav>

      <div className='body'>
        fsd.
      </div>
    </div>
  )
}

export default HomePage