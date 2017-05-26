package mx.rest.shop.service;

import mx.rest.shop.model.ProductType;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import mx.rest.shop.dao.ProductTypeDAO;

@Service("productTypeService")
public class ProductTypeService {
	
	@Autowired
	ProductTypeDAO productTypeDao;
	
	@Transactional
	public List<ProductType> getAllProductType() {
		return productTypeDao.getAllProductType();
	}

	@Transactional
	public ProductType getProductType(int id) {		
		return productTypeDao.getProductType(id);
	}
	
	@Transactional
	public List<ProductType> getProductType(Date updateDate) {
		return productTypeDao.getProductType(updateDate);
	}
	
	@Transactional
	public List<ProductType> getProductType(Date fromDate,Date toDate) {
		return productTypeDao.getProductType(fromDate,toDate);
	}

}
