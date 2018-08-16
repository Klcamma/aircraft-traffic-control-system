package com.atcs.compare;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

import com.atcs.model.Aircraft;

public class AircraftComparator implements Comparator<Aircraft>{

	private List<Comparator<Aircraft>> listComparators;
	
	public AircraftComparator(){
		listComparators = new ArrayList<>();
		listComparators.add(new AircraftTypeComparator());
		listComparators.add(new AircraftSizeComparator());
	}

	public List<Comparator<Aircraft>> getListComparators() {
		return listComparators;
	}

	public void setListComparators(List<Comparator<Aircraft>> listComparators) {
		this.listComparators = listComparators;
	}

	@Override
	public int compare(Aircraft ac1, Aircraft ac2) {
		if(ac1.getId().equals(ac2.getId())) {
			return 0;
		}
		for (Comparator<Aircraft> comparator : listComparators) {
            int result = comparator.compare(ac1, ac2);
            if (result != 0) {
                return result;
            }
        }
		return +1;
	}
}
