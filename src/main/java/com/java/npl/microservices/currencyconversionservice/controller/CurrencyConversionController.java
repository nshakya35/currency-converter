package com.java.npl.microservices.currencyconversionservice.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.fasterxml.jackson.databind.JsonNode;
import com.java.npl.microservices.currencyconversionservice.model.CurrencyConversionModel;
import com.java.npl.microservices.currencyconversionservice.model.SellExchangeModel;

@RestController
public class CurrencyConversionController {

	@GetMapping("/currency-converter/{code}/{date}")
	public SellExchangeModel getSellExchangeRate(@PathVariable String code, @PathVariable String date) {
		Map<String, String> uriVariables = new HashMap<>();
		uriVariables.put("code", code);
		uriVariables.put("date", date);
		ResponseEntity<CurrencyConversionModel> entity = new RestTemplate().getForEntity(
				"http://api.nbp.pl/api/exchangerates/rates/c/{code}/{date}", CurrencyConversionModel.class,
				uriVariables);

		CurrencyConversionModel response = entity.getBody();

		JsonNode ratesEntry = response.getRates().get(0);
		String effectiveDate = ratesEntry.get("effectiveDate").asText();
		String bid = ratesEntry.get("bid").toString();

		return new SellExchangeModel(bid, effectiveDate);
	}

	@GetMapping("/currency-converter/total-cost")
	public float getTotalPurchasingCost(@RequestBody List<String> currencyList) {
		float totalPurchaseCost = 0;
		for (String currency : currencyList) {
			totalPurchaseCost += getExchangeRate(currency);
		}
		return totalPurchaseCost;
	}

	/**
	 * @param currencyCode
	 * @return exchange rate the URL based on the provided currency code
	 */
	private float getExchangeRate(String currencyCode) {
		ResponseEntity<CurrencyConversionModel> entity = new RestTemplate().getForEntity(
				"http://api.nbp.pl/api/exchangerates/rates/a/" + currencyCode, CurrencyConversionModel.class);
		CurrencyConversionModel response = entity.getBody();

		JsonNode ratesEntry = response.getRates().get(0);
		String exchangeRate = ratesEntry.get("mid").toString();
		float rate = Float.parseFloat(exchangeRate);
		return rate;

	}
}
