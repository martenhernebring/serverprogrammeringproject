package se.sme.dao;

import java.util.List;

import javax.ejb.Local;

import se.sme.domain.IntervalInstance;

@Local
public interface IntervalDao {
    public void insert(IntervalInstance newInterval);

    public List<IntervalInstance> findAll();

    public List<IntervalInstance> findByStart(int hour);

	public void delete(IntervalInstance intervalInstance);

}
