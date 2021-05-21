package se.sme.dao;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.Stateless;
import javax.enterprise.inject.Alternative;
import se.sme.domain.IntervalInstance;

@Stateless
@Alternative
public class IntervalDaoTestingVersion implements IntervalDao {

    @Override
    public void insert(IntervalInstance newInterval) {

    }

    @Override
    public List<IntervalInstance> findAll() {
        List<IntervalInstance> list = new ArrayList<>();
        IntervalInstance i1 = new IntervalInstance(0, 1);
        IntervalInstance i2 = new IntervalInstance(20, 25);
        IntervalInstance i3 = new IntervalInstance(35,39);
        list.add(i1);
        list.add(i2);
        list.add(i3);
        return list;

    }

    @Override
    public List<IntervalInstance> findByStart(int startHour) {
        return null;
    }

	@Override
	public void delete(IntervalInstance intervalInstance) {
	
		
	}

	@Override
	public void addHours(int hour, int id) {
		
	}

}
