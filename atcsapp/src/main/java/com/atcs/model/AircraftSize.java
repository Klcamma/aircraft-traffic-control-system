package com.atcs.model;

public enum AircraftSize {
	Small("Small",1),Large("Large",2);
	
    private final String size;
    private final int priority;
    
	AircraftSize(String size, int priority){
		this.size = size;
		this.priority = priority;
	}
	
    public int getPriority() {
        return priority;
    }
    
    public String getSize() {
    	return size;
    }
}
