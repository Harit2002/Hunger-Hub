package com.masai.Service;

import java.time.LocalDateTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.masai.Exception.BillException;
import com.masai.Exception.OrderDetailsException;
import com.masai.Model.Bill;
import com.masai.Model.OrderDetails;
import com.masai.Repository.BillRepo;
import com.masai.Repository.OrderDetailRepo;

@Service
public class BillServiceImpl implements BillService {

	@Autowired
	private BillRepo bills;
	
	@Autowired
	private OrderDetailRepo orderRepo;

	@Override
	public Bill addBill(Bill bill, Integer orderId) throws OrderDetailsException {
		
		OrderDetails order = orderRepo.findById(orderId).orElseThrow(() -> new OrderDetailsException("Please enter valid order detail id."));
		
		bill.setOrder(order);
		bill.setBillDate(LocalDateTime.now());
		
		return bills.save(bill);
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
