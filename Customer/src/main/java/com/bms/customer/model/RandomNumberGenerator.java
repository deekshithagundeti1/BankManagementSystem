package com.bms.customer.model;

import java.util.concurrent.ThreadLocalRandom;

/**
 * @author javacloudmc446
 *
 */
public class RandomNumberGenerator {
	
	public RandomNumberGenerator() { }
	
	public static long random() {
	    long smallest = 1000_0000_0000_0000L;
	    long biggest =  9999_9999_9999_9999L;
	    return ThreadLocalRandom.current().nextLong(smallest, biggest+1);
	}

}
