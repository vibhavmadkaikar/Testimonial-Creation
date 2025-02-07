import React, { useState } from "react";
import { useNavigate } from "react-router-dom";
import ReactStars from "react-rating-stars-component";
import "../body/bodyStyle.css";

function TestimonialForm() {
  const [rating, setRating] = useState(0);
  const [customerAbout, setCustomerAbout] = useState("");
  const [description, setDescription] = useState("");
  const navigate = useNavigate();

  const handleSubmit = async (e) => {
    e.preventDefault();

    const createdAt = new Date().toISOString();

    const testimonialData = {
      rating,
      customerAbout,
      description,
      createdAt,
    };

    try {
      const response = await axios.post(
        "http://localhost:4000/testimonials/addTestimonial",
        testimonialData
      );
      console.log(response.data);
      navigate("/login");
    } catch (error) {
      console.error("There was an error!", error);
    }
  };

  return (
    <div className="body-container">
      <div style={styles.formContainer}>
        <h2 style={styles.heading}>Share Your Testimonial</h2>
        <form onSubmit={handleSubmit} style={styles.form} method="post">
          <div style={styles.inputGroup}>
            <label htmlFor="rating" style={styles.label}>
              Rating*
            </label>
            <ReactStars
              count={5}
              onChange={setRating}
              size={30}
              activeColor="#ffd700"
              value={rating}
            />
          </div>
          <div style={styles.inputGroup}>
            <label htmlFor="customerAbout" style={styles.label}>
              Customer About*
            </label>
            <input
              type="text"
              id="customerAbout"
              value={customerAbout}
              onChange={(e) => setCustomerAbout(e.target.value)}
              required
              style={styles.input}
            />
          </div>
          <div style={styles.inputGroup}>
            <label htmlFor="description" style={styles.label}>
              Description*
            </label>
            <textarea
              id="description"
              value={description}
              onChange={(e) => setDescription(e.target.value)}
              required
              style={{ ...styles.input, ...styles.textarea }}
            />
          </div>
          <button type="submit" style={styles.submitButton}>
            Submit
          </button>
        </form>
      </div>
    </div>
  );
}

const styles = {
  formContainer: {
    width: "100%",
    maxWidth: "500px",
    margin: "0 auto",
    padding: "20px",
    backgroundColor: "#f9f9f9",
    borderRadius: "10px",
    boxShadow: "0 4px 8px rgba(0, 0, 0, 0.1)",
  },
  heading: {
    marginBottom: "20px",
    fontSize: "24px",
    color: "#333",
    textAlign: "center",
  },
  form: {
    display: "flex",
    flexDirection: "column",
  },
  inputGroup: {
    marginBottom: "15px",
  },
  label: {
    display: "block",
    marginBottom: "5px",
    fontSize: "16px",
    color: "#555",
  },
  input: {
    width: "100%",
    padding: "10px",
    border: "1px solid #ccc",
    borderRadius: "5px",
    fontSize: "16px",
    boxSizing: "border-box",
  },
  textarea: {
    minHeight: "100px",
    resize: "vertical",
  },
  submitButton: {
    width: "100%",
    padding: "12px",
    backgroundColor: "#28a745",
    color: "#fff",
    border: "none",
    borderRadius: "5px",
    fontSize: "18px",
    cursor: "pointer",
    marginTop: "10px",
  },
};

export default TestimonialForm;
