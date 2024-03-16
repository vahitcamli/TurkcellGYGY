package com.turkcell.Abstract;

import com.turkcell.entities.Customer;

public interface ICustomerCheck {
	public boolean checkIfRealPerson(Customer customer);
}
