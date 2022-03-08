package com.booking.house.rest;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.slf4j.Logger;
import org.springframework.web.client.RestTemplate;

public class DiscountService {
	
	private List<DiscountCodeData> daCodeDatas;
	 
    public DiscountService() {
		// TODO Auto-generated constructor stub
    	daCodeDatas = new ArrayList<>();
	}

	public List<DiscountCodeData> getDaCodeDatas() {
		return daCodeDatas;
	}

	public void setDaCodeDatas(List<DiscountCodeData> daCodeDatas) {
		this.daCodeDatas = daCodeDatas;
	}
    
    

}
