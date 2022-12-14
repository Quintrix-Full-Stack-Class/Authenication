package com.sha.springbootjwtauthorization.crypto.user;

import com.sha.springbootjwtauthorization.crypto.currency.Currency;
import com.sha.springbootjwtauthorization.crypto.currency.Helpers;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;

import java.util.List;

@Controller
public class UserController {
	//	@SchemaMapping(typeName = "Query", value = "firstQuery")

	private final UserRepository userRepository;
	private final List<Currency> allCurrencies = Helpers.allCurrencies();

	public UserController(UserRepository userRepository) {
		this.userRepository = userRepository;
	}

	@QueryMapping
	public Iterable<CryptoUser> cryptoAllUsers() {
		Iterable<CryptoUser> users = userRepository.findAll();
//		users.forEach(user -> System.outuser.getUserEmail());
		return users;

	}

	@QueryMapping
	public CryptoUser cryptoFindUser(@Argument String userId) {
		return userRepository.findById(userId).orElseThrow(() -> new IllegalArgumentException("User not found"));
//		CryptoUser foundUser = userRepository.findById(userId).get();
//		return foundUser;
	}

	@MutationMapping
	public String cryptoAddUser(@Argument String user, @Argument List<String> currencies) {
		// save or update the current user
		List<String> currenciesMatched = allCurrencies.stream().map(Currency::getId)
		                                              .filter(
				                                              id -> currencies.stream().filter(id::equals).count() == 1)
		                                              .toList();
		CryptoUser newUser = new CryptoUser(user, currenciesMatched);
		userRepository.save(newUser);

		return "added User: " + user + " Currencies: " + currenciesMatched;
	}
}
