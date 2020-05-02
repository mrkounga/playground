package com.rodatek.domain.ordering;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

import com.rodatek.domain.address.Address;
import com.rodatek.domain.organization.Organization;
import com.rodatek.domain.person.Person;
import com.rodatek.domain.product.Product;

public interface Order {
	String getCustomerCellNumber();
	String getAltenativeNumber();
	Address GetDeliveryAddress();
	String getOtherReference();
	LocalDate getOderDate();
	LocalTime getOderTime();
	Person deliveryPerson();
	List<Product> selectedProduct();
	Float getTotalPrice();
	String getPaymentMethod();
	LocalDate getDeliveryDate();
	String getOrderStatus();
	LocalTime getDeliveryTime();
	Organization getOrganization();
}
