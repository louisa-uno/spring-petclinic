package org.springframework.samples.petclinic.owner;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.condition.DisabledInNativeImage;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.validation.Errors;
import org.springframework.validation.MapBindingResult;

import java.time.LocalDate;
import java.util.HashMap;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

@ExtendWith(MockitoExtension.class)
@DisabledInNativeImage
public class VehicleValidatorTests {

	private VehicleValidator vehicleValidator;

	private Vehicle vehicle;

	private VehicleFuelType vehicleFuelType;

	private Errors errors;

	private static final String vehicleFuelTypeName = "petrol";

	private static final String vehicleLicensePlate = "ABCDEF";

	private static final String vehicleSeats = "123";

	private static final String vehicleColor = "yellow";

	private static final String vehicleBrand = "BMW";

	private static final String vehicleModel = "fastCarDE";

	@BeforeEach
	void setUp() {
		vehicleValidator = new VehicleValidator();
		vehicle = new Vehicle();
		vehicleFuelType = new VehicleFuelType();
		errors = new MapBindingResult(new HashMap<>(), "vehicle");
	}

	@Test
	void testValidate() {
		vehicleFuelType.setName(vehicleFuelTypeName);
		vehicle.setFuelType(vehicleFuelType);
		vehicle.setLicensePlate(vehicleLicensePlate);
		vehicle.setSeats(vehicleSeats);
		vehicle.setColor(vehicleColor);
		vehicle.setBrand(vehicleBrand);
		vehicle.setModel(vehicleModel);

		vehicleValidator.validate(vehicle, errors);

		assertFalse(errors.hasErrors());
	}

	@Nested
	class ValidateHasErrors {

		@Test
		void testValidateWithInvalidVehicleBrand() {
			vehicleFuelType.setName(vehicleFuelTypeName);
			vehicle.setFuelType(vehicleFuelType);
			vehicle.setLicensePlate(vehicleLicensePlate);
			vehicle.setSeats(vehicleSeats);
			vehicle.setColor(vehicleColor);
			vehicle.setBrand("");
			vehicle.setModel(vehicleModel);

			vehicleValidator.validate(vehicle, errors);

			assertTrue(errors.hasFieldErrors("brand"));
		}

		@Test
		void testValidateWithInvalidVehicleFuelType() {
			vehicle.setFuelType(null);
			vehicle.setLicensePlate(vehicleLicensePlate);
			vehicle.setSeats(vehicleSeats);
			vehicle.setColor(vehicleColor);
			vehicle.setBrand(vehicleBrand);
			vehicle.setModel(vehicleModel);

			vehicleValidator.validate(vehicle, errors);

			assertTrue(errors.hasFieldErrors("fuelType"));
		}

	}

}
