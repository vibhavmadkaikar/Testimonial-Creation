import React from 'react'
import { Link } from 'react-router-dom'

function NavComponent() {
    return (
        <div>
            <nav>
                <div className="logo">Testimonial</div>
                <ul>
                    <li><a href="#">Customers</a></li>
                    <li><a href="#">Features</a></li>
                    <li><a href="#">Integrations</a></li>
                    <li><a href="#">Pricing</a></li>
                    <li><a href="#">EN</a></li>
                    <li><Link to="/signin" className="sign-in">Sign in</Link></li>
                    <li><Link to="/signup" className="sign-up">Sign up</Link></li>
                </ul>
            </nav>
        </div>
    )
}

export default NavComponent