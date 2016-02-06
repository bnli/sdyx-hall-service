package com.sdyx.hall.service.internal.customer.echannel.service.impl;

import java.io.IOException;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.codehaus.jackson.JsonGenerationException;
import org.codehaus.jackson.map.JsonMappingException;
import org.codehaus.jackson.map.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sdyx.hall.service.internal.customer.echannel.dao.BossDao;
import com.sdyx.hall.service.internal.customer.echannel.model.OrderItemInfo;
import com.sdyx.hall.service.internal.customer.echannel.model.RenewalInfo;
import com.sdyx.hall.service.internal.customer.echannel.model.UserProInfo;
import com.sdyx.hall.service.internal.customer.echannel.service.ServiceInfoService;

@Service("serviceInfoService")
public class ServiceInfoServiceImpl implements ServiceInfoService{

	@Autowired
	private BossDao bossDao;

	ObjectMapper mapper = new ObjectMapper();
	
	@Override
	public String getRenewalInfo(String cityFlag, String caNo) {
		// TODO Auto-generated method stub
		
		try {
		Map<String, Object> result = new HashMap<String, Object>();
		result.put("status", "0");
		result.put("errorMessage", "获取续订信息成功");
		List<Object> purchaseInfos = new ArrayList<Object>();
		List<RenewalInfo> renewalInfos = bossDao.selectRenewalInfo(cityFlag, caNo);
		for (RenewalInfo renewalInfo:renewalInfos) {
			Map<String, Object> purchaseInfo = new HashMap<String, Object>();
			purchaseInfo.put("terminalIdentification", caNo);
			if (renewalInfo.getmPCo()==null) {
				purchaseInfo.put("productOfferingCode", renewalInfo.getpOCo());
				purchaseInfo.put("preferentialPolicyCode", renewalInfo.getpPCo());
				purchaseInfo.put("month", "12");
			} else {
				purchaseInfo.put("productOfferingCode", renewalInfo.getmPCo());
				purchaseInfo.put("marketPlanCode", renewalInfo.getmPCo());
			}
			if (!purchaseInfos.contains(purchaseInfo)) {
				purchaseInfos.add(purchaseInfo);
			}
		}
		Map<String, Object> data = new HashMap<String, Object>();
		data.put("purchaseInfos", purchaseInfos);
		result.put("data", data);
		result.put("method", "getRenewalInfo");
		
			return mapper.writeValueAsString(result);
		} catch (JsonGenerationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (JsonMappingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
				
		return "{\"status\":\"1\",\"errorMessage\":\"\",\"data\":{}}";
	}
	
	@Override
	public String getUserProInfo(String cityFlag, String caNo) {
		// TODO Auto-generated method stub

		try {
			Map<String, Object> result = new HashMap<String, Object>();
			result.put("status", "0");
			result.put("errorMessage", "获取用户产品信息成功");
			List<Object> userProInfos = new ArrayList<Object>();
			List<UserProInfo> tUserProInfos = bossDao.selectUserProInfo(cityFlag, caNo);
			for (UserProInfo tUserProInfo:tUserProInfos) {
				Map<String, Object> userProInfo = new HashMap<String, Object>();
				userProInfo.put("productCode", tUserProInfo.getproductCode());
				userProInfo.put("productDinggouValid", tUserProInfo.getproductDinggouValid());
				userProInfo.put("productEndValid", tUserProInfo.getproductEndValid());
				userProInfo.put("productName", tUserProInfo.getproductName());
				userProInfo.put("productOfferingType", tUserProInfo.getproductOfferingType());
				userProInfo.put("productPauseTime", tUserProInfo.getproductPauseTime());
				userProInfo.put("productPolicy", tUserProInfo.getproductPolicy());
				userProInfo.put("productStartValid", tUserProInfo.getproductStartValid());
				userProInfo.put("producttUserProInfo", tUserProInfo.getproductStatusName());
				userProInfo.put("productServiceChannel", tUserProInfo.getserviceChannel());
				userProInfo.put("productTerminalIdentification", tUserProInfo.getterminalIdentification());
				userProInfo.put("productTerminalType", tUserProInfo.getterminalType());
				
				userProInfos.add(userProInfo);
			}
			Map<String, Object> data = new HashMap<String, Object>();
			data.put("userProInfos", userProInfos);
			result.put("data", data);
			result.put("method", "getUserProInfo");

			return mapper.writeValueAsString(result);
		} catch (JsonGenerationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (JsonMappingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

			return "{\"status\":\"1\",\"errorMessage\":\"\",\"data\":{}}";
		
				
	}

	@Override
	public String getCustomerCommonBalanceInfo(String cityFlag, String cNo) {
		// TODO Auto-generated method stub
		
		try {
			Map<String, Object> result = new HashMap<String, Object>();
			result.put("status", "0");
			result.put("errorMessage", "获取通用余额信息成功");
			//List<Object> userProInfos = new ArrayList<Object>();
			Double customerCommonBalance = bossDao.selectCustomerBalanceInfo(cityFlag, cNo);
			Map<String, Object> data = new HashMap<String, Object>();
			if (customerCommonBalance != null) {
				data.put("amount", String.valueOf(Math.round(customerCommonBalance.doubleValue() * 100)));
			} else {
				data.put("amount", "0");
			}
			result.put("data", data);
			result.put("method", "getCustomerCommonBalance");

			return mapper.writeValueAsString(result);
		} catch (JsonGenerationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (JsonMappingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

			return "{\"status\":\"1\",\"errorMessage\":\"\",\"data\":{}}";
		
	}

	@Override
	public String getOrderInfo(String cityFlag, String orNo) {
		// TODO Auto-generated method stub
		try {
			Map<String, Object> result = new HashMap<String, Object>();
			result.put("status", "0");
			result.put("errorMessage", "获取订单信息成功");
			List<Object> orderInfo = new ArrayList<Object>();
			List<OrderItemInfo> torderInfo = bossDao.selectOrderInfo(cityFlag, orNo);
			for (OrderItemInfo torderItemInfo:torderInfo) {
				Map<String, Object> orderItemInfo = new HashMap<String, Object>();
				if (torderItemInfo.getOrderType() == 1) {
					orderItemInfo.put("orderType", 1);
					orderItemInfo.put("customerCode", torderItemInfo.getCustomerCode());
					orderItemInfo.put("customerName", torderItemInfo.getCustomerName());
					orderItemInfo.put("manageAddressFullName", torderItemInfo.getManageAddressFullName());
					orderItemInfo.put("commodityName", torderItemInfo.getCommodityName());
					orderItemInfo.put("payMonth", torderItemInfo.getPayMonth());
					orderItemInfo.put("commodityPrice", torderItemInfo.getCommodityPrice());
					orderItemInfo.put("caNumber", torderItemInfo.getCaNumber());
				} else {
					orderItemInfo.put("orderType", 2);
					orderItemInfo.put("customerCode", torderItemInfo.getCustomerCode());
					orderItemInfo.put("customerName", torderItemInfo.getCustomerName());
					orderItemInfo.put("manageAddressFullName", torderItemInfo.getManageAddressFullName());
					orderItemInfo.put("commodityPrice", torderItemInfo.getCommodityPrice());
				}
				orderInfo.add(orderItemInfo);
			}
			Map<String, Object> data = new HashMap<String, Object>();
			data.put("orderInfo", orderInfo);
			result.put("data", data);
			result.put("method", "getOrderInfo");
			
				return mapper.writeValueAsString(result);
			} catch (JsonGenerationException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (JsonMappingException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
					
			return "{\"status\":\"1\",\"errorMessage\":\"\",\"data\":{}}";
	}
}
