package com.chubb.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

import com.chubb.repository.AddressRepository;
import com.chubb.repository.OrderRepository;
import com.chubb.request.Address;
import com.chubb.request.Order1;
import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class OrderService { //to implement businessRules/Logic
	@Autowired
	OrderRepository orderRepository;
	
	 @Autowired
	 AddressRepository addressRepository;
	
	// AddressRepository addressRepository;
	public Order1 insertOrder(Order1 order) {
		
		Address addr=order.getAddress();
		
		if (addr == null) {
	        throw new RuntimeException("Address is required. Order cannot be saved without address.");
	    }
		if(addr!=null){
			Integer addrId = addr.getId();
			if (addrId != null) {
			Address managed=addressRepository.findById(addr.getId()).orElseThrow(()->new RuntimeException("Address not found"+ addr.getId()));
			order.setAddress(managed);
			}
		
			else {
				Address saved=addressRepository.save(addr);
				 order.setAddress(saved);
			}
		} else {
        // optional: decide whether you allow orders without addresses
        log.warn("Saving order without address: {}", order);
		}
	
		//System.out.println(order);
		
		log.debug(order.toString());
		return orderRepository.save(order);
		
		
	}

}
