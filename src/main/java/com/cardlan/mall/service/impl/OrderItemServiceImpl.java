package com.cardlan.mall.service.impl;

import com.cardlan.mall.dao.OrderItemMapper;
import com.cardlan.mall.model.OrderItem;
import com.cardlan.mall.service.OrderItemService;
import com.cardlan.mall.common.core.AbstractService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;


/**
 * @Author: YUEXIN
 * @Date: 2020-08-06 15:08:08
 */
@Service
@Transactional
public class OrderItemServiceImpl extends AbstractService<OrderItem> implements OrderItemService {
    @Resource
    private OrderItemMapper orderItemMapper;

}
