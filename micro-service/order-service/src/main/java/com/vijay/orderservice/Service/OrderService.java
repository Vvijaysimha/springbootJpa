package com.vijay.orderservice.Service;

import com.vijay.orderservice.DTO.InventoryResponse;
import com.vijay.orderservice.DTO.OrderLineItemsDto;
import com.vijay.orderservice.DTO.OrderRequest;
import com.vijay.orderservice.Model.Order;
import com.vijay.orderservice.Model.OrderLineItems;
import com.vijay.orderservice.Repository.OrderRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

import java.util.Arrays;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
@Transactional
public class OrderService {

    private final OrderRepository orderRepository;

    private final WebClient webClient;

    public void placeOrder(OrderRequest orderRequest){
        Order order=new Order();
        order.setOrderNumber(UUID.randomUUID().toString());

        List<OrderLineItems> orderLineItemsList=orderRequest.getOrderLineItemsDtoList().stream().map(this::MapToDto).collect(Collectors.toList());
        order.setOrderLineItemsList(orderLineItemsList);
        List<String> skuCodes=  order.getOrderLineItemsList().stream().map(orderLineItems -> orderLineItems.getSkuCode()).collect(Collectors.toList());

        //call Inventory Service ,and place order if product is in stock
       InventoryResponse[] inventoryResponsesArray= webClient.get()
                .uri("http://localhost:8090/api/inventory",
                        uriBuilder -> uriBuilder.queryParam("skuCode",skuCodes).build())
                .retrieve()
                .bodyToMono(InventoryResponse[].class)
                .block();

        boolean allProductsInStack= Arrays.stream(inventoryResponsesArray).allMatch(InventoryResponse::isInStock);

        if(allProductsInStack){
           orderRepository.save(order);
       }else{
           throw new IllegalArgumentException("product is not in stock,please try again");
       }

    }

    private OrderLineItems MapToDto(OrderLineItemsDto orderLineItemsDto) {
        OrderLineItems orderLineItems=new OrderLineItems();
        orderLineItems.setPrice(orderLineItemsDto.getPrice());
        orderLineItems.setQuantity(orderLineItemsDto.getQuantity());
        orderLineItems.setSkuCode(orderLineItemsDto.getSkuCode());
        return orderLineItems;

    }
}
