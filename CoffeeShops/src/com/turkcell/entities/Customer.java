package com.turkcell.entities;

import java.time.LocalDate;

public class Customer {
	private String identityNumber;
	private String name;
	private String surname;
	private LocalDate dateOfBirth;

	public String getIdentityNumber() {
		return identityNumber;
	}

	public void setIdentityNumber(String identityNumber) {
		this.identityNumber = identityNumber;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSurname() {
		return surname;
	}

	public void setSurname(String surname) {
		this.surname = surname;
	}

	public LocalDate getDateOfBirth() {
		return dateOfBirth;
	}

	public void setDateOfBirth(LocalDate dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}

	public Customer(String identityNumber, String name, String surname, LocalDate dateOfBirth) {
		super();
		this.identityNumber = identityNumber;
		this.name = name;
		this.surname = surname;
		this.dateOfBirth = dateOfBirth;
	}

	public Customer(String name, String surname) {
		this.name = name;
		this.surname = surname;
	}

}
