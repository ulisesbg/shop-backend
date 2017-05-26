package mx.rest.shop.model;

import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.fasterxml.jackson.annotation.JsonFormat;


@Entity
@Table(name = "product_type", schema = "public")
public class ProductType {

	private int id;
	private String name;
	@JsonFormat(pattern="yyyy-MM-dd HH:mm:ss",timezone="GMT-5")
	private Date updateDate;


	public ProductType() {
	}

	public ProductType(int id) {
		this.id = id;
	}

	public ProductType(int id, String name, Date updateDate) {
		this.id = id;
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

	/*public ProductTypeDTO convertToDTO(){		
		ProductTypeDTO dto=new ProductTypeDTO(this.getId(),this.getName(), this.getUpdateDate().toString());		
		return dto; 
	}*/
}
