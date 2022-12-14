package com.sha.springbootjwtauthorization.crypto.currency;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
//@Document(collection = "cryptocurrency")
public class CryptCurrency {
	private String code;
	private String name;
}
