package com.sha.springbootjwtauthorization.crypto.currency;


public class Currency {
	private final String id;
	private final String name;

	Currency(String id, String name) {
		this.id = id;
		this.name = name;
	}

	public String getId() {
		return id;
	}
}
