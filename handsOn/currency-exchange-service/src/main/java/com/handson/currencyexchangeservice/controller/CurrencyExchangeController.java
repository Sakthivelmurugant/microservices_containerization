package com.handson.currencyexchangeservice.controller;

import java.math.BigDecimal;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.handson.currencyexchangeservice.entity.ExchangeValue;
import com.handson.currencyexchangeservice.repository.ExchangeValueRepository;

@RestController
public class CurrencyExchangeController {
	
	@Autowired
	private Environment environment;
	
	@Autowired
	private ExchangeValueRepository repository;
	
	private Logger logger = LoggerFactory.getLogger(this.getClass());
	
	@GetMapping("/currency-exchange/from/{from}/to/{to}")
	public ExchangeValue retrieveExchangeValue(@PathVariable("from") String from, @PathVariable("to") String to) {
//		ExchangeValue exc = new ExchangeValue(1000L, from, to	, BigDecimal.valueOf(75));
		ExchangeValue exc = repository.findByFromAndTo(from, to);
		exc.setPortNo(Integer.parseInt(environment.getProperty("local.server.port")));
		logger.info("{}", exc);
		return exc;
	}
	
	@GetMapping("/exchangeRates")
	public List<ExchangeValue> exchangeRates() {
		return repository.findAll();
	}

}
