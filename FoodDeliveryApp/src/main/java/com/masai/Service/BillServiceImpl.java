package com.masai.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.masai.Exception.BillException;
import com.masai.Model.Bill;

import com.masai.Repository.BillRepo;

@Service
public class BillServiceImpl implements BillService {

	@Autowired
	private BillRepo bills;

	@Override
	public Bill addBill(Bill bill) {

		Bill bill1 = bills.save(bill);
		return bill1;
	}

	@Override
	public Bill updateBill(Integer id, Bill bill) throws BillException {

		Bill getBill = bills.findById(id).orElseThrow(() -> new BillException("No Bill found with ID"));

		if (getBill.getBillid() == bill.getBillid()) {

			Bill updatedBill = bills.save(bill);

			return updatedBill;
		} else {
			throw new BillException("Not matching id to bill");
		}

	}

	@Override
	public Bill removeBill(Integer id) throws BillException {

		Bill bill = bills.findById(id).orElseThrow(() -> new BillException("Bill Not Found"));

		bills.delete(bill);
		return bill;

	}

	@Override
	public Bill viewBill(Integer id) throws BillException {

		Bill b = bills.findById(id).orElseThrow(() -> new BillException("No Bill by this id" + id));

		return b;
	}

}
