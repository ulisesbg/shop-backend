package mx.rest.shop.dao;

import java.util.Date;
import java.util.List;
import java.util.concurrent.TimeUnit;
import mx.rest.shop.model.ProductType;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Conjunction;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
@SuppressWarnings("unchecked")
public class ProductTypeDAO {
	@Autowired
	private SessionFactory sessionFactory;

	public void setSessionFactory(SessionFactory sf) {
		this.sessionFactory = sf;
	}

	public List<ProductType> getAllProductType() {
		Session session = this.sessionFactory.getCurrentSession();
		Criteria criteria = session.createCriteria(ProductType.class);
		List<ProductType> productTypeList = criteria.list();
		return productTypeList;
	}

	public ProductType getProductType(int id) {
		Session session = this.sessionFactory.getCurrentSession();
		ProductType productType = (ProductType) session.get(ProductType.class, new Integer(id));
		System.out.println(productType.getUpdateDate().toString());
		return productType;
	}
	public List<ProductType> getProductType(Date updateDate) {
		Session session = this.sessionFactory.getCurrentSession();
		Criteria criteria = session.createCriteria(ProductType.class);
		Date minDate =updateDate;
		Date maxDate = new Date(updateDate.getTime() + TimeUnit.DAYS.toMillis(1));
	    Conjunction conjuntion = Restrictions.conjunction();
	    //Fecha Inicio--00h00
	    conjuntion.add( Restrictions.ge("updateDate", minDate) );
	    // Fecha Fin -- 24h00
	    conjuntion.add( Restrictions.lt("updateDate", maxDate) ); 
	    criteria.add(conjuntion);		
		List<ProductType> productTypeList = criteria.list();
		return productTypeList;
	}
	public List<ProductType> getProductType(Date fromDate,Date toDate) {
		Session session = this.sessionFactory.getCurrentSession();
		Criteria criteria = session.createCriteria(ProductType.class);
		Date minDate =fromDate;
		Date maxDate = new Date(toDate.getTime() + TimeUnit.DAYS.toMillis(1));
	    Conjunction conjuntion = Restrictions.conjunction();
	    //Fecha Inicio--00h00
	    conjuntion.add( Restrictions.ge("updateDate", minDate) );
	    // Fecha Fin -- 24h00
	    conjuntion.add( Restrictions.lt("updateDate", maxDate) ); 
	    criteria.add(conjuntion);		
		List<ProductType> productTypeList = criteria.list();
		return productTypeList;
	}
}
