package com.sdyx.hall.service.internal.customer.echannel.service;

import java.util.List;

import com.sdyx.hall.service.internal.customer.echannel.model.RenewalInfo;

public interface ServiceInfoService {

	public String getRenewalInfo(String cityFlag, String caNo);
	
	public String getUserProInfo(String cityFlag, String caNo);
	
	public String getCustomerCommonBalanceInfo(String cityFlag, String cNo);
	
	public String getOrderInfo(String cityFlag, String orNo);
}
