import React from "react";
import { BrowserRouter as Router, Route, Routes } from "react-router-dom";
import HomePage from "./home-component/HomePage";
import Login from "./login-component/Login";
import SignUp from "./signup-component/SignUp";
import UserSignUp from "./signup-component/UsersSignUp";
import CustomerSignUp from "./signup-component/CustomerSignUp";
import SignIn from "./signin-component/SignIn";
import UserSignIn from "./signin-component/UserSignIn";

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
          <Route path="/signin" element={<SignIn />} />
          <Route path="/userSignIn" element={<UserSignIn />} />
        </Routes>
      </Router>
    </>
  );
}

export default App;
