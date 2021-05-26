package se.sme.service;

import java.util.List;
import javax.ejb.Stateless;
import javax.inject.Inject;

import se.sme.dao.IntervalDao;
import se.sme.domain.IntervalInstance;

/**
 * An service implementation that probably connects rest client and jpa
 * 
 * @author Suzana Trajcevska
 * @author Mårten Hernebring
 */
@Stateless
public class IntervalManagementImplementation implements TimeManagementService {

    @Inject
    private IntervalDao dao;

    /**
     * Service method for registering intervals
     * 
     * @param intervalInstance Period to be added.
     */
    @Override
    public void registerInterval(IntervalInstance intervalInstance) {
        dao.insert(intervalInstance);
    }

    /**
     * Service method for getting all intervals from JPA
     * 
     * @return List presently saved list
     */
    @Override
    public List<IntervalInstance> getAllIntervals() {
        return dao.findAll();
    }

    /**
     * Service method for searching intervals by start hour.
     * 
     * @param hour Start hour that every interval in the list must match.
     * @return List presently matching list
     */
    @Override
    public List<IntervalInstance> searchByStart(int hour) {
        return dao.findByStart(hour);
    }

    /**
     * Service method for deleting intervals in JPA
     * 
     * @param intervalInstance Period to be deleted.
     */
    @Override
    public void delete(IntervalInstance intervalInstance) {
        dao.delete(intervalInstance);

    }

    /**
     * Service method for adding additional hours to intervals
     * 
     * @param hour Hours to be added to the interval.
     * @param id   Specific interval to be modified
     */
    @Override
    public void addHours(int hour, int id) {
        dao.addHours(hour, id);

    }

}
