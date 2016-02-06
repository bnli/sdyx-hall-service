package com.sdyx.hall.service.internal.customer.echannel.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.sdyx.hall.service.internal.customer.echannel.model.OrderItemInfo;
import com.sdyx.hall.service.internal.customer.echannel.model.RenewalInfo;
import com.sdyx.hall.service.internal.customer.echannel.model.UserProInfo;


public interface BossDao {

    List<UserProInfo> selectUserProInfo(@Param("cityFlag")String cityFlag, @Param("caNo")String caNo);

    List<RenewalInfo> selectRenewalInfo(@Param("cityFlag")String cityFlag, @Param("caNo")String caNo);
    
    Double selectCustomerBalanceInfo(@Param("cityFlag")String cityFlag, @Param("cNo")String cNo);
    
    List<OrderItemInfo> selectOrderInfo(@Param("cityFlag")String cityFlag, @Param("odNo")String odNo);
}