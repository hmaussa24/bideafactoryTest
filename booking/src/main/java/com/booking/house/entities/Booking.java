package com.booking.house.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;

import org.springframework.lang.NonNull;

@Entity
@Table(name = "book")
public class Booking {
	
	@Id
	@Column(name = "id", nullable = false, length = 10)
	@NonNull
	@NotBlank(message = "Required property 'id'")
	private String id;
	
	@Column(name = "name", nullable = false, length = 50)
	@NonNull
	@NotBlank(message = "Required property 'name'")
	private String name;
	
	@Column(name ="lastname", nullable = false, length = 50)
	@NonNull
	@NotBlank(message = "Required property 'lastname'")
	private String lastname;
	
	@Column(name="age", nullable = false, length = 3)
    @Min(18)
	@Max(100)
	@NonNull
	private int age;
	
	@Column(name="phoneNumber", nullable = false, length = 20)
	@NonNull
	@NotBlank(message = "Required property 'numberPhone'")
	private String phoneNumber;
	
	@Column(name="startDate", nullable = false)
	@NonNull
	@NotBlank(message = "Required property 'startDate'")
	private String startDate;
	
	@Column(name="endDate", nullable = false)
	@NonNull
	@NotBlank(message = "Required property 'endDate'")
	private String endDate;
	
	@Column(name="houseId", nullable = false, length = 15)
	@NonNull
	@NotBlank(message = "Required property 'houseId'")
	private String houseId;
	
	@Column(name="discountCode", length = 8, nullable = true)
	private String discountCode;
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getLastname() {
		return lastname;
	}
	public void setLastname(String lastname) {
		this.lastname = lastname;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public String getPhoneNumber() {
		return phoneNumber;
	}
	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}
	public String getStartDate() {
		return startDate;
	}
	public void setStartDate(String startDate) {
		this.startDate = startDate;
	}
	public String getEndDate() {
		return endDate;
	}
	public void setEndDate(String endtDate) {
		this.endDate = endtDate;
	}
	public String getHouseId() {
		return houseId;
	}
	public void setHouseId(String houseId) {
		this.houseId = houseId;
	}
	public String getDiscountCode() {
		return discountCode;
	}
	public void setDiscountCode(String discountCode) {
		this.discountCode = discountCode;
	}
	
	

}
