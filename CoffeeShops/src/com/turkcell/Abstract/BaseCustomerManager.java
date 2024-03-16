package com.turkcell.Abstract;

import com.turkcell.entities.Customer;

public class BaseCustomerManager implements ICustomerService {

	@Override
	public void save(Customer customer) {
		System.out.println(customer.getName() + " " + customer.getSurname() + " Veritabanına Kaydedildi");

	}

}
