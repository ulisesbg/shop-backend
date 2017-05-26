package mx.rest.shop.controller;

import java.util.Date;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import mx.rest.shop.model.Order;
import mx.rest.shop.service.OrderService;

@RestController
public class OrderController {
	@Autowired
	OrderService orderService;
	
	@RequestMapping(value="/getAllOrder", method = RequestMethod.GET, headers = "Accept=application/json")
	public List<Order> getOrder() {		
		List<Order> listOfOrder = orderService.getAllOrder();
		return listOfOrder;
	}	

	@RequestMapping(value = "/getOrder/{id}", method = RequestMethod.GET, headers = "Accept=application/json")
	public Order getOrderById(@PathVariable int id) {		
		return orderService.getOrder(id);
	}
	@RequestMapping(value = "/getOrder", method = RequestMethod.GET, headers = "Accept=application/json")
	public List<Order> getOrderByDate(@RequestParam("updateDate") @DateTimeFormat(pattern="yyyy-MM-dd") Date updateDate) {
		List<Order> listOfOrder = orderService.getOrder(updateDate);
		return listOfOrder;
	}
	
	@RequestMapping(value = "/getOrderFromTo", method = RequestMethod.GET, headers = "Accept=application/json")
	public List<Order> getOrderFromTo(@RequestParam("fromDate") @DateTimeFormat(pattern="yyyy-MM-dd") Date fromDate,@RequestParam("toDate") @DateTimeFormat(pattern="yyyy-MM-dd") Date toDate) {
		List<Order> listOfOrder = orderService.getOrder(fromDate,toDate);
		return listOfOrder;
	}
}
