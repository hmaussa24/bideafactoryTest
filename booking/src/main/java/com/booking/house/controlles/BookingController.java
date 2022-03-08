package com.booking.house.controlles;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.retry.RetryCallback;
import org.springframework.retry.RetryContext;
import org.springframework.retry.support.RetryTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.booking.house.entities.Booking;
import com.booking.house.rest.ApiRetryException;
import com.booking.house.rest.DiscountCodeData;
import com.booking.house.rest.DiscountService;
import com.booking.house.services.BookingServiceImpl;

@RestController
@RequestMapping(path = "/api/booking")
public class BookingController {
	
	@Autowired
	BookingServiceImpl bookingServiceImpl;
	
	private final RestTemplate restTemplate;
	Logger log = org.slf4j.LoggerFactory.getLogger(DiscountService.class);
    private final RetryTemplate retryTemplate;
    
	public BookingController(RestTemplate restTemplate, RetryTemplate retry) {
		this.restTemplate = restTemplate;
		this.retryTemplate = retry;
	}
	
	@GetMapping(path = "/ok")
	public String apiOK() {
		return "api succes ok!";
	}
	
	@PostMapping()
	public ResponseEntity<?> saveBook(@Valid @RequestBody Booking book) {
		boolean discount = false;
		log.info("Si existe el codigo de descuento se entra a verificar");
		if(book.getDiscountCode() != null) {	
		 List<DiscountCodeData> data = this.getDiscountCodes(book.getDiscountCode());
		
		 for (Iterator iterator = data.iterator(); iterator.hasNext();) {
			DiscountCodeData discountCodeData = (DiscountCodeData) iterator.next();
			if(discountCodeData.isStatus() && discountCodeData.getHouseId().equals(book.getHouseId())) {
				log.info("Descuento aplicado " + discountCodeData.getDiscountCode() + " " + discountCodeData.getHouseId() + " " + discountCodeData.isStatus());
				discount = true;
				break;
			}else {
				discount = false;
			}
		 }
		 if(!discount) {
			 log.info("invalit discount");
			return ResponseEntity.status(HttpStatus.CONFLICT).body("invalit discount");
		 }
		}
		log.info("Guardamos la reserva");
		Booking booking = bookingServiceImpl.saveBooking(book);
		return ResponseEntity.status(HttpStatus.CREATED).body("Book Acepted!");
	}
	
	

	
	public List<DiscountCodeData> getDiscountCodes(String code){
		
		log.info("Consultando \"https://622271e2666291106a26a17c.mockapi.io/discount/v1/new?discountCode="+code+"\" ");
		String uri = "https://622271e2666291106a26a17c.mockapi.io/discount/v1/new?discountCode=" + code;
		

		List<DiscountCodeData> results;
        results = retryTemplate.execute(new RetryCallback<List<DiscountCodeData>, RuntimeException>() {
            @Override
            public List<DiscountCodeData> doWithRetry(RetryContext retryContext) {
                // do something in this service
                log.info(String.format("Retry retryTemplateExample %d", LocalDateTime.now().getSecond()));
                try {
                	DiscountCodeData[] result = restTemplate.getForObject(uri, DiscountCodeData[].class);					
                	List<DiscountCodeData> data = Arrays.asList(result);
                	 return data;
				} catch (Exception e) {
					// TODO: handle exception
					 throw new ApiRetryException("Error in process");
				}
                
               
            }
        });
				
		return results;
	}

}
