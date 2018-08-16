package com.atcs.service;

import java.util.SortedSet;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.atcs.model.Aircraft;

@Service
public class AtcsService implements IAtcsService {

	@Autowired
	com.atcs.dao.IAtcsDao iatcsDao;
	
	@Override
	public boolean queueAircraft(Aircraft aircraft) {
		return iatcsDao.queueAircraft(aircraft);
	}

	@Override
	public boolean deQueueAircraft(String id) {
		return iatcsDao.deQueueAircraft(id);
	}

	@Override
	public SortedSet<Aircraft> showAircrafts() {
		return iatcsDao.showAircrafts();
	}

}
