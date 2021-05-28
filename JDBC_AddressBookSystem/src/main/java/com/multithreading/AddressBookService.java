package com.multithreading;

import java.sql.SQLException;
import java.time.Duration;
import java.time.Instant;
import java.util.Arrays;

public class AddressBookService {
	
	public static void main(String[] args) throws SQLException {
		AddressBookData[] data = {
				new AddressBookData("Mark","James","WestVilla","Kentucky","NewStates","610034","9672456102","mark123@gmail.com","2020-04-21"),
				new AddressBookData("Stock","Holmes","CrossHill","Missouri","Texas","420034","9011456102","stockHolmes@gmail.com","2020-05-11"),
				new AddressBookData("Katty","Cooper","OxfordRoad","Vegas","LasVegas","74234","870156102","katty63@outlook.com","2020-05-25")
		};
		
		AddressBookRepo repo = new AddressBookRepo();	
		Instant start = Instant.now();
		
		Arrays.stream(data).forEach(value -> {
			Runnable task = () ->{
				try {
					repo.insertMultipleRecord(value);
				} catch (SQLException e) {
					e.printStackTrace();
				}
			};
		});
		Instant end = Instant.now();
		System.out.println("Duration with thread:" +Duration.between(start, end));
	}

}
