package se.sme.dao;

import java.util.List;

import javax.ejb.Local;

import se.sme.domain.IntervalInstance;

/** Interface for working with IntervalInstance in a database. 
 * @author: Suzana Trajcevska, Mårten Hernebring*/
@Local
public interface IntervalDao {
    /** Adds a new IntervalInstance to the database.
     * @param newInterval IntervalInstance to be created.*/
    public void insert(IntervalInstance newInterval);

    /** Query to get all IntervalInstances from the database.
     * @return List<IntervalInstance> containing all in database.*/
    public List<IntervalInstance> findAll();

    /** Query to get all IntervalInstances from the database.
     * @param hour Which starthour we will use for returning the List.
     * @return List<IntervalInstance> containing that starthour in database.*/
    public List<IntervalInstance> findByStart(int hour);

    /** Removes an IntervalInstance from the database.
     * @param newInterval IntervalInstance to be deleted.*/
	public void delete(IntervalInstance intervalInstance);
	
	/** Adds hours to a specific IntervalInstance in the database.
     * @param hour Hours to be added to start- and endhour
     * @param id Unit to be updated
     * */
	public void addHours(int hour, int id);

}
