package com.sdyx.hall.service.internal.customer.echannel.webservice.impl;


import java.io.IOException;
import java.util.Map;

import javax.jws.WebService;

import org.codehaus.jackson.JsonParseException;
import org.codehaus.jackson.map.JsonMappingException;
import org.codehaus.jackson.map.ObjectMapper;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.sdyx.hall.service.internal.customer.echannel.service.ServiceInfoService;
import com.sdyx.hall.service.internal.customer.echannel.webservice.IUnifiedEChannelService;

@WebService(name="IUnifiedEChannelService")
public class UnifiedEChannelService implements IUnifiedEChannelService {
	
	@Autowired
	private ServiceInfoService serviceInfoService;
	
	ObjectMapper mapper = new ObjectMapper();
	
	String response = "bad method";
	
	public String doRequest(String arg0) {
		
		try {
			Map<String, Object> request = mapper.readValue(arg0, Map.class);
			if (((String) request.get("method")).equals("getRenewalInfo")) { 
				String caNumber = (String) ((Map<String, Object>) request.get("parameters")).get("caNumber");
				String operatorID = (String) ((Map<String, Object>) request.get("parameters")).get("operatorID");
				response = serviceInfoService.getRenewalInfo(operatorID, caNumber);
				return response;
			}else if (((String) request.get("method")).equals("getUserProInfo")) {
				String caNumber = (String) ((Map<String, Object>) request.get("parameters")).get("caNumber");
				String operatorID = (String) ((Map<String, Object>) request.get("parameters")).get("operatorID");
				response = serviceInfoService.getUserProInfo(operatorID, caNumber);
				return response;
			}else if (((String) request.get("method")).equals("getCustomerCommonBalanceInfo")) {
				String customerNumber = (String) ((Map<String, Object>) request.get("parameters")).get("customerNumber");
				String operatorID = (String) ((Map<String, Object>) request.get("parameters")).get("operatorID");
				response = serviceInfoService.getCustomerCommonBalanceInfo(operatorID, customerNumber);
				return response;
			}else if (((String) request.get("method")).equals("getOrderInfo")) {
				String orderNumber = (String) ((Map<String, Object>) request.get("parameters")).get("orderNumber");
				String operatorID = (String) ((Map<String, Object>) request.get("parameters")).get("operatorID");
				response = serviceInfoService.getOrderInfo(operatorID, orderNumber);
				return response;
			}else {
				response = "bad method";
				return response;
			}
		} catch (JsonParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (JsonMappingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		response = "runtime error";
		return response;

	}

}
