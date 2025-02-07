import React from 'react'
import './TestimonialBox.css';

function TestimonialBox(props) {
  return (
    <div className="testimonial-box">
      <h6>{props.name}</h6>
      <p className="title">{props.title}</p>
      <p className="message">"{props.message}"</p>
    </div>
  );
};

export default TestimonialBox;