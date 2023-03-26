package com.masai.Service;

import com.masai.Exception.BillException;
import com.masai.Model.Bill;

public interface BillService {
	public Bill addBill(Bill bill);
	public Bill updateBill(Bill bill) throws BillException;
	public Bill removeBill(Bill bill) throws BillException;
	public Bill viewBill(Integer id) throws BillException;
}
