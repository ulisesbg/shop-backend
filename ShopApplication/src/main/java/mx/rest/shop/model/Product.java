package mx.rest.shop.model;

import java.math.BigDecimal;
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
@Table(name = "product", schema = "public")
public class Product {

	private int id;	
	private ProductType productType;
	private String name;
	@JsonFormat(pattern="yyyy-MM-dd HH:mm:ss",timezone="GMT-5")
	private Date updateDate;
	@JsonFormat(shape = JsonFormat.Shape.NUMBER_FLOAT)
	private BigDecimal price;

	public Product() {
	}

	public Product(int id, ProductType productType) {
		this.id = id;
		this.productType = productType;
	}

	public Product(int id, ProductType productType, String name, Date updateDate, BigDecimal price) {
		this.id = id;
		this.productType = productType;
		this.name = name;
		this.updateDate = updateDate;
		this.price = price;
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
	@JoinColumn(name = "product_type", nullable = false)
	public ProductType getProductType() {
		return this.productType;
	}

	public void setProductType(ProductType productType) {
		this.productType = productType;
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

	@Column(name = "price", precision = 131089, scale = 0)
	public BigDecimal getPrice() {
		return this.price;
	}

	public void setPrice(BigDecimal price) {
		this.price = price;
	}


}
