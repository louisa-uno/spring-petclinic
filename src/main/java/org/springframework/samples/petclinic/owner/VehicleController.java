package org.springframework.samples.petclinic.owner;

import java.time.LocalDate;
import java.util.Collection;
import java.util.Optional;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.util.StringUtils;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import jakarta.validation.Valid;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping("/owners/{ownerId}")
class VehicleController {

	private static final String VIEWS_VEHICLES_CREATE_OR_UPDATE_FORM = "vehicles/createOrUpdateVehicleForm";

	private final OwnerRepository owners;

	public VehicleController(OwnerRepository owners) {
		this.owners = owners;
	}

	@ModelAttribute("fuelTypes")
	public Collection<VehicleFuelType> populateVehicleFuelTypes() {
		return this.owners.findVehicleFuelTypes();
	}

	@ModelAttribute("owner")
	public Owner findOwner(@PathVariable("ownerId") int ownerId) {
		Optional<Owner> optionalOwner = this.owners.findById(ownerId);
		Owner owner = optionalOwner.orElseThrow(() -> new IllegalArgumentException(
				"Owner not found with id: " + ownerId + ". Please ensure the ID is correct "));
		return owner;
	}

	@ModelAttribute("vehicle")
	public Vehicle findVehicle(@PathVariable("ownerId") int ownerId,
			@PathVariable(name = "vehicleId", required = false) Integer vehicleId) {

		if (vehicleId == null) {
			return new Vehicle();
		}

		Optional<Owner> optionalOwner = this.owners.findById(ownerId);
		Owner owner = optionalOwner.orElseThrow(() -> new IllegalArgumentException(
				"Owner not found with id: " + ownerId + ". Please ensure the ID is correct "));
		return owner.getVehicle(vehicleId);
	}

	@InitBinder("owner")
	public void initOwnerBinder(WebDataBinder dataBinder) {
		dataBinder.setDisallowedFields("id");
	}

	@InitBinder("vehicle")
	public void initVehicleBinder(WebDataBinder dataBinder) {
		dataBinder.setValidator(new VehicleValidator());
	}

	@GetMapping("/vehicles/new")
	public String initCreationForm(Owner owner, ModelMap model) {
		Vehicle vehicle = new Vehicle();
		owner.addVehicle(vehicle);
		return VIEWS_VEHICLES_CREATE_OR_UPDATE_FORM;
	}

	@PostMapping("/vehicles/new")
	public String processCreationForm(Owner owner, @Valid Vehicle vehicle, BindingResult result,
			RedirectAttributes redirectAttributes) {

		if (result.hasErrors()) {
			return VIEWS_VEHICLES_CREATE_OR_UPDATE_FORM;
		}

		owner.addVehicle(vehicle);
		this.owners.save(owner);
		redirectAttributes.addFlashAttribute("message", "New Vehicle has been Added");
		return "redirect:/owners/{ownerId}";
	}

	@GetMapping("/vehicles/{vehicleId}/edit")
	public String initUpdateForm() {
		return VIEWS_VEHICLES_CREATE_OR_UPDATE_FORM;
	}

	@PostMapping("/vehicles/{vehicleId}/edit")
	public String processUpdateForm(Owner owner, @Valid Vehicle vehicle, BindingResult result,
			RedirectAttributes redirectAttributes) {
		if (result.hasErrors()) {
			return VIEWS_VEHICLES_CREATE_OR_UPDATE_FORM;
		}

		updateVehicleDetails(owner, vehicle);
		redirectAttributes.addFlashAttribute("message", "Vehicle details has been edited");
		return "redirect:/owners/{ownerId}";
	}

	private void updateVehicleDetails(Owner owner, Vehicle vehicle) {
		Vehicle existingVehicle = owner.getVehicle(vehicle.getId());
		if (existingVehicle != null) {
			// Update existing vehicle's properties
			existingVehicle.setFuelType(vehicle.getFuelType());
			existingVehicle.setLicensePlate(vehicle.getLicensePlate());
			existingVehicle.setSeats(vehicle.getSeats());
			existingVehicle.setColor(vehicle.getColor());
			existingVehicle.setBrand(vehicle.getBrand());
			existingVehicle.setModel(vehicle.getModel());
		}
		else {
			owner.addVehicle(vehicle);
		}
		this.owners.save(owner);
	}

}
