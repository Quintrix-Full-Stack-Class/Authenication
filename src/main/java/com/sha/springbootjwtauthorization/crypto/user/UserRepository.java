package com.sha.springbootjwtauthorization.crypto.user;

import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository<CryptoUser, String> {
//		public static CryptoUser findByUserEmail(String userEmail) {
//
//		}
}
