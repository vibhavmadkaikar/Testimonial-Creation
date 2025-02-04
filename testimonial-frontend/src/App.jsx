import React from "react";
import { BrowserRouter as Router, Route, Routes } from "react-router-dom";
import HomePage from "./home-component/HomePage";
import Login from "./login-component/Login";
import SignUp from "./signup-component/SignUp";
import UserSignUp from "./signup-component/UsersSignUp";
import CustomerSignUp from "./signup-component/CustomerSignUp";
<<<<<<< HEAD:testimonial-frontend/src/App.jsx
import TestimonialForm from "./testimonial-component/TestimonialForm";
=======
import SignIn from "./signin-component/SignIn";
import UserSignIn from "./signin-component/UserSignIn";
>>>>>>> main:testimonial-frontend/testimonial-frontend/src/App.jsx

function App() {
  return (
    <>
      <Router>
        <Routes>
          <Route path="/" element={<HomePage />} />
          <Route path="/signup" element={<SignUp />} />
          <Route path="/login" element={<Login />} />
          <Route path="/userSignUp" element={<UserSignUp />} />
          <Route path="/customerSignUp" element={<CustomerSignUp />} />
<<<<<<< HEAD:testimonial-frontend/src/App.jsx
          <Route path="/testimonial" element={<TestimonialForm />} />
=======
          <Route path="/signin" element={<SignIn />} />
          <Route path="/userSignIn" element={<UserSignIn />} />
>>>>>>> main:testimonial-frontend/testimonial-frontend/src/App.jsx
        </Routes>
      </Router>
    </>
  );
}

export default App;
