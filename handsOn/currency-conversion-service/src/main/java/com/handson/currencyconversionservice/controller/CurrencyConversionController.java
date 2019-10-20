package com.handson.currencyconversionservice.controller;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.handson.currencyconversionservice.entity.CurrencyConversionBean;
import com.handson.currencyconversionservice.proxy.CurrencyExchangeServiceProxy;

@RestController
public class CurrencyConversionController {

	private Logger logger = LoggerFactory.getLogger(this.getClass());

	@Autowired
	private CurrencyExchangeServiceProxy proxy;

	@GetMapping("/currency-converter/from/{from}/to/{to}/quantity/{quantity}")
	public CurrencyConversionBean convertCurrency(@PathVariable String from, @PathVariable String to,
			@PathVariable BigDecimal quantity) {
		Map<String, String> uriVariables = new HashMap<String, String>();
		uriVariables.put("from", from);
		uriVariables.put("to", to);
		ResponseEntity<CurrencyConversionBean> reponseEntity = new RestTemplate().getForEntity(
				"http://localhost:8000/currency-exchange/from/{from}/to/{to}", CurrencyConversionBean.class,
				uriVariables);
		CurrencyConversionBean responseFromCE = reponseEntity.getBody();
		return new CurrencyConversionBean(responseFromCE.getId(), from, to, responseFromCE.getConversionMultiple(),
				quantity, quantity.multiply(responseFromCE.getConversionMultiple()), responseFromCE.getPortNo());
	}

	@GetMapping("/currency-converter-feign/from/{from}/to/{to}/quantity/{quantity}")
	public CurrencyConversionBean convertCurrencyFeign(@PathVariable String from, @PathVariable String to,
			@PathVariable BigDecimal quantity) {

		CurrencyConversionBean responseFromCE = proxy.retrieveExchangeValue(from, to);
		CurrencyConversionBean response = new CurrencyConversionBean(responseFromCE.getId(), from, to,
				responseFromCE.getConversionMultiple(), quantity,
				quantity.multiply(responseFromCE.getConversionMultiple()), responseFromCE.getPortNo());
		logger.info("{}", response);
		return response;
	}

	@GetMapping("/currency-converter-list")
	public List<CurrencyConversionBean> convertCurrencyList() {

		List<CurrencyConversionBean> responseFromCE = proxy.exchangeRates();
//		CurrencyConversionBean response = new CurrencyConversionBean(responseFromCE.getId(), from, to, responseFromCE.getConversionMultiple(), quantity,quantity.multiply(responseFromCE.getConversionMultiple()),responseFromCE.getPortNo());
		return responseFromCE;
	}

}
