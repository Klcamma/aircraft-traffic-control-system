package com.atcs.model;

public class Aircraft {

	private String Id;

	private AircraftType type;

	private AircraftSize size;

	public String getId() {
		return Id;
	}

	public void setId(String id) {
		Id = id;
	}

	public AircraftType getType() {
		return type;
	}

	public void setType(AircraftType type) {
		this.type = type;
	}

	public AircraftSize getSize() {
		return size;
	}

	public void setSize(AircraftSize size) {
		this.size = size;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		Aircraft other = (Aircraft) obj;
		if (other.getId().equals(this.Id)) {
			return true;
		}
		return false;
	}
}
