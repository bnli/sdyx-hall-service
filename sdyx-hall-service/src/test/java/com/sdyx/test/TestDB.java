package com.sdyx.test;

import java.util.List;

import org.apache.log4j.Logger;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.sdyx.hall.service.internal.customer.echannel.controller.OrderController;
import com.sdyx.hall.service.internal.customer.echannel.model.OrderItemInfo;
import com.sdyx.hall.service.internal.customer.echannel.service.ServiceInfoService;
import com.sdyx.hall.service.internal.customer.echannel.service.impl.ServiceInfoServiceImpl;


@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath*:spring.xml",
		"classpath*:spring-mybatis.xml" })
public class TestDB {

	/*private static final Logger LOGGER = Logger
			.getLogger(TestDB.class);*/

	@Autowired
	private ServiceInfoService serviceInfoService;
	
	@Test
	public void Test2() {
		System.out.println(serviceInfoService.getRenewalInfo("ZB", "8533003607843680"));
	}
	
	@Test
	public void Test3() {
		System.out.println(serviceInfoService.getUserProInfo("JS", "8531103765778231"));
	}
	
	@Test
	public void Test4() {
		System.out.println(serviceInfoService.getCustomerCommonBalanceInfo("ZB", "030570063987"));
	}
	
	@Test
	public void Test5() {
		System.out.println(serviceInfoService.getOrderInfo("DY", ""));
	}

}
