package com.turkcell;

import java.time.LocalDate;

import com.turkcell.Abstract.BaseCustomerManager;
import com.turkcell.Adapter.MernisCheck;
import com.turkcell.concrete.NeroManager;
import com.turkcell.concrete.StarbucksManager;
import com.turkcell.entities.Customer;

public class Main {

	public static void main(String[] args) {
		BaseCustomerManager neroManager = new NeroManager();
		BaseCustomerManager starBucksManager = new StarbucksManager(new MernisCheck());	
		StarbucksManager star = new StarbucksManager();
		
//		Starbucks Mernis Kontrolü yapıyor.
		starBucksManager.save(new Customer("23486445332", "Abdulvahit Müjdat", "CAMLI", LocalDate.of(2000, 5, 18)));
		
//		Nero yapmıyor, bu yüzden isim, soyisimli constructor çalışıyor.
		neroManager.save(new Customer("Vahit", "Camlı"));
		
//		Kahve Alarak 10 yıldız kazanır.
		star.buyCoffee(new Customer("Vahit", "Camlı"));
	}
}
