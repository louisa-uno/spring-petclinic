package org.springframework.samples.petclinic.owner;

import org.assertj.core.util.Lists;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.condition.DisabledInNativeImage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.FilterType;
import org.springframework.test.context.aot.DisabledInAotMode;
import org.springframework.test.context.bean.override.mockito.MockitoBean;
import org.springframework.test.web.servlet.MockMvc;

import java.time.LocalDate;
import java.util.Optional;

import static org.mockito.BDDMockito.given;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.model;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;

@WebMvcTest(value = VehicleController.class,
		includeFilters = @ComponentScan.Filter(value = VehicleFuelTypeFormatter.class,
				type = FilterType.ASSIGNABLE_TYPE))
@DisabledInNativeImage
@DisabledInAotMode
class VehicleControllerTests {

	private static final int TEST_OWNER_ID = 1;

	private static final int TEST_VEHICLE_ID = 1;

	@Autowired
	private MockMvc mockMvc;

	@MockitoBean
	private OwnerRepository owners;

	@BeforeEach
	void setup() {
		VehicleFuelType air = new VehicleFuelType();
		air.setId(3);
		air.setName("nuclear");
		given(this.owners.findVehicleFuelTypes()).willReturn(Lists.newArrayList(air));

		Owner owner = new Owner();
		Vehicle vehicle = new Vehicle();
		Vehicle bmw = new Vehicle();
		owner.addVehicle(vehicle);
		owner.addVehicle(bmw);
		vehicle.setId(TEST_VEHICLE_ID);
		bmw.setId(TEST_VEHICLE_ID + 1);
		vehicle.setBrand("pretty");
		bmw.setBrand("not pretty");

		given(this.owners.findById(TEST_OWNER_ID)).willReturn(Optional.of(owner));
	}

	@Test
	void testInitCreationForm() throws Exception {
		mockMvc.perform(get("/owners/{ownerId}/vehicles/new", TEST_OWNER_ID))
			.andExpect(status().isOk())
			.andExpect(view().name("vehicles/createOrUpdateVehicleForm"))
			.andExpect(model().attributeExists("vehicle"));
	}

	@Test
	void testProcessCreationFormSuccess() throws Exception {
		mockMvc
			.perform(post("/owners/{ownerId}/vehicles/new", TEST_OWNER_ID).param("fuelType", "nuclear")
				.param("licensePlate", "ABCDE")
				.param("seats", "34")
				.param("color", "atomcolor")
				.param("brand", "alienbrand")
				.param("model", "sWAS"))
			.andExpect(status().is3xxRedirection())
			.andExpect(view().name("redirect:/owners/{ownerId}"));
	}

	@Nested
	class ProcessCreationFormHasErrors {

		@Test
		void testProcessCreationFormWithBlankBrand() throws Exception {
			mockMvc
				.perform(post("/owners/{ownerId}/vehicles/new", TEST_OWNER_ID).param("fuelType", "nuclear")
					.param("licensePlate", "ABCDE")
					.param("seats", "34")
					.param("color", "atomcolor")
					.param("brand", "\t \n")
					.param("model", "sWAS"))
				.andExpect(model().attributeHasNoErrors("owner"))
				.andExpect(model().attributeHasErrors("vehicle"))
				.andExpect(model().attributeHasFieldErrors("vehicle", "brand"))
				.andExpect(model().attributeHasFieldErrorCode("vehicle", "brand", "required"))
				.andExpect(status().isOk())
				.andExpect(view().name("vehicles/createOrUpdateVehicleForm"));
		}

		@Test
		void testProcessCreationFormWithMissingVehicleFuelType() throws Exception {
			mockMvc
				.perform(post("/owners/{ownerId}/vehicles/new", TEST_OWNER_ID).param("licensePlate", "ABCDE")
					.param("seats", "34")
					.param("color", "atomcolor")
					.param("brand", "alienbrand")
					.param("model", "sWAS"))
				.andExpect(model().attributeHasNoErrors("owner"))
				.andExpect(model().attributeHasErrors("vehicle"))
				.andExpect(model().attributeHasFieldErrors("vehicle", "fuelType"))
				.andExpect(model().attributeHasFieldErrorCode("vehicle", "fuelType", "required"))
				.andExpect(status().isOk())
				.andExpect(view().name("vehicles/createOrUpdateVehicleForm"));
		}

		@Test
		void testProcessCreationFormWithInvalidFuelType() throws Exception {
			mockMvc
				.perform(post("/owners/{ownerId}/vehicles/new", TEST_OWNER_ID).param("fuelType", "AIR")
					.param("licensePlate", "ABCDE")
					.param("seats", "34")
					.param("color", "atomcolor")
					.param("brand", "alienbrand")
					.param("model", "sWAS"))
				.andExpect(model().attributeHasNoErrors("owner"))
				.andExpect(model().attributeHasErrors("vehicle"))
				.andExpect(model().attributeHasFieldErrors("vehicle", "fuelType"))
				.andExpect(model().attributeHasFieldErrorCode("vehicle", "fuelType", "typeMismatch"))
				.andExpect(status().isOk())
				.andExpect(view().name("vehicles/createOrUpdateVehicleForm"));
		}

		@Test
		void testInitUpdateForm() throws Exception {
			mockMvc.perform(get("/owners/{ownerId}/vehicles/{vehicleId}/edit", TEST_OWNER_ID, TEST_VEHICLE_ID))
				.andExpect(status().isOk())
				.andExpect(model().attributeExists("vehicle"))
				.andExpect(view().name("vehicles/createOrUpdateVehicleForm"));
		}

	}

	@Test
	void testProcessUpdateFormSuccess() throws Exception {
		mockMvc
			.perform(post("/owners/{ownerId}/vehicles/{vehicleId}/edit", TEST_OWNER_ID, TEST_VEHICLE_ID)
				.param("fuelType", "nuclear")
				.param("licensePlate", "ABCDE")
				.param("seats", "34")
				.param("color", "atomcolor")
				.param("brand", "humanbrand")
				.param("model", "sWAS"))
			.andExpect(status().is3xxRedirection())
			.andExpect(view().name("redirect:/owners/{ownerId}"));
	}

	@Nested
	class ProcessUpdateFormHasErrors {

		@Test
		void testProcessUpdateFormWithInvalidFuelType() throws Exception {
			mockMvc
				.perform(post("/owners/{ownerId}/vehicles/{vehicleId}/edit", TEST_OWNER_ID, TEST_VEHICLE_ID)
					.param("fuelType", "AIR")
					.param("licensePlate", "ABCDE")
					.param("seats", "34")
					.param("color", "atomcolor")
					.param("brand", "alienbrand")
					.param("model", "sWAS"))
				.andExpect(model().attributeHasNoErrors("owner"))
				.andExpect(model().attributeHasErrors("vehicle"))
				.andExpect(model().attributeHasFieldErrors("vehicle", "fuelType"))
				.andExpect(model().attributeHasFieldErrorCode("vehicle", "fuelType", "typeMismatch"))
				.andExpect(view().name("vehicles/createOrUpdateVehicleForm"));
		}

		@Test
		void testProcessUpdateFormWithBlankBrand() throws Exception {
			mockMvc
				.perform(post("/owners/{ownerId}/vehicles/{vehicleId}/edit", TEST_OWNER_ID, TEST_VEHICLE_ID)
					.param("fuelType", "nuclear")
					.param("licensePlate", "ABCDE")
					.param("seats", "34")
					.param("color", "atomcolor")
					.param("brand", "     ")
					.param("model", "sWAS"))
				.andExpect(model().attributeHasNoErrors("owner"))
				.andExpect(model().attributeHasErrors("vehicle"))
				.andExpect(model().attributeHasFieldErrors("vehicle", "brand"))
				.andExpect(model().attributeHasFieldErrorCode("vehicle", "brand", "required"))
				.andExpect(view().name("vehicles/createOrUpdateVehicleForm"));
		}

	}

}
