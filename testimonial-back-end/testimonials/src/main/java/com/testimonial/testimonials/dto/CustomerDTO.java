package com.testimonial.testimonials.dto;

public class CustomerDTO {
    private Integer customerid;
    private String customername;
    private String customeremail;
    private String description;
	
    public CustomerDTO() {
		super();
	}

	public Integer getCustomerid() {
		return customerid;
	}

	public String getCustomername() {
		return customername;
	}

	public void setCustomername(String customername) {
		this.customername = customername;
	}

	public String getCustomeremail() {
		return customeremail;
	}

	public void setCustomeremail(String customeremail) {
		this.customeremail = customeremail;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}
    
    
}
