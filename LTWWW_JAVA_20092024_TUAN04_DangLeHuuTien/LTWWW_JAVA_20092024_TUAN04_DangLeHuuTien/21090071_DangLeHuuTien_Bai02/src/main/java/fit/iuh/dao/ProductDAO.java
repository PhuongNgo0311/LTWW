package fit.iuh.dao;

import java.util.List;

import fit.iuh.models.Product;

public interface ProductDAO {
	public List<Product> findAll();
	public Product getById(int id);
	public void addProduct(Product p);
}
