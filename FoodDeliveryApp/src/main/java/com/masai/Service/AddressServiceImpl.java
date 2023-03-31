package com.masai.Service;

import org.springframework.beans.factory.annotation.Autowired;

import com.masai.Exception.AddressException;
import com.masai.Exception.RestaurantException;
import com.masai.Exception.UserException;
import com.masai.Model.Address;
import com.masai.Model.Restaurant;
import com.masai.Model.User;
import com.masai.Repository.AddressRepo;
import com.masai.Repository.RestaurantRepo;
import com.masai.Repository.UserRepo;

public class AddressServiceImpl implements AddressService {

	@Autowired
	private AddressRepo addressRepo;

	@Autowired
	private UserRepo userRepo;

	@Autowired
	private RestaurantRepo restRepo;

	@Override
	public Address addAddressToUser(Address address, Integer id) throws UserException {

		User user = userRepo.findById(id).orElseThrow(() -> new UserException("User not found!!!"));

		user.setAddress(address);

		Address savedAddress = addressRepo.save(address);

		return savedAddress;
	}

	@Override
	public Address updateAddressToUser(Address address, Integer userId, Integer addressId)
			throws AddressException, UserException {

		User user = userRepo.findById(userId).orElseThrow(() -> new UserException("User Not Found!!!!"));

		Address existingAddress = addressRepo.findById(addressId)
				.orElseThrow(() -> new AddressException("No Address with this id"));

		if (user.getAddress().getAddressId() == existingAddress.getAddressId()) {
			existingAddress.setBuildingName(address.getBuildingName());
			existingAddress.setArea(address.getArea());
			existingAddress.setStreetNo(address.getStreetNo());
			existingAddress.setPincode(address.getPincode());
			existingAddress.setState(address.getState());
			existingAddress.setCountry(address.getCountry());
		} else {
			throw new AddressException("User addressId and Existing address Id not matched Please try again!!");
		}

		Address updateAddress = addressRepo.save(existingAddress);
		return updateAddress;

	}

	@Override
	public Address addAddressToRestaurant(Address address, Integer restId)
			throws RestaurantException, AddressException {
		Restaurant rest = restRepo.findById(restId)
				.orElseThrow(() -> new RestaurantException("No restaurant with this ID..."));

		rest.setAddress(address);

		Address savedAddress = addressRepo.save(address);

		return savedAddress;
	}

	@Override
	public Address updateAddressToRestaurant(Address address, Integer restId, Integer addressID)
			throws RestaurantException, AddressException {
		Restaurant rest = restRepo.findById(restId)
				.orElseThrow(() -> new RestaurantException("No restaurant with this ID..."));
		Address existingAddress = addressRepo.findById(addressID)
				.orElseThrow(() -> new AddressException("No Address with this id"));

		if (rest.getAddress().getAddressId() == existingAddress.getAddressId()) {
			existingAddress.setBuildingName(address.getBuildingName());
			existingAddress.setArea(address.getArea());
			existingAddress.setStreetNo(address.getStreetNo());
			existingAddress.setPincode(address.getPincode());
			existingAddress.setState(address.getState());
			existingAddress.setCountry(address.getCountry());
		}

		Address updateAddress = addressRepo.save(existingAddress);
		return updateAddress;
	}

	@Override
	public Address deleteAddressOfUser(Integer userId, Integer addressId) throws UserException, AddressException {

		User user = userRepo.findById(userId).orElseThrow(() -> new UserException("User Not found !!!!"));

		Address address = addressRepo.findById(addressId)
				.orElseThrow(() -> new AddressException("No address with this id!!"));

		if (user.getAddress().getAddressId() == address.getAddressId()) {
			addressRepo.delete(address);
		} else {
			throw new AddressException("Address id not matched Please try again!!!!!");
		}

		return address;
	}

	@Override
	public Address deleteAddressOfRestaurant(Integer restId, Integer addressId)
			throws RestaurantException, AddressException {

		Restaurant rest = restRepo.findById(restId)
				.orElseThrow(() -> new RestaurantException("No restaurant with this ID..."));
		Address address = addressRepo.findById(addressId)
				.orElseThrow(() -> new AddressException("No Address with this id"));

		if (rest.getAddress().getAddressId() == address.getAddressId()) {

			addressRepo.delete(address);

		} else {
			throw new AddressException("Address Id not matched Please try again !!!!!");
		}

		return address;
	}

}
