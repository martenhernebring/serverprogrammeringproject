package se.sme.service;

import java.util.List;

import javax.ejb.Remote;

import se.sme.domain.IntervalInstance;
@Remote 
public interface TimeManagementService {

	public void registerInterval(IntervalInstance intervalInstance);
	public List<IntervalInstance>getAllIntervals ();
	public List<IntervalInstance>searchByStart(int hour);
}
