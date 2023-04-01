package com.masai.Service;

import com.masai.Exception.AddressException;
import com.masai.Exception.RestaurantException;
import com.masai.Exception.UserException;
import com.masai.Model.Address;

public interface AddressService {
	public Address addAddressToUser(Address address, Integer id) throws UserException, AddressException;
	public Address updateAddressToUser(Address address, Integer userId, Integer addressId) throws  AddressException,UserException;
	public Address addAddressToRestaurant(Address address, Integer restId) throws RestaurantException, AddressException;
	public Address updateAddressToRestaurant(Address address, Integer restId, Integer addressID) throws RestaurantException, AddressException;
	public Address deleteAddressOfUser(Integer userId, Integer addressId) throws UserException, AddressException;
	public Address deleteAddressOfRestaurant(Integer restId, Integer addressId) throws RestaurantException, AddressException;
	
}
