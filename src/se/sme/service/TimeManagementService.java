package se.sme.service;

import java.util.List;
import se.sme.domain.Interval;

public interface TimeManagementService {

	public void registerInterval(Interval interval);
	public List<Interval>getAllIntervals ();
	public List<Interval>searchByStart(int start);
}
