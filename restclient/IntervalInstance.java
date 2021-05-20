
import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
@SuppressWarnings("serial")
public class IntervalInstance implements Serializable {
	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
	
	//0-39 Hours from now
	private int starthour;
	private int endhour;

	public IntervalInstance() {
		//requered by JPA
	}
	public IntervalInstance(int startHour, int endHour){
		this.starthour=startHour;
		this.endhour=endHour;
	}

	public void setStartHour(int startHour) {
		this.starthour = startHour;
	}

	public void setEndHour(int endHour) {
		this.endhour = endHour;
	}

	public int getStartHour() {
		return starthour;
	}

	public int getEndHour() {
		return endhour;
	}

	@Override
	public String toString() {
		return "IntervalInstance [startHour=" + starthour + ", endHour=" + endhour + "]";
	}

}
