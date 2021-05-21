package se.sme.service;

import java.util.List;
import javax.ejb.Stateless;
import javax.inject.Inject;

import se.sme.dao.IntervalDao;
import se.sme.domain.IntervalInstance;

@Stateless
public class IntervalManagementImplementation implements TimeManagementService {
    
	@Inject
	private IntervalDao dao;
	
	@Override
	public void registerInterval(IntervalInstance intervalInstance) {
			dao.insert(intervalInstance);
	}

	@Override
	public List<IntervalInstance> getAllIntervals() {
		return dao.findAll();
	}
	@Override
	public List<IntervalInstance> searchByStart(int hour) {
		return dao.findByStart(hour);
	}

	@Override
	public void delete(IntervalInstance intervalInstance) {
		dao.delete(intervalInstance);
		
	}

	@Override
	public void addHours(int hour, int id) {
		dao.addHours(hour, id);
		
	}

}
