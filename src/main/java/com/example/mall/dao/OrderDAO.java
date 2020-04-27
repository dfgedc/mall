package com.example.mall.dao;

import com.example.mall.pojo.Order;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * 应用模块名称<p>
 * 代码描述<p>
 * copyright:
 * Company: 上海悟泰信息科技有限公司
 *
 * @author wanghanhong
 * @since 2019/2/26 13:48
 */
public interface OrderDAO extends JpaRepository<Order,Integer> {
}
