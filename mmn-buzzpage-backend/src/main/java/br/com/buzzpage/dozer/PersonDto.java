package br.com.buzzpage.dozer;

import java.io.Serializable;

public class PersonDto implements Serializable {
	private static final long serialVersionUID = 1L;
	private String nameFull;
	private int ageThisYear;

	public String getNameFull() {
		return nameFull;
	}

	public void setNameFull(String nameFull) {
		this.nameFull = nameFull;
	}

	public int getAgeThisYear() {
		return ageThisYear;
	}

	public void setAgeThisYear(int ageThisYear) {
		this.ageThisYear = ageThisYear;
	}

	@Override
	public String toString() {
		return "PersonDto [nameFull=" + nameFull + ", ageThisYear=" + ageThisYear + "]";
	}
}