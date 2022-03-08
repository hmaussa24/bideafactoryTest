package com.booking.house.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.booking.house.entities.Booking;
import com.booking.house.repositories.BookingRespository;

@Service
public class BookingServiceImpl implements BookingService {
	
	@Autowired
	BookingRespository bookingRespository;

	@Override
	public Booking saveBooking(Booking book) {
		// TODO Auto-generated method stub
		return bookingRespository.save(book);
	}

}
