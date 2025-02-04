import React from 'react';
import { Link } from 'react-router-dom';
import '../body/bodyStyle.css'
import '../nav-style/style.css';

function SignUp() {
    return (
        <>
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
            </div>

            <div className='body-container'>
                <div style={styles.card}>
                    <h2 style={styles.heading}>Choose Sign Up Type</h2>
                    <div style={styles.buttonContainer}>
                        <Link to="/userSignUp" style={styles.link}>User Sign Up</Link>
                        <Link to="/customerSignUp" style={styles.link}>Customer Sign Up</Link>
                    </div>
                </div>
            </div>
        </>
    );
}

const styles = {
    card: {
        backgroundColor: '#fff',
        padding: '40px',
        borderRadius: '12px',
        boxShadow: '0px 10px 30px rgba(0, 0, 0, 0.1)',
        textAlign: 'center',
        width: '350px',
    },
    heading: {
        marginBottom: '20px',
        fontSize: '24px',
        color: '#333',
        fontWeight: 'bold',
    },
    buttonContainer: {
        display: 'flex',
        flexDirection: 'column',  // Aligns buttons vertically
        alignItems: 'center',
        gap: '15px', // Adds space between buttons
    },
    link: {
        display: 'block',
        width: '80%', // Ensures buttons are properly aligned
        padding: '12px 20px',
        fontSize: '18px',
        color: '#fff',
        backgroundColor: '#007BFF',
        textDecoration: 'none',
        borderRadius: '8px',
        fontWeight: 'bold',
        textAlign: 'center',
        transition: 'all 0.3s ease-in-out',
        boxShadow: '0px 5px 15px rgba(0, 123, 255, 0.3)',
    },
    linkHover: {
        backgroundColor: '#0056b3',
        transform: 'scale(1.05)',
    }
};

export default SignUp;