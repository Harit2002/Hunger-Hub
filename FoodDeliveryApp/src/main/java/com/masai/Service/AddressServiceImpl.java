package com.masai.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.masai.Exception.AddressException;
import com.masai.Exception.RestaurantException;
import com.masai.Exception.UserException;
import com.masai.Model.Address;
import com.masai.Model.Restaurant;
import com.masai.Model.User;
import com.masai.Repository.AddressRepo;
import com.masai.Repository.RestaurantRepo;
import com.masai.Repository.UserRepo;

@Service
public class AddressServiceImpl implements AddressService {

	@Autowired
	private AddressRepo addressRepo;

	@Autowired
	private UserRepo userRepo;

	@Autowired
	private RestaurantRepo restRepo;

	@Override
	public Address addAddressToUser(Address address, Integer id) throws UserException , AddressException{

		User user = userRepo.findById(id).orElseThrow(() -> new UserException("User not found!!!"));
		
		if(user.getAddress() != null) throw new AddressException("Address already exist");

		Address savedAddress = addressRepo.save(address);

		user.setAddress(address);

		userRepo.save(user);

		return savedAddress;
	}

	@Override
	public Address updateAddressToUser(Address address, Integer userId, Integer addressId)
			throws AddressException, UserException {

		userRepo.findById(userId).orElseThrow(() -> new UserException("User Not Found!!!!"));

		
		
		Address existingAddress = addressRepo.findById(addressId)
				.orElseThrow(() -> new AddressException("No Address with this id"));

		address.setAddressId(existingAddress.getAddressId());

		return addressRepo.save(existingAddress);

	}

	@Override
	public Address addAddressToRestaurant(Address address, Integer restId)
			throws RestaurantException, AddressException {

		Restaurant rest = restRepo.findById(restId)
				.orElseThrow(() -> new RestaurantException("No restaurant with this ID..."));
		
		if(rest.getAddress() != null) throw new AddressException("Address already exist");
		
		Address add = addressRepo.save(address);
		
		rest.setAddress(address);
		
		restRepo.save(rest);

		return add;
	}

	@Override
	public Address updateAddressToRestaurant(Address address, Integer restId, Integer addressID)
			throws RestaurantException, AddressException {

		Restaurant rest = restRepo.findById(restId)
				.orElseThrow(() -> new RestaurantException("No restaurant with this ID..."));

		Address add = rest.getAddress();

		address.setAddressId(add.getAddressId());

		return addressRepo.save(address);
	}

	@Override
	public Address deleteAddressOfUser(Integer userId, Integer addressId) throws UserException, AddressException {

		userRepo.findById(userId).orElseThrow(() -> new UserException("User Not found !!!!"));

		Address address = addressRepo.findById(addressId)
				.orElseThrow(() -> new AddressException("No address with this id!!"));

		addressRepo.delete(address);

		return address;
	}

	@Override
	public Address deleteAddressOfRestaurant(Integer restId, Integer addressId)
			throws RestaurantException, AddressException {

		restRepo.findById(restId)
				.orElseThrow(() -> new RestaurantException("No restaurant with this ID..."));

		Address address = addressRepo.findById(addressId)
				.orElseThrow(() -> new AddressException("No Address with this id"));

		addressRepo.delete(address);

		return address;
	}

}
