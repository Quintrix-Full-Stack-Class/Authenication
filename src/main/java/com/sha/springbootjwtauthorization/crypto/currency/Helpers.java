package com.sha.springbootjwtauthorization.crypto.currency;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Helpers {


	public static List<Currency> allCurrencies() {
		String resourcesDirectoryPath = "./server/src/main/resources/";
//			File resourcesDirectoryFiles = new File(resourcesDirectoryPath);
//			System.out.println("directory.list() = " + Arrays.toString(resourcesDirectoryFiles.list()));
		// read the file
		File listOfCurrenciesFile = new File(resourcesDirectoryPath + "currencies.csv");
		List<Currency> currencyData = new ArrayList<>();
		try {
			Scanner scanner = new Scanner(listOfCurrenciesFile);
			while (scanner.hasNextLine()) {
				String line = scanner.nextLine();
				Pattern pattern = Pattern.compile("(\\w*),(\\w*)", Pattern.CASE_INSENSITIVE);
				Matcher matcher = pattern.matcher(line);
				if (matcher.find()) {

					Currency currency = new Currency(matcher.group(1), matcher.group(2));
//					currency.setId(matcher.group(1));
//					currency.setName(matcher.group(2));
					currencyData.add(currency);
				}
			}
		} catch (FileNotFoundException e) {
			throw new RuntimeException(e);
		}
		System.out.println("currencyData = " + currencyData);
		return currencyData;
	}
}
