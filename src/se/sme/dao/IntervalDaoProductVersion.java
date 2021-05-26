package se.sme.dao;

import java.util.List;

import javax.ejb.Stateless;
import javax.enterprise.inject.Default;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import se.sme.domain.IntervalInstance;

/**
 * Default (product) version for working with IntervalInstance in a database
 * using JPA.
 * 
 * @author Suzana Trajcevska
 * @author Mårten Hernebring
 */
@Default
@Stateless
public class IntervalDaoProductVersion implements IntervalDao {

    @PersistenceContext
    private EntityManager em;

    /**
     * Adds a new IntervalInstance to the database using JPA.
     * 
     * @param newInterval IntervalInstance to be created.
     */
    @Override
    public void insert(IntervalInstance newInterval) {
        em.persist(newInterval);
    }

    /**
     * Query to get all IntervalInstances from the database using JPA.
     * 
     * @return A List containing all in database.
     */
    @Override
    public List<IntervalInstance> findAll() {
        Query q = em.createQuery("select intervalinstance from IntervalInstance intervalinstance");
        @SuppressWarnings("unchecked")
        List<IntervalInstance> intervalInstances = q.getResultList();
        return intervalInstances;

    }

    /**
     * Query to get all IntervalInstances from the database using JPA.
     * 
     * @param hour Which starthour we will use for returning the List.
     * @return A List containing that starthour in database.
     */
    @SuppressWarnings("unchecked")
    @Override
    public List<IntervalInstance> findByStart(int hour) {
        Query q = em.createQuery(
                "select intervalinstance from IntervalInstance intervalinstance where intervalinstance.starthour= :start",
                IntervalInstance.class);
        q.setParameter("start", hour);
        return q.getResultList();
    }

    /**
     * Removes an IntervalInstance from the database using JPA.
     * 
     * @param intervalInstance IntervalInstance to be deleted.
     */
    @Override
    public void delete(IntervalInstance intervalInstance) {
        if (!em.contains(intervalInstance)) {
            intervalInstance = em.merge(intervalInstance);
        }
        em.remove(intervalInstance);
    }

    /**
     * Adds hours to a specific IntervalInstance in the database using JPA.
     * 
     * @param hour Hours to be added to start- and endhour.
     * @param id   Unit to be updated.
     */
    @Override
    public void addHours(int hour, int id) {
        Query q = em.createQuery(
                "select intervalinstance from IntervalInstance intervalinstance where intervalinstance.id= :id",
                IntervalInstance.class);
        q.setParameter("id", id);
        @SuppressWarnings("unchecked")
        List<IntervalInstance> li = q.getResultList();
        if (li == null) {
            throw new IllegalArgumentException("Id not saved in database");
        }
        System.out.println(li);
        li.get(0).add(hour);
    }

}
