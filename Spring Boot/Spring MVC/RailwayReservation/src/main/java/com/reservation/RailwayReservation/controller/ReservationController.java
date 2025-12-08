package com.reservation.RailwayReservation.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import com.reservation.RailwayReservation.model.Reservation;

@Controller
@RequestMapping("/railwayreservation")
public class ReservationController {
	@RequestMapping("/bookingform")
	public String Homepage(Model m) {
		Reservation res = new Reservation();
		m.addAttribute("reservation", res);
		return "bookingform";
	}
	@RequestMapping("/confirmationform")
	public String confirmationform(@ModelAttribute("reservation") Reservation res) {
		return "confirmation";
	}
}
