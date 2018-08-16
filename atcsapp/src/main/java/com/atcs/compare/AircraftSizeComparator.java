package com.atcs.compare;

import java.util.Comparator;

import com.atcs.model.Aircraft;

public class AircraftSizeComparator implements Comparator<Aircraft>{

	@Override
	public int compare(Aircraft ac1, Aircraft ac2) {
		return ac1.getSize().getPriority() < ac2.getSize().getPriority() ? +1
				: ac1.getSize().getPriority() > ac2.getSize().getPriority() ? -1 : 0;
	}

}
