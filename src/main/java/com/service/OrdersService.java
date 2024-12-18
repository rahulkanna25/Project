package com.service;
 
import com.DAO.OrdersDAO;
import com.model.Orders;
 
import java.util.List;
 
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
 
@Service
public class OrdersService {
 
    @Autowired
    private OrdersDAO ordersDAO;
 
    public OrdersService() {}
	public void add(Orders orders) {
		ordersDAO.save(orders);
	}
	public List<Orders> getAll(){
		return ordersDAO.findAll();
	}
	public void update(Orders orders) {
		ordersDAO.save(orders);
	}
	public void delete(int id) {
        Orders order = ordersDAO.findById(id).orElse(null);
        if (order != null) {
            ordersDAO.delete(order);
        } else {
            throw new RuntimeException("Order with ID " + id + " not found");
        }
    }
	public void save(Orders orders) {
		ordersDAO.save(orders);
	}
}