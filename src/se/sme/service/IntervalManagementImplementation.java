package se.sme.service;

import java.util.List;
import javax.ejb.Stateless;
import javax.inject.Inject;

import se.sme.dao.IntervalDao;
import se.sme.domain.Interval;

@Stateless
public class IntervalManagementImplementation implements TimeManagementService {
    
	@Inject
	private IntervalDao dao;
	
	@Override
	public void registerInterval(Interval interval) {

	}

	@Override
	public List<Interval> getAllIntervals() {
		return dao.findAll();
	}
	@Override
	public List<Interval> searchByStart(int start) {
		return null;
	}

}
