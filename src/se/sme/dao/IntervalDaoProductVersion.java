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
    	Query q = em.createQuery("select intervalinstance from IntervalInstance intervalinstance where intervalinstance.starthour= :start", IntervalInstance.class );
    	q.setParameter("start", hour);
    	return q.getResultList();
    }

	@Override
	public void delete(IntervalInstance intervalInstance) {
	        if (!em.contains(intervalInstance)) {
	            intervalInstance = em.merge(intervalInstance);
	        }
	        em.remove(intervalInstance);
	}

	@Override
	public void addHours(int hour, int id) {
		Query q = em.createQuery("select intervalinstance from IntervalInstance intervalinstance where intervalinstance.id= :id", IntervalInstance.class);
		q.setParameter("id", id);
		@SuppressWarnings("unchecked")
        List<IntervalInstance> li = q.getResultList();
		if(li == null) {
		    throw new IllegalArgumentException("Id not saved in database");
		}
		System.out.println(li);
		li.get(0).add(hour);
	}

}
