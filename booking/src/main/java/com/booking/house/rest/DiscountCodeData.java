package com.booking.house.rest;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class DiscountCodeData {
	
   private boolean status;
   private String  id ;
   private String userId;
   private String houseId;
   private String discountCode;
public boolean isStatus() {
	return status;
}
public void setStatus(boolean status) {
	this.status = status;
}
public String getId() {
	return id;
}
public void setId(String id) {
	this.id = id;
}
public String getUserId() {
	return userId;
}
public void setUserId(String userId) {
	this.userId = userId;
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
