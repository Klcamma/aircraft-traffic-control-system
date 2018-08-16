package com.atcs.dao;

import java.util.SortedSet;
import java.util.TreeSet;

import org.springframework.stereotype.Repository;

import com.atcs.compare.AircraftComparator;
import com.atcs.model.Aircraft;

@Repository
public class AtcsDao implements IAtcsDao {

	private SortedSet<Aircraft> airCraftSortedSet = new TreeSet<>(new AircraftComparator());

	@Override
	public boolean queueAircraft(Aircraft aircraft) {
		synchronized (airCraftSortedSet) {
			return airCraftSortedSet.add(aircraft);
		}
	}

	@Override
	public boolean deQueueAircraft(String id) {
		boolean isDequeued = false;
		synchronized (airCraftSortedSet) {
			for (Aircraft aircraft : airCraftSortedSet) {
				if (aircraft.getId().equals(id)) {
					return airCraftSortedSet.remove(aircraft);
				}
			}
		}
		return isDequeued;
	}

	@Override
	public SortedSet<Aircraft> showAircrafts() {
		synchronized (airCraftSortedSet) {
			return airCraftSortedSet;
		}
	}
}
