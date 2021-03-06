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
import mx.rest.shop.model.Order;

@Repository
@SuppressWarnings("unchecked")
public class OrderDAO {
	@Autowired
	private SessionFactory sessionFactory;

	public void setSessionFactory(SessionFactory sf) {
		this.sessionFactory = sf;
	}

	public List<Order> getAllOrder() {
		Session session = this.sessionFactory.getCurrentSession();		
		Criteria criteria = session.createCriteria(Order.class);
		List<Order> orderList = criteria.list();
		return orderList;
	}

	public Order getOrder(int id) {
		Session session = this.sessionFactory.getCurrentSession();
		Order order = (Order) session.get(Order.class, new Integer(id));
		return order;
	}
	public List<Order> getOrder(Date updateDate) {
		Session session = this.sessionFactory.getCurrentSession();
		Criteria criteria = session.createCriteria(Order.class);
		Date minDate =updateDate;		
		Date maxDate = new Date(updateDate.getTime() + TimeUnit.DAYS.toMillis(1));
	    Conjunction conjuntion = Restrictions.conjunction();
	    //Fecha Inicio--00h00
	    conjuntion.add( Restrictions.ge("updateDate", minDate) );
	    // Fecha Fin -- 24h00
	    conjuntion.add( Restrictions.lt("updateDate", maxDate) ); 
	    criteria.add(conjuntion);		
		List<Order> orderList = criteria.list();
		return orderList;
	}
	public List<Order> getOrder(Date fromDate,Date toDate) {
		Session session = this.sessionFactory.getCurrentSession();
		Criteria criteria = session.createCriteria(Order.class);
		Date minDate =fromDate;
		Date maxDate = new Date(toDate.getTime() + TimeUnit.DAYS.toMillis(1));
	    Conjunction conjuntion = Restrictions.conjunction();
	    //Fecha Inicio--00h00
	    conjuntion.add( Restrictions.ge("updateDate", minDate) );
	    // Fecha Fin -- 24h00
	    conjuntion.add( Restrictions.lt("updateDate", maxDate) ); 
	    criteria.add(conjuntion);		
		List<Order> orderList = criteria.list();
		return orderList;
	}
}
