package org.springframework.samples.petclinic.owner;

import java.lang.reflect.Type;
import java.time.LocalDate;
import java.util.Collection;
import java.util.LinkedHashSet;
import java.util.Set;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.samples.petclinic.model.BaseEntity;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OrderBy;
import jakarta.persistence.Table;

import jakarta.validation.constraints.NotBlank;

@Entity
@Table(name = "vehicles")
public class Vehicle extends BaseEntity {

	// engine: OBJECT (diesel, petrol, electic, hydrogen, hybrid)
	// license plate: STING (M-AB 12345E)
	// seats: NUMBER (1-7)
	// color: STING (blue)
	// brand: STING (BMW)
	// model: STING (Twingo)
	@ManyToOne
	@JoinColumn(name = "fuel_type_id")
	private VehicleFuelType fuelType;

	@Column(name = "license_plate")
	@NotBlank
	private String licensePlate;

	@Column(name = "seats")
	private Integer seats;

	@Column(name = "color")
	@NotBlank
	private String color;

	@Column(name = "brand")
	@NotBlank
	private String brand;

	@Column(name = "model")
	@NotBlank
	private String model;

	public VehicleFuelType getFuelType() {
		return this.fuelType;
	}

	public void setFuelType(VehicleFuelType fuelType) {
		this.fuelType = fuelType;
	}

	public String getLicensePlate() {
		return this.licensePlate;
	}

	public void setLicensePlate(String licensePlate) {
		this.licensePlate = licensePlate;
	}

	public Integer getSeats() {
		return this.seats;
	}

	public void setSeats(Integer seats) {
		this.seats = seats;
	}

	public void setSeats(String seats) {
		this.seats = Integer.parseInt(seats);
	}

	public String getColor() {
		return this.color;
	}

	public void setColor(String color) {
		this.color = color;
	}

	public String getBrand() {
		return this.brand;
	}

	public void setBrand(String brand) {
		this.brand = brand;
	}

	public String getModel() {
		return this.model;
	}

	public void setModel(String model) {
		this.model = model;
	}

	public String getName() {
		return this.getBrand() + " " + this.getModel();
	}

	@Override
	public String toString() {
		return this.getName();
	}

}
