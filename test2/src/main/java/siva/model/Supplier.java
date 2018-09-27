package siva.model;

import javax.persistence.GeneratedValue;
import javax.persistence.Id;

public class Supplier {
	@Id
	@GeneratedValue
	int supplierId;
	String supplierName;
	String address;
	public int getSupplierId() {
		return supplierId;
	}
	public void setSupplierId(int supplierId) {
		this.supplierId = supplierId;
	}
	public String getSupplierName() {
		return supplierName;
	}
	public void setSupplierName(String supplierName) {
		this.supplierName = supplierName;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	
	
	




}
