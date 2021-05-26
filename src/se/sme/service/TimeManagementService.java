package se.sme.service;

import java.util.List;
import javax.ejb.Local;
import se.sme.domain.IntervalInstance;

/**
 * An service interface that probably connects rest client and jpa
 * 
 * @author Suzana Trajcevska
 * @author Mårten Hernebring
 */
@Local
public interface TimeManagementService {
    /**
     * Service method for registering intervals
     * 
     * @param intervalInstance Period to be added.
     */
    public void registerInterval(IntervalInstance intervalInstance);

    /**
     * Service method for getting all intervals from storage
     * 
     * @return List presently saved list
     */
    public List<IntervalInstance> getAllIntervals();

    /**
     * Service method for searching intervals by start hour.
     * 
     * @param hour Start hour that every interval in the list must match.
     * @return List presently matching list
     */
    public List<IntervalInstance> searchByStart(int hour);

    /**
     * Service method for deleting intervals
     * 
     * @param intervalInstance Period to be deleted.
     */
    public void delete(IntervalInstance intervalInstance);

    /**
     * Service method for adding additional hours to intervals
     * 
     * @param hour Hours to be added to the interval.
     * @param id   Specific interval to be modified
     */
    public void addHours(int hour, int id);
}
