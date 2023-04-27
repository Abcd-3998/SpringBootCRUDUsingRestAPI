package com.example.demo.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.Entity.Product;
import com.example.demo.Service.ProductService;

@RestController
public class ProductController {
	@Autowired
	private ProductService service;
	@PostMapping("/addProduct")
	public Product addProduct(@RequestBody Product product)
	{
		return service.SaveProduct(product);
	}
	@PostMapping("/addProducts")
	public List<Product>addProducts(@RequestBody List<Product>products)
	{
		return service.SaveProduct(products);
	}
	@GetMapping("/Products")
	public List<Product>findAllProducts()
	{
		return service.getAllProducts();
	}
	@GetMapping("/ProductById/{id}")
	public Product findProductById(@PathVariable int id)
	{
		return service.getProductById(id);
	}
	@GetMapping("/ProductByName/{name}")
	public Product findProductByName(@PathVariable String name)
	{
		return service.getProductByName(name);
	}
	@PutMapping("/update")
	public Product updateProduct(@RequestBody Product product)
	{
		return service.updateProduct(product);
	}
	@DeleteMapping("/delete/{id}")
	public String delete(@PathVariable int id)
	{
		return service.deleteById(id);
	}
	
	

}
