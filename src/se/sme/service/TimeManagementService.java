package se.sme.service;

import java.util.List;

import javax.ejb.Remote;

import se.sme.domain.Interval;
@Remote 
public interface TimeManagementService {

	public void registerInterval(Interval interval);
	public List<Interval>getAllIntervals ();
	public List<Interval>searchByStart(int start);
}
