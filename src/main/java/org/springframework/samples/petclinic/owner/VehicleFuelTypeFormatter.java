package org.springframework.samples.petclinic.owner;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.Formatter;
import org.springframework.stereotype.Component;

import java.text.ParseException;
import java.util.Collection;
import java.util.Locale;

@Component
public class VehicleFuelTypeFormatter implements Formatter<VehicleFuelType> {

	private final OwnerRepository owners;

	@Autowired
	public VehicleFuelTypeFormatter(OwnerRepository owners) {
		this.owners = owners;
	}

	@Override
	public String print(VehicleFuelType vehicleFuelType, Locale locale) {
		return vehicleFuelType.getName();
	}

	@Override
	public VehicleFuelType parse(String text, Locale locale) throws ParseException {
		Collection<VehicleFuelType> findVehicleFuelTypes = this.owners.findVehicleFuelTypes();
		for (VehicleFuelType type : findVehicleFuelTypes) {
			if (type.getName().equals(text)) {
				return type;
			}
		}
		throw new ParseException("type not found: " + text, 0);
	}

}
