// import axios from "axios";

// export const BASE_URL = "http://localhost:1000";

// export const myAxios = axios.create({
//   baseURL: BASE_URL,
// });

// const express = require("express");
// const cors = require("cors");
// const app = express();

// // Enable CORS for all origins or just your frontend
// app.use(
//   cors({
//     origin: "http://localhost:5173", // Replace with your frontend's URL if different
//     methods: ["GET", "POST", "PUT", "DELETE"],
//     allowedHeaders: ["Content-Type", "Authorization"],
//   })
// );

// app.use(express.json());

// // Example route
// app.post("/users/addUser", (req, res) => {
//   // Handle signup logic here
//   res.json({ message: "User added successfully!" });
// });

// // Start the server
// app.listen(4000, () => {
//   console.log("Server running on http://localhost:4000");
// });

// users-service.js
// import axios from "axios";

// const BASE_URL = "http://localhost:1000"; // Your Spring Boot backend URL

// export const signUp = (user) => {
//   return axios
//     .post(`${BASE_URL}/users/addUser`, user)
//     .then((response) => response.data)
//     .catch((error) => {
//       console.error("Error during sign-up:", error);
//       throw error;
//     });
// };
