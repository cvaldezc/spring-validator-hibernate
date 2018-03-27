package io.cvaldezchavez.form;

public enum Gender {
	MALE("M"), FEMALE("F");
	
	private final String gender;
	
	Gender(String gender) {
		this.gender = gender;
	}
	
	public String getChar() {
		return this.gender;
	}
	
}
