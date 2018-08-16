package com.atcs.service;

import java.util.SortedSet;

import com.atcs.model.Aircraft;

public interface IAtcsService {
	
	boolean queueAircraft(Aircraft aircraft);
	boolean deQueueAircraft(String id);
	SortedSet<Aircraft> showAircrafts();
}
