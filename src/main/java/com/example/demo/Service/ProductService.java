package com.example.demo.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.Entity.Product;
import com.example.demo.Repository.ProductRepository;

@Service
public class ProductService {
	@Autowired
	private ProductRepository repository;
	
	public Product SaveProduct(Product product) {
		return repository.save(product);
	}
	 public List<Product>SaveProduct(List<Product>products)
	 {
		 return repository.saveAll(products);
	 }
	 public List<Product>getAllProducts()
	 {
		 return repository.findAll();
	 }
	 public Product getProductById(int id)
	 {
		 return repository.findById(id).orElse(null);
	 }
	
	public Product getProductByName(String name) {
		// TODO Auto-generated method stub
		return repository.findByName(name);
	}
	public Product updateProduct(Product product)
	{
		Product existingProduct=repository.findById(product.getId()).orElse(null);
		existingProduct.setName(product.getName());
		existingProduct.setQuantity(product.getQuantity());
		existingProduct.setPrice(product.getPrice());
		return repository.save(existingProduct);
	}
	public String deleteById(int id) {
		 repository.deleteById(id);
		
		return "successfully deleted"+id;
	}
	

}
