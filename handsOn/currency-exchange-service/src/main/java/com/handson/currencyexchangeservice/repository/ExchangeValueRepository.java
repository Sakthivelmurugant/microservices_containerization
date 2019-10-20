package com.handson.currencyexchangeservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.handson.currencyexchangeservice.entity.ExchangeValue;

public interface ExchangeValueRepository extends JpaRepository<ExchangeValue, Long> {
	ExchangeValue findByFromAndTo(String from, String to);

}
