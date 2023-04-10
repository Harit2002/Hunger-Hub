package com.masai.Service;

import com.masai.Exception.BillException;
import com.masai.Exception.OrderDetailsException;
import com.masai.Model.Bill;

public interface BillService {
	public Bill addBill(Bill bill, Integer orderId) throws OrderDetailsException;
	public Bill updateBill(Integer id,Bill bill) throws BillException;
	public Bill removeBill(Integer id) throws BillException;
	public Bill viewBill(Integer id) throws BillException;
}
