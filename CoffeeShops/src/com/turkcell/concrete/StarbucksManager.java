package com.turkcell.concrete;

import com.turkcell.Abstract.BaseCustomerManager;
import com.turkcell.Abstract.BuyManager;
import com.turkcell.Adapter.MernisCheck;
import com.turkcell.entities.Customer;

public class StarbucksManager extends BaseCustomerManager implements BuyManager {
	private MernisCheck customercheck;

	public StarbucksManager(MernisCheck customercheck) {
		this.customercheck = customercheck;
	}

	public StarbucksManager() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public void save(Customer customer) {
		if (customercheck.checkIfRealPerson(customer)) {
			System.out.println(customer.getName() + " eklendi.");
		} else {
			System.out.println("Kullanıcı Doğrulanamadı " + customer.getName());
		}
	}

	@Override
	public void buyCoffee(Customer customer) {
		System.out.println(customer.getName() + customer.getSurname() + " Tebrikler, 10 yıldız kazandınız!");

	}
}
