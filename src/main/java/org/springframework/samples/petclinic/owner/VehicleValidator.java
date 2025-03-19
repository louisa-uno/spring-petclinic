package org.springframework.samples.petclinic.owner;

import org.springframework.util.StringUtils;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

public class VehicleValidator implements Validator {

	private static final String REQUIRED = "required";

	private static final String NOTENOUGH = "notEnough";

	@Override
	public void validate(Object obj, Errors errors) {
		Vehicle vehicle = (Vehicle) obj;
		String licensePlate = vehicle.getLicensePlate();
		String color = vehicle.getColor();
		String brand = vehicle.getBrand();
		String model = vehicle.getModel();

		// fuel type validation
		if (vehicle.isNew() && vehicle.getFuelType() == null) {
			errors.rejectValue("fuelType", REQUIRED, REQUIRED);
		}

		// license plate validation
		if (!StringUtils.hasText(licensePlate)) {
			errors.rejectValue("licensePlate", REQUIRED, REQUIRED);
		}

		// seats validation
		if (vehicle.getSeats() <= 0) {
			errors.rejectValue("seats", NOTENOUGH, NOTENOUGH);
		}

		// color validation
		if (!StringUtils.hasText(color)) {
			errors.rejectValue("color", REQUIRED, REQUIRED);
		}

		// brand validation
		if (!StringUtils.hasText(brand)) {
			errors.rejectValue("brand", REQUIRED, REQUIRED);
		}

		// model validation
		if (!StringUtils.hasText(model)) {
			errors.rejectValue("model", REQUIRED, REQUIRED);
		}
	}

	/**
	 * This Validator validates *just* Vehicle instances
	 */
	@Override
	public boolean supports(Class<?> clazz) {
		return Vehicle.class.isAssignableFrom(clazz);
	}

}
