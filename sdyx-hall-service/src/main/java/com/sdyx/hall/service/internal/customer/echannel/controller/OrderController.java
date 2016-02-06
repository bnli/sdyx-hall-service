package com.sdyx.hall.service.internal.customer.echannel.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.codehaus.jackson.JsonParseException;
import org.codehaus.jackson.map.JsonMappingException;
import org.codehaus.jackson.map.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.sdyx.hall.service.internal.customer.echannel.model.OrderItemInfo;
import com.sdyx.hall.service.internal.customer.echannel.service.ServiceInfoService;

@Controller
public class OrderController {
	
	@Autowired
	private ServiceInfoService serviceInfoService;
	
	ObjectMapper mapper = new ObjectMapper();
	
	/*@RequestMapping("/showOrderInfo/cityFlag/{cityFlag}/orderNumber/{orderNumber}")
	public String showOrderInfo(ModelMap modelMap,
			@PathVariable String cityFlag, @PathVariable String orderNumber) {
		String orderInfo = serviceInfoService.getOrderInfo(cityFlag,
				orderNumber);
		modelMap.addAttribute("orderInfo", orderInfo);
		return "/showOrderInfo";
	}*/
	
	@RequestMapping("/IUnifiedEChannelService")
	public String IUnifiedEChannelService() {
		return "/IUnifiedEChannelService";
	}
	
	@SuppressWarnings("unchecked")
	@RequestMapping("/showOrderInfo")
	public String showOrderInfo(ModelMap modelMap,
			@RequestParam("cityFlag") String cityFlag,
			@RequestParam("orderNumber") String orderNumber) {
		try {
			Map<String, Object> response = mapper.readValue(serviceInfoService.getOrderInfo(cityFlag,orderNumber), Map.class);
			List<Object> tOrderInfo = (List<Object>)((Map<String, Object>)response.get("data")).get("orderInfo");
			List<OrderItemInfo> orderInfo = new ArrayList<OrderItemInfo>();
			for (Object torderItemInfo:tOrderInfo) {
				OrderItemInfo orderItemInfo = new OrderItemInfo();
				orderItemInfo.setOrderType(Long.valueOf(((Map<String, Object>)torderItemInfo).get("orderType").toString()));
				if (orderItemInfo.getOrderType() == 1) {
					orderItemInfo.setCustomerCode((String) ((Map<String, Object>)torderItemInfo).get("customerCode"));
					orderItemInfo.setCustomerName((String) ((Map<String, Object>)torderItemInfo).get("customerName"));
					orderItemInfo.setManageAddressFullName((String) ((Map<String, Object>)torderItemInfo).get("manageAddressFullName"));
					orderItemInfo.setCommodityPrice((Double) ((Map<String, Object>)torderItemInfo).get("commodityPrice"));
					orderItemInfo.setCommodityName((String) ((Map<String, Object>)torderItemInfo).get("commodityName"));
					orderItemInfo.setPayMonth((Double) ((Map<String, Object>)torderItemInfo).get("payMonth"));
					orderItemInfo.setCaNumber((String) ((Map<String, Object>)torderItemInfo).get("caNumber"));
				} else {
					orderItemInfo.setCustomerCode((String) ((Map<String, Object>)torderItemInfo).get("customerCode"));
					orderItemInfo.setCustomerName((String) ((Map<String, Object>)torderItemInfo).get("customerName"));
					orderItemInfo.setManageAddressFullName((String) ((Map<String, Object>)torderItemInfo).get("manageAddressFullName"));
					orderItemInfo.setCommodityPrice((Double) ((Map<String, Object>)torderItemInfo).get("commodityPrice"));
				}
				orderInfo.add(orderItemInfo);
			}
			modelMap.addAttribute("orderInfo", orderInfo);
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
		return "/showOrderInfo";
	}
}
