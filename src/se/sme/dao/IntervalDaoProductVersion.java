package se.sme.dao;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.Stateless;
import javax.enterprise.inject.Default;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import se.sme.domain.Interval;


@Default
@Stateless
public class IntervalDaoProductVersion implements IntervalDao {
	@PersistenceContext
	private EntityManager em;

    @Override
    public void insert(Interval newInterval) {

    }

    @Override
    public List<Interval> findAll() {
    	TypedQuery<Interval> q = em.createQuery("select employee from Employee employee", Interval.class);
    	List<Interval> intervals = q.getResultList();
    	return intervals;

//        List<Interval> list = new ArrayList<>();
//        var i1 = new Interval(0, 1);
//        var i2 = new Interval(20, 25);
//        list.add(i1);
//        list.add(i2);
//        return list;

    }

    @Override
    public List<Interval> findByStart(int startHour) {
        return null;
    }

}
