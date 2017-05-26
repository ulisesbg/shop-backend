package mx.rest.shop.service;

import java.util.Date;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import mx.rest.shop.dao.OrderDAO;
import mx.rest.shop.model.Order;


@Service("orderService")
public class OrderService {
	@Autowired
	OrderDAO orderDao;
	
	@Transactional
	public List<Order> getAllOrder() {
		return orderDao.getAllOrder();
	}

	@Transactional
	public Order getOrder(int id) {		
		return orderDao.getOrder(id);
	}
	
	@Transactional
	public List<Order> getOrder(Date updateDate) {
		return orderDao.getOrder(updateDate);
	}
	
	@Transactional
	public List<Order> getOrder(Date fromDate,Date toDate) {
		return orderDao.getOrder(fromDate,toDate);
	}
}
