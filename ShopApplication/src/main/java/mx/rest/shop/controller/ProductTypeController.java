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
import mx.rest.shop.model.ProductType;
import mx.rest.shop.service.ProductTypeService;

@RestController
public class ProductTypeController {
	
	@Autowired
	ProductTypeService productTypeService;
	
	@RequestMapping(value="/getAllProductType", method = RequestMethod.GET, headers = "Accept=application/json")
	public List<ProductType> getProductType() {		
		List<ProductType> listOfProductType = productTypeService.getAllProductType();
		return listOfProductType;
	}	

	@RequestMapping(value = "/getProductType/{id}", method = RequestMethod.GET, headers = "Accept=application/json")
	public ProductType getProductTypeById(@PathVariable int id) {		
		return productTypeService.getProductType(id);
	}
	
	@RequestMapping(value = "/getProductType", method = RequestMethod.GET, headers = "Accept=application/json")
	public List<ProductType> getProductTypeByDate(@RequestParam("updateDate") @DateTimeFormat(pattern="yyyy-MM-dd") Date updateDate) {
		List<ProductType> listOfProductType = productTypeService.getProductType(updateDate);
		return listOfProductType;
	}
	
	@RequestMapping(value = "/getProductTypeFromTo", method = RequestMethod.GET, headers = "Accept=application/json")
	public List<ProductType> getProductTypeFromTo(@RequestParam("fromDate") @DateTimeFormat(pattern="yyyy-MM-dd") Date fromDate,@RequestParam("toDate") @DateTimeFormat(pattern="yyyy-MM-dd") Date toDate) {
		List<ProductType> listOfProductType = productTypeService.getProductType(fromDate,toDate);
		return listOfProductType;
	}
}
