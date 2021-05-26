package se.sme.dao;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.Stateless;
import javax.enterprise.inject.Alternative;
import se.sme.domain.IntervalInstance;

/**
 * Alternative (testing) version for working with IntervalInstance in a
 * database.
 * 
 * @author Suzana Trajcevska
 * @author Mårten Hernebring
 */
@Stateless
@Alternative
public class IntervalDaoTestingVersion implements IntervalDao {

    /**
     * An empty method not used required by interface.
     * 
     * @param newInterval Not used.
     */
    @Override
    public void insert(IntervalInstance newInterval) {
    }

    /**
     * Simulating a Query that gets all IntervalInstances from the database.
     * 
     * @return List containing all in database.
     */
    @Override
    public List<IntervalInstance> findAll() {
        List<IntervalInstance> list = new ArrayList<>();
        IntervalInstance i1 = new IntervalInstance(0, 1);
        IntervalInstance i2 = new IntervalInstance(20, 25);
        IntervalInstance i3 = new IntervalInstance(35, 39);
        list.add(i1);
        list.add(i2);
        list.add(i3);
        return list;

    }

    /**
     * An empty method that just return null because not used required by interface.
     * 
     * @param startHour Not used.
     * @return null.
     */
    @Override
    public List<IntervalInstance> findByStart(int startHour) {
        return null;
    }

    /**
     * An empty method not used required by interface.
     * 
     * @param intervalInstance Not implemented.
     */
    @Override
    public void delete(IntervalInstance intervalInstance) {
    }

    /**
     * An empty method not used required by interface.
     * 
     * @param hour Not implemented.
     * @param id   Not implemented.
     */
    @Override
    public void addHours(int hour, int id) {
    }

}
