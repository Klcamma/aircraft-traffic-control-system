package com.atcs.compare;

import java.util.Comparator;

import com.atcs.model.Aircraft;

public class AircraftTypeComparator implements Comparator<Aircraft> {

	@Override
	public int compare(Aircraft ac1, Aircraft ac2) {
		return ac1.getType().getPriority() < ac2.getType().getPriority() ? +1
				: ac1.getType().getPriority() > ac2.getType().getPriority() ? -1 : 0;
	}

}
