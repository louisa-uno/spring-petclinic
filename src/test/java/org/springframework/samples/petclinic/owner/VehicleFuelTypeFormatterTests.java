/*
 * Copyright 2012-2019 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      https://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package org.springframework.samples.petclinic.owner;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.BDDMockito.given;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Locale;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.condition.DisabledInNativeImage;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
@DisabledInNativeImage
class VehicleFuelTypeFormatterTests {

	@Mock
	private OwnerRepository vehicles;

	private VehicleFuelTypeFormatter vehicleFuelTypeFormatter;

	@BeforeEach
	void setup() {
		this.vehicleFuelTypeFormatter = new VehicleFuelTypeFormatter(vehicles);
	}

	@Test
	void testPrint() {
		VehicleFuelType vehicleFuelType = new VehicleFuelType();
		vehicleFuelType.setName("nuclear");
		String vehicleFuelTypeName = this.vehicleFuelTypeFormatter.print(vehicleFuelType, Locale.ENGLISH);
		assertThat(vehicleFuelTypeName).isEqualTo("nuclear");
	}

	@Test
	void shouldParse() throws ParseException {
		given(this.vehicles.findVehicleFuelTypes()).willReturn(makeVehicleFuelTypes());
		VehicleFuelType vehicleFuelType = vehicleFuelTypeFormatter.parse("petrol", Locale.ENGLISH);
		assertThat(vehicleFuelType.getName()).isEqualTo("petrol");
	}

	@Test
	void shouldThrowParseException() {
		given(this.vehicles.findVehicleFuelTypes()).willReturn(makeVehicleFuelTypes());
		Assertions.assertThrows(ParseException.class, () -> {
			vehicleFuelTypeFormatter.parse("AIR", Locale.ENGLISH);
		});
	}

	/**
	 * Helper method to produce some sample vehicle fuelTypes just for test purpose
	 * @return {@link Collection} of {@link VehicleFuelType}
	 */
	private List<VehicleFuelType> makeVehicleFuelTypes() {
		List<VehicleFuelType> vehicleFuelTypes = new ArrayList<>();
		vehicleFuelTypes.add(new VehicleFuelType() {
			{
				setName("nuclear");
			}
		});
		vehicleFuelTypes.add(new VehicleFuelType() {
			{
				setName("petrol");
			}
		});
		return vehicleFuelTypes;
	}

}
