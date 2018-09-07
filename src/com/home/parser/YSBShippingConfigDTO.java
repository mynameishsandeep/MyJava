package com.home.parser;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@JsonIgnoreProperties(ignoreUnknown = true)
public class YSBShippingConfigDTO  {

	@JsonProperty("ShippingMethods")
	//TODO: Validation against Enums
	private List<String> shippingMethods;
	@JsonProperty("TaxShipUrl")
	private String webHookURL;

	@JsonProperty("Ship")
	private List<List<ShipRuleDTO>> shippingRules;

	@JsonProperty("ShipMethodCount")
	private int shipMethodCount;
	@JsonProperty("ShipRuleCount")
	private int shipRuleCount;
	@JsonProperty("IsSeparateTaxShip")
	private String isSeparateTaxShip;

}
