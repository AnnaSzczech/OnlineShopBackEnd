package team.java.auction.house.controller;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import team.java.auction.house.domain.CustomerEntity;
import team.java.auction.house.domain.OrderEntity;
import team.java.auction.house.domain.ProductEntity;
import team.java.auction.house.dto.*;
import team.java.auction.house.service.CustomerService;
import team.java.auction.house.service.OrderService;
import team.java.auction.house.service.ProductService;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(path = "/order")
public class OrderController extends BasicResponse {

    @Autowired
    private OrderService orderService;
    @Autowired
    private CustomerService customerService;
    @Autowired
    private ProductService productService;

    private ModelMapper modelMapper = new ModelMapper();

    @GetMapping(value = "/{id}")
    public Response<OrderDTO> getOrder(@PathVariable("id") Long orderId) {
        Optional<OrderEntity> order = orderService.findOrderById(orderId);
        return (order.isPresent()) ? createOkResponse(modelMapper.map(order.get(), OrderDTO.class)) : createNoDataResponse();
    }

    @GetMapping
    public Response<List<OrderDTO>> getAllCustomerOrders(@RequestParam(name = "customerId") Long customerId) {
        List<OrderEntity> orders = orderService.findByCustomerId(customerId);
        List<OrderDTO> data = new ArrayList<>();
        orders.forEach(order -> data.add(modelMapper.map(order, OrderDTO.class)));
        return (!orders.isEmpty()) ? createOkResponse(data) : createNoDataResponse();
    }

    @PostMapping
    public Response<OrderDTO> createOrder(@RequestBody OrderRequest orderRequest) {
        String date = LocalDateTime.now().format(DateTimeFormatter.ofLocalizedDateTime(FormatStyle.MEDIUM));
        if (orderRequest.getCustomerId() == null || orderRequest.getProductsIds() == null || orderRequest.getProductsIds().isEmpty()) {
            return createErrorResponse(new ErrorMessage(401, "Brak wymaganych pól!", date));
        }
        Optional<CustomerEntity> customer = customerService.findCustomerById(orderRequest.getCustomerId());
        if (!customer.isPresent()) {
            return createErrorResponse(new ErrorMessage(401, "Podany klient nie istnieje!", date));
        }
        List<ProductEntity> products = productService.findProductsByIds(orderRequest.getProductsIds());
        if (products.isEmpty()) {
            return createErrorResponse(new ErrorMessage(401, "Podane produkty nie istnieją!", date));
        }
        OrderEntity order = new OrderEntity(customer.get(), products);
        orderService.saveOrder(order);
        return createOkResponse(modelMapper.map(order, OrderDTO.class));
    }
}
