package mx.rest.shop.service;

import java.util.Date;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import mx.rest.shop.dao.ProductDAO;
import mx.rest.shop.model.Product;


@Service("productService")
public class ProductService {

	@Autowired
	ProductDAO productDao;
	
	@Transactional
	public List<Product> getAllProduct() {
		return productDao.getAllProduct();
	}

	@Transactional
	public Product getProduct(int id) {		
		return productDao.getProduct(id);
	}
	@Transactional
	public List<Product> getProduct(Date updateDate) {
		return productDao.getProduct(updateDate);
	}
	
	@Transactional
	public List<Product> getProduct(Date fromDate,Date toDate) {
		return productDao.getProduct(fromDate,toDate);
	}
}
