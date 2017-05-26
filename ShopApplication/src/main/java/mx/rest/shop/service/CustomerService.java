package mx.rest.shop.service;

import java.util.Date;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import mx.rest.shop.dao.CustomerDAO;
import mx.rest.shop.model.Customer;



@Service("customerService")
public class CustomerService {
	@Autowired
	CustomerDAO customerDao;
	
	@Transactional
	public List<Customer> getAllCustomer() {
		return customerDao.getAllCustomer();
	}

	@Transactional
	public Customer getCustomer(int id) {		
		return customerDao.getCustomer(id);
	}
	

	@Transactional
	public List<Customer> getCustomer(Date updateDate) {
		return customerDao.getCustomer(updateDate);
	}
	
	@Transactional
	public List<Customer> getCustomer(Date fromDate,Date toDate) {
		return customerDao.getCustomer(fromDate,toDate);
	}
}
