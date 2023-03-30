package cn.itcast.order.service;

import cn.itcast.order.clients.UserClient;
import cn.itcast.order.mapper.OrderMapper;
import cn.itcast.order.pojo.Order;
import cn.itcast.order.pojo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;

@Service
public class OrderService {

    @Autowired
    private OrderMapper orderMapper;

    @Resource
    private RestTemplate restTemplate;

    @Resource
    private UserClient userClient;

    public Order queryOrderById(Long orderId) {
        // 1.查询订单
        Order order = orderMapper.findById(orderId);
        // 2.通过Feign远程调用userservice服务
        User user = userClient.findById(order.getUserId());
        // 3.封装
        order.setUser(user);
        // 4.返回
        return order;
    }

    // 通过RestTemplate手动远程调用userservice服务
//    public Order queryOrderById(Long orderId) {
//        // 1.查询订单
//        Order order = orderMapper.findById(orderId);
//        // 2.利用RestTemplate发起HTTP请求，远程调用user-service服务（user-service暴露restful接口）
//        // 硬编码服务地址，每次变更都要在这里修改，而且如果服务是多实例，就不能这样硬编码成某一个实例的地址
////        String url = "http://localhost:8081/user/" + order.getUserId();
//        // 用 服务名称 代替 IP和端口，服务地址更改也无需修改，并且适用于多实例服务，根据服务名称拉取服务列表之后由Ribbon进行负载均衡（RestTemplate加上@LoadBalanced）
//        String url = "http://userservice:8081/user/" + order.getUserId();
//        User user = restTemplate.getForObject(url, User.class);
//        // 3.封装
//        order.setUser(user);
//        // 4.返回
//        return order;
//    }
}
