package Classes;

import Classes.Interfaces.GenericDAO;

import java.sql.SQLException;
import java.util.List;

public class ServiceLayer {

    private final GenericDAO<Product, Integer> ProductDAO;

    public ServiceLayer(GenericDAO<Product, Integer> ProductDAO) {
        this.ProductDAO = ProductDAO;
    }
    public void addProduct(Product product) throws SQLException {
        ProductDAO.insert(product);
    }

    public Product getProductById(int id) throws SQLException {
        return ProductDAO.findById(id);
    }

    public List<Product> getAllProducts() throws SQLException {
        return ProductDAO.findAll();
    }

    public void updateProduct(Product product) throws SQLException {
        ProductDAO.update(product);
    }

    public void removeProduct(int id) throws SQLException {
        ProductDAO.delete(id);
    }
}
