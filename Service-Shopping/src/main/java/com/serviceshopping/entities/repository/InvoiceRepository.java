package com.serviceshopping.entities.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.serviceshopping.entities.Invoice;

public interface InvoiceRepository extends JpaRepository<Invoice, Long> {

	public List<Invoice> findByCustomerId(Long customerId);

	public Invoice findByNumberInvoice(String numberInvoice);

}
