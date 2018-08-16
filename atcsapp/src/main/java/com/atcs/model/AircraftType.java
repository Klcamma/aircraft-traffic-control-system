package com.atcs.model;

public enum AircraftType {
	Emergency("Emergency",4), VIP("VIP",3), Passenger("Passenger",2), Cargo("Cargo",1);

    private final String type;
    private final int priority;

    AircraftType(String type, int priority) {
    	this.type = type;
        this.priority = priority;
    }
    
    public int getPriority() {
        return priority;
    }
    
    public String getType() {
    	return type;
    }
	
}