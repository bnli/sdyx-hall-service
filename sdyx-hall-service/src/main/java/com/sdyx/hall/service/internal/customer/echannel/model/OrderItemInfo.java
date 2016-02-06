package com.sdyx.hall.service.internal.customer.echannel.model;

public class OrderItemInfo {

	private Long orderType;
	
	private String customerCode;
	
	private String customerName;
	
	private String manageAddressFullName;
	
	private String commodityName;
	
	private Double payMonth;
	
	private Double commodityPrice;
	
	private String caNumber;

	public Long getOrderType() {
		return orderType;
	}

	public void setOrderType(Long orderType) {
		this.orderType = orderType;
	}

	public String getCustomerCode() {
		return customerCode;
	}

	public void setCustomerCode(String customerCode) {
		this.customerCode = customerCode;
	}

	public String getCustomerName() {
		return customerName;
	}

	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}

	public String getManageAddressFullName() {
		return manageAddressFullName;
	}

	public void setManageAddressFullName(String manageAddressFullName) {
		this.manageAddressFullName = manageAddressFullName;
	}

	public String getCommodityName() {
		return commodityName;
	}

	public void setCommodityName(String commodityName) {
		this.commodityName = commodityName;
	}

	public Double getPayMonth() {
		return payMonth;
	}

	public void setPayMonth(Double payMonth) {
		this.payMonth = payMonth;
	}

	public Double getCommodityPrice() {
		return commodityPrice;
	}

	public void setCommodityPrice(Double commodityPrice) {
		this.commodityPrice = commodityPrice;
	}

	public String getCaNumber() {
		return caNumber;
	}

	public void setCaNumber(String caNumber) {
		this.caNumber = caNumber;
	}
	
	
}
