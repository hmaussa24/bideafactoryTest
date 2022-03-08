package com.booking.house.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.booking.house.entities.Booking;

@Repository
public interface BookingRespository  extends CrudRepository<Booking, String>{

}
