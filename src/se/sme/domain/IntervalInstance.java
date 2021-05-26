package se.sme.domain;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 * A model that describes time intervals using a booking system.
 * 
 * @author Erik Blidner
 */
@Entity
@SuppressWarnings("serial")
public class IntervalInstance implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    // 0-39 Hours from now
    private int starthour;
    private int endhour;

    /** Required by JPA */
    public IntervalInstance() {
    }

    /**
     * Creating a new interval.
     * 
     * @param startHour The hour when the interval starts. Must be positive and less than end hour.
     * @param endHour   The hour when the interval ends. Must be positive and more than start hour.
     */
    public IntervalInstance(int startHour, int endHour) {
        if (endHour <= startHour || startHour < 0) {
            throw new IllegalArgumentException("endHour must be bigger than startHour and both have to be positive.");
        }
        this.starthour = startHour;
        this.endhour = endHour;
    }

    /**
     * Simple set method required by jax-rs
     * 
     * @param startHour The hour when the interval starts
     */
    public void setStartHour(int startHour) {
        this.starthour = startHour;
    }

    /**
     * Simple set method required by jax-rs
     * 
     * @param endHour The hour when the interval ends
     */
    public void setEndHour(int endHour) {
        this.endhour = endHour;
    }

    /**
     * Adds additional hours needed to the interval
     * 
     * @param hour Additional hours to be added to start and minus. Must be positive.
     */
    public void add(int hour) {
        if ((long) (endhour + hour) > Integer.MAX_VALUE || hour < 0) {
            throw new IllegalArgumentException("You have tresspassed the booking limit: " + Integer.MAX_VALUE);
        }
        endhour += hour;
        starthour += hour;

    }

    /**
     * Simple get method required by JPA
     * 
     * @return startHour The hour when the interval starts
     */
    public int getStartHour() {
        return starthour;
    }

    /**
     * Simple get method required by JPA
     * 
     * @return endHour The hour when the interval ends
     */
    public int getEndHour() {
        return endhour;
    }

    /**
     * A simple in Eclipse auto generated toString method.
     * 
     * @return auto generated String with start and end hours.
     */
    @Override
    public String toString() {
        return "IntervalInstance [startHour=" + starthour + ", endHour=" + endhour + "]";
    }

}
