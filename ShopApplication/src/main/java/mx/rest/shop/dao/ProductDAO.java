package mx.rest.shop.dao;

import java.util.Date;
import java.util.List;
import java.util.concurrent.TimeUnit;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Conjunction;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import mx.rest.shop.model.Product;

@Repository
@SuppressWarnings("unchecked")
public class ProductDAO {
	@Autowired
	private SessionFactory sessionFactory;

	public void setSessionFactory(SessionFactory sf) {
		this.sessionFactory = sf;
	}

	public List<Product> getAllProduct() {
		Session session = this.sessionFactory.getCurrentSession();		
		Criteria criteria = session.createCriteria(Product.class);
		List<Product> productList = criteria.list();
		return productList;
	}

	public Product getProduct(int id) {
		Session session = this.sessionFactory.getCurrentSession();
		Product product = (Product) session.get(Product.class, new Integer(id));
		System.out.println("Fecha:"+product.getUpdateDate());
		
		return product;
	}
	
	public List<Product> getProduct(Date updateDate) {
		Session session = this.sessionFactory.getCurrentSession();
		Criteria criteria = session.createCriteria(Product.class);
		Date minDate =updateDate;		
		Date maxDate = new Date(updateDate.getTime() + TimeUnit.DAYS.toMillis(1));
	    Conjunction conjuntion = Restrictions.conjunction();
	    //Fecha Inicio--00h00
	    conjuntion.add( Restrictions.ge("updateDate", minDate) );
	    // Fecha Fin -- 24h00
	    conjuntion.add( Restrictions.lt("updateDate", maxDate) ); 
	    criteria.add(conjuntion);		
		List<Product> productList = criteria.list();
		return productList;
	}
	public List<Product> getProduct(Date fromDate,Date toDate) {
		Session session = this.sessionFactory.getCurrentSession();
		Criteria criteria = session.createCriteria(Product.class);
		Date minDate =fromDate;
		Date maxDate = new Date(toDate.getTime() + TimeUnit.DAYS.toMillis(1));
	    Conjunction conjuntion = Restrictions.conjunction();
	    //Fecha Inicio--00h00
	    conjuntion.add( Restrictions.ge("updateDate", minDate) );
	    // Fecha Fin -- 24h00
	    conjuntion.add( Restrictions.lt("updateDate", maxDate) ); 
	    criteria.add(conjuntion);		
		List<Product> productList = criteria.list();
		return productList;
	}
}
