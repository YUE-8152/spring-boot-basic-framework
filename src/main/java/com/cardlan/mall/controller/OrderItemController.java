package com.cardlan.mall.controller;
import com.cardlan.mall.bean.OrderItemVo;
import com.cardlan.mall.common.core.Result;
import com.cardlan.mall.model.OrderItem;
import com.cardlan.mall.service.OrderItemService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.BeanUtils;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.validation.Valid;
import java.util.List;

/**
 * @Author: YUEXIN
 * @Date: 2020-08-06 15:08:08
 */
@RestController
@RequestMapping("/order/item")
public class OrderItemController {
    @Resource
    private OrderItemService orderItemService;

    @PostMapping("/add")
    public Result add(@RequestBody @Valid OrderItemVo vo) {
        OrderItem orderItem = new OrderItem();
        BeanUtils.copyProperties(vo,orderItem);
        orderItemService.insert(orderItem);
        return Result.success();
    }

    @PostMapping("/delete")
    public Result delete(@RequestParam Integer id) {
        orderItemService.deleteById(id);
        return Result.success();
    }

    @PostMapping("/update")
    public Result update(@RequestBody OrderItem orderItem) {
        orderItemService.update(orderItem);
        return Result.success();
    }

    @PostMapping("/detail")
    public Result detail(@RequestParam Integer id) {
        OrderItem orderItem = orderItemService.findById(id);
        return Result.success(orderItem);
    }

    @PostMapping("/list")
    public Result list(@RequestParam(defaultValue = "0") Integer page, @RequestParam(defaultValue = "0") Integer size) {
        PageHelper.startPage(page, size);
        List<OrderItem> list = orderItemService.findAll();
        PageInfo pageInfo = new PageInfo(list);
        return Result.success(pageInfo);
    }

    @PostMapping("/select")
    public List list(@RequestBody OrderItem orderItem) {
        List<OrderItem> list = orderItemService.find(orderItem);
        return list;
    }
}
