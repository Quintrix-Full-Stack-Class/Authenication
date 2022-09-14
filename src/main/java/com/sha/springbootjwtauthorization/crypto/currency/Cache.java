package com.sha.springbootjwtauthorization.crypto.currency;

import java.time.LocalDate;
import java.util.List;

public class Cache {
	private final String currency;
	private final List<com.sha.springbootjwtauthorization.crypto.currency.DailyValue> values;
	private final LocalDate updated;

	public Cache(String currency, LocalDate updated, List<com.sha.springbootjwtauthorization.crypto.currency.DailyValue> dailyValues) {
		this.currency = currency;
		this.values = dailyValues;
		this.updated = updated;
	}

	public String getCurrency() {
		return currency;
	}

	public List<com.sha.springbootjwtauthorization.crypto.currency.DailyValue> getValues() {
		return values;
	}

	public LocalDate getUpdated() {
		return updated;
	}
}
