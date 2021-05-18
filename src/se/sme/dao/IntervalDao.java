package se.sme.dao;

import java.util.List;

import javax.ejb.Local;

import se.sme.domain.Interval;

@Local
public interface IntervalDao {
    public void insert(Interval newInterval);

    public List<Interval> findAll();

    public List<Interval> findByStart(int startHour);

}
