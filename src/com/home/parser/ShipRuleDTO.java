package com.home.parser;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Getter;
import lombok.Setter;

@JsonIgnoreProperties(ignoreUnknown = true)
@Getter
@Setter
public class ShipRuleDTO {
	private String location;

	@JsonProperty("CA_Provinces")
	private List<String> canadaProvinces;
	@JsonProperty("CA_Province")
	private String canadaProvince;
	@JsonProperty("CA_Zip")
	private String CanadaZip;

	// Empty Shipping Method is ANY
	@JsonProperty("Method")
	private String shippingMethod;
	@JsonProperty("Zip")
	private String zip;

	@JsonProperty("Specific")
	private String specific;
	@JsonProperty("US_Zip")
	private String usZip;
	//same as specific
	@JsonProperty("CountryMode")
	private String countryMode;
	@JsonProperty("Countries")
	private List<String> country;
	@JsonProperty("US_States")
	private List<String> usState;
	@JsonProperty("State")
	private String state;

}
