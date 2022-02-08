package com.serviceshopping.entities.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.serviceshopping.entities.InvoiceItem;

public interface InvoiceItemRepository extends JpaRepository<InvoiceItem, Long>{

}
