import React from 'react'
import LoginNavigation from "../nav-component/LoginNavigation"
import { Link } from 'react-router-dom';
import "../bodyStyle.css"

function CustomerLoginComponent() {

  const savedCustomerName = localStorage.getItem("savedCustomerName");

  return (
    <>
      <LoginNavigation name={savedCustomerName} />

      <main className='body-container'>
        <Link to="/addTestimonial" style={styles.add}>Add Testimonial</Link>
      </main>
    </>
  )
}

const styles = {
  add: {
    position: "absolute",
    top: "100px",
    right: "30px",
    backgroundColor: "#28a745",
    color: "white",
    padding: "10px 15px",
    fontSize: "16px",
    textDecoration: "none",
    borderRadius: "5px",
    fontWeight: "bold",
    textAlign: "center"
  }
}

export default CustomerLoginComponent