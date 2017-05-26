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
import mx.rest.shop.model.Product;
import mx.rest.shop.service.ProductService;


@RestController
public class ProductController {

	@Autowired
	ProductService productService;
	
	@RequestMapping(value="/getAllProduct", method = RequestMethod.GET, headers = "Accept=application/json")
	public List<Product> getProduct() {		
		List<Product> listOfProduct = productService.getAllProduct();
		return listOfProduct;
	}	

	@RequestMapping(value = "/getProduct/{id}", method = RequestMethod.GET, headers = "Accept=application/json")
	public Product getProductById(@PathVariable int id) {		
		return productService.getProduct(id);
	}
	@RequestMapping(value = "/getProduct", method = RequestMethod.GET, headers = "Accept=application/json")
	public List<Product> getProductByDate(@RequestParam("updateDate") @DateTimeFormat(pattern="yyyy-MM-dd") Date updateDate) {
		List<Product> listOfProduct = productService.getProduct(updateDate);
		return listOfProduct;
	}
	
	@RequestMapping(value = "/getProductFromTo", method = RequestMethod.GET, headers = "Accept=application/json")
	public List<Product> getProductFromTo(@RequestParam("fromDate") @DateTimeFormat(pattern="yyyy-MM-dd") Date fromDate,@RequestParam("toDate") @DateTimeFormat(pattern="yyyy-MM-dd") Date toDate) {
		List<Product> listOfProduct = productService.getProduct(fromDate,toDate);
		return listOfProduct;
	}
}
