package se.sme.domain;

public class Interval {
//0-39 Hours from now
	private int startHour;
	private int endHour;

	public Interval(int startHour, int endHour){
		this.startHour=startHour;
		this.endHour=endHour;
	}

	public void setStartHour(int startHour) {
		this.startHour = startHour;
	}

	public void setEndHour(int endHour) {
		this.endHour = endHour;
	}

	public int getStartHour() {
		return startHour;
	}

	public int getEndHour() {
		return endHour;
	}

	@Override
	public String toString() {
		return "Interval [startHour=" + startHour + ", endHour=" + endHour + "]";
	}

}
