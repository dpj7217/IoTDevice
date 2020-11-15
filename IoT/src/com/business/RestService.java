package com.business;

import java.util.concurrent.TimeUnit;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.data.Audio;

@RestController
public class RestService {
    
	/*
	 * Private Helper function to generate random audio and add it to db
	 * 
	 */
	private Audio AddAudio() throws ClassNotFoundException {
        double randDuration = Math.random() * (9.99 - 1.00) + 1.00;
        double randAmplitude = Math.random() * (99.99 - 10.00) + 10.00;
        double randFrequency = Math.random() * (99999999.99 - 10000000.00) + 10000000.00;

        Audio a = new Audio(randDuration, randAmplitude, randFrequency);

        a.insert();
        return a;
    }
    
	
	/*
	 * Request Mapped to /IoT/insert page for actually inserting into database
	 * 
	 */
	@GetMapping("/insert")
    public void insert() throws ClassNotFoundException {
		System.out.println("Init insert()");
        while(true) {
            Audio a = AddAudio();
            System.out.println("Inserted Audio:");
            
            System.out.println(a.toString());
            
            try {
                TimeUnit.SECONDS.sleep(5);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
	
	
	@RequestMapping(value="/test", method=RequestMethod.GET)
	public String test() {
		return "home";
	}
}
