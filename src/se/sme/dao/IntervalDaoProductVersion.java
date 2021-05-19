package se.sme.dao;

import java.util.List;

import javax.ejb.Stateless;
import javax.enterprise.inject.Default;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import se.sme.domain.IntervalInstance;


@Default
@Stateless
public class IntervalDaoProductVersion implements IntervalDao {
	@PersistenceContext
	private EntityManager em;

    @Override
    public void insert(IntervalInstance newInterval) {
    	em.persist(newInterval);

    }

    @Override
    public List<IntervalInstance> findAll() {
    	Query q = em.createQuery("select intervalinstance from IntervalInstance intervalinstance");
    	@SuppressWarnings("unchecked")
		List<IntervalInstance> intervalInstances = q.getResultList();
    	return intervalInstances;

    }

    @SuppressWarnings("unchecked")
    @Override
    public List<IntervalInstance> findByStart(int hour) {
    	Query q = em.createQuery("select starthour from IntervalInstance intervalinstance where intervalinstance.starthour= :start", IntervalInstance.class );
    	q.setParameter("start", hour);
    	return q.getResultList();

    }

}
