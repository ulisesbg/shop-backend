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
import mx.rest.shop.model.Customer;

@Repository
@SuppressWarnings("unchecked")
public class CustomerDAO {
	@Autowired
	private SessionFactory sessionFactory;

	public void setSessionFactory(SessionFactory sf) {
		this.sessionFactory = sf;
	}

	public List<Customer> getAllCustomer() {
		Session session = this.sessionFactory.getCurrentSession();		
		Criteria criteria = session.createCriteria(Customer.class);		
		List<Customer> customerList = criteria.list();
		return customerList;
	}

	public Customer getCustomer(int id) {
		Session session = this.sessionFactory.getCurrentSession();
		Customer customer = (Customer) session.get(Customer.class, new Integer(id));
		return customer;
	}
	
	public List<Customer> getCustomer(Date updateDate) {
		Session session = this.sessionFactory.getCurrentSession();
		Criteria criteria = session.createCriteria(Customer.class);
		Date minDate =updateDate;		
		Date maxDate = new Date(updateDate.getTime() + TimeUnit.DAYS.toMillis(1));
	    Conjunction conjuntion = Restrictions.conjunction();
	    //Fecha Inicio--00h00
	    conjuntion.add( Restrictions.ge("updateDate", minDate) );
	    // Fecha Fin -- 24h00
	    conjuntion.add( Restrictions.lt("updateDate", maxDate) ); 
	    criteria.add(conjuntion);		
		List<Customer> customerList = criteria.list();
		return customerList;
	}
	public List<Customer> getCustomer(Date fromDate,Date toDate) {
		Session session = this.sessionFactory.getCurrentSession();
		Criteria criteria = session.createCriteria(Customer.class);
		Date minDate =fromDate;
		Date maxDate = new Date(toDate.getTime() + TimeUnit.DAYS.toMillis(1));
	    Conjunction conjuntion = Restrictions.conjunction();
	    //Fecha Inicio--00h00
	    conjuntion.add( Restrictions.ge("updateDate", minDate) );
	    // Fecha Fin -- 24h00
	    conjuntion.add( Restrictions.lt("updateDate", maxDate) ); 
	    criteria.add(conjuntion);		
		List<Customer> customerList = criteria.list();
		return customerList;
	}
}
