package com.gazbert.patterns.behavioural.state;


/**
 * This is the initial state.
 * 
 * @author gazbert
 *
 */
public class CustomerSupportState implements BugState {

    /** Cost per hour for Customer Support work */
    private static final int HOURLY_RATE = 80;
    
    /** Reference to the state machine */
    private BugTrackerContext bugTracker;

    /** Internal state of this object - Cost of the bug */
    private int bugCost;
    
    /**
     * Constructor takes the state machine as an arg.
     * 
     * @param clockSetup
     */
    public CustomerSupportState(final BugTrackerContext bugTracker)
    {
	this.bugTracker = bugTracker;
	
	// init this object's internal state
	bugCost = 0;
    }
    
    public void updateHoursWorked(int hoursWorked) {
	
	bugCost += (hoursWorked * HOURLY_RATE);
    }
    
    public int getCost() {	
	
	return bugCost;	
    }

    @Override
    public void setNextState() {
	bugTracker.setState(bugTracker.getEngineeringState());	
    }
}