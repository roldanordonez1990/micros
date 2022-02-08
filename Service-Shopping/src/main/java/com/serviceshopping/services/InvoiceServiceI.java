package com.serviceshopping.services;

import java.util.List;

import com.serviceshopping.entities.Invoice;

public interface InvoiceServiceI {

	public List<Invoice> findInvoiceAll();

	public Invoice createInvoice(Invoice invoice);

	public Invoice updateInvoice(Invoice invoice);

	public Invoice deleteInvoice(Invoice invoice);

	public Invoice getInvoice(Long id);

}
