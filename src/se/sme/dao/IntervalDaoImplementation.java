package se.sme.dao;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.Stateless;

import se.sme.domain.Interval;

@Stateless
public class IntervalDaoImplementation implements IntervalDao {

    @Override
    public void insert(Interval newInterval) {

    }

    @Override
    public List<Interval> findAll() {
        List<Interval> list = new ArrayList<>();
        var i1 = new Interval(0, 1);
        var i2 = new Interval(20, 25);
        list.add(i1);
        list.add(i2);
        return list;

    }

    @Override
    public List<Interval> findByStart(int startHour) {
        return null;
    }

}
