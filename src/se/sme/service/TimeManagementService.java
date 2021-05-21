package se.sme.service;

import java.util.List;

import javax.ejb.Local;


import se.sme.domain.IntervalInstance;
@Local 
public interface TimeManagementService {

	public void registerInterval(IntervalInstance intervalInstance);
	public List<IntervalInstance>getAllIntervals ();
	public List<IntervalInstance>searchByStart(int hour);
	public void delete(IntervalInstance intervalInstance);
}
