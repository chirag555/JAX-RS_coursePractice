package api.showroom.hibernate.entities;

import java.util.Date;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.Id;
import javax.persistence.PrePersist;
import javax.persistence.PreRemove;
import javax.persistence.PreUpdate;
import javax.persistence.Table;
import javax.persistence.Transient;


@Entity(name = "brands")
@Table(name = "brands")

public class BrandEntity {
	@Id
	@Column(name = "brandId")
	int brandId;
	@Column(name = "brandName")
	String brandName;
	//long temp;
	@Column(name = "operation")
	private String operation;

	@Column(name = "timestamp")
	private String timestamp;

	public String getOperation() {
		return operation;
	}

	public void setOperation(String operation) {
		this.operation = operation;
	}

	public String getTimestamp() {
		return timestamp;
	}

	public void setTimestamp(String timestamp) {
		this.timestamp = timestamp;
	}

	@Transient
	private List<Link> links;

	public List<Link> getLinks() {
		return links;
	}

	public void setLinks(List<Link> links) {
		this.links = links;
	}

	public BrandEntity() {
	}

	public BrandEntity(int brandId, String brandName) {

		this.brandId = brandId;
		this.brandName = brandName;
	}

	public int getbrandId() {
		return brandId;
	}

	public void setbrandId(int brandId) {
		this.brandId = brandId;
	}
	//long date=new Date().getTime();
	/*temp=date.toString();*/
	public String getBrandName() {
		return brandName;
	}

	public void setBrandName(String brandName) {
		this.brandName = brandName;
	}

	@PrePersist
	public void onPrePersist() {
		setOperation("Insert");
		//long date=new Date().getTime();
		setTimestamp((new Date().getTime())+"");

		
		/*
		 long l = 12345L;
		String str = Long.toString(l);
		System.out.println(str); 
		 **/
	}

	@PreUpdate
	public void onPreUpdate() {
		setOperation("Update");
		setTimestamp((new Date().getTime())+"");
	}

	@PreRemove
	public void onPreRemove() {
		setOperation("Remove");
		//setTimestamp(date+"");
		setTimestamp((new Date().getTime())+"");
	}

}
