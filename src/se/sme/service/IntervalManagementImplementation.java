package se.sme.service;

import java.util.ArrayList;
import java.util.List;
import javax.ejb.Stateless;
import javax.inject.Inject;

import se.sme.dao.IntervalDao;
import se.sme.domain.Interval;

@Stateless
public class IntervalManagementImplementation implements TimeManagementService {
	@SuppressWarnings("unused")
	@Inject
	private IntervalDao dao;
	@Override
	public void registerInterval(Interval interval) {

	}

	@Override
	public List<Interval> getAllIntervals() {
		List<Interval> list=new ArrayList<>();
        var i = new Interval(0, 1);
        list.add(i);
		return list;
	}
	@Override
	public List<Interval> searchByStart(int start) {
		return null;
	}

}
