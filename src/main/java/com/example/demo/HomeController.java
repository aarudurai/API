package com.example.demo;

import java.text.DecimalFormat;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HomeController {
	
	private static DecimalFormat df2 = new DecimalFormat(".##");
	
	@RequestMapping(method = RequestMethod.POST, value="/transact")
    public ResponseEntity<?> sample(@RequestParam("timestamp") long timestamp,@RequestParam("amount") double amount) {
		System.out.println("double : " + df2.format(amount));
	
		/*DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
		Date date = new Date();
		System.out.println(dateFormat.format(date));*/
		long unixTime = System.currentTimeMillis();
		System.out.println(unixTime);
		if((timestamp-unixTime)<60000) {
			  return ResponseEntity.status(HttpStatus.CREATED).build();
		}
		return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
		
		
	}


}
