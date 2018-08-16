package com.atcs.dao;

import java.util.SortedSet;

import com.atcs.model.Aircraft;

public interface IAtcsDao {
	
	boolean queueAircraft(Aircraft aircraft);
	boolean deQueueAircraft(String id);
	SortedSet<Aircraft> showAircrafts();

}
