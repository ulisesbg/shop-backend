package mx.rest.shop.model;


import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.fasterxml.jackson.annotation.JsonFormat;

@Entity
@Table(name = "order", schema = "public")
public class Order{

	private int id;
	private Customer customer;
	private Product product;
	private String name;
	@JsonFormat(pattern="yyyy-MM-dd HH:mm:ss",timezone="GMT-5")
	private Date updateDate;

	public Order() {
	}

	public Order(int id, Customer customer, Product product) {
		this.id = id;
		this.customer = customer;
		this.product = product;
	}

	public Order(int id, Customer customer, Product product, String name, Date updateDate) {
		this.id = id;
		this.customer = customer;
		this.product = product;
		this.name = name;
		this.updateDate = updateDate;
	}

	@Id

	@Column(name = "id", unique = true, nullable = false)
	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	@OneToOne
	@JoinColumn(name = "customer", nullable = false)
	public Customer getCustomer() {
		return this.customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

	@OneToOne
	@JoinColumn(name = "product", nullable = false)
	public Product getProduct() {
		return this.product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}

	@Column(name = "name")
	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "update_date", length = 29)
	public Date getUpdateDate() {
		return this.updateDate;
	}

	public void setUpdateDate(Date updateDate) {
		this.updateDate = updateDate;
	}

}
