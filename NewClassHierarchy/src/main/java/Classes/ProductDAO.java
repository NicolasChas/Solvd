package Classes;

import javax.sql.DataSource;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

public class ProductDAO extends AbstractDAO<Product, Integer>{

    public ProductDAO(DataSource dataSource) {
        super(dataSource);
    }
    @Override
    protected Product mapRowToEntity(ResultSet resultSet) throws SQLException {
        int id=resultSet.getInt("idProduct");
        String name=resultSet.getString("name");
        int price=resultSet.getInt("price");
        return new Product(id,name,price);
    }

    @Override
    protected String getTableName() {
        return "Product";
    }

    @Override
    protected Map<String, String> getFieldColumnMapping() {
        Map<String, String> fieldColumnMapping = new HashMap<>();
        fieldColumnMapping.put("idProduct", "idProduct");
        fieldColumnMapping.put("name", "Name");
        fieldColumnMapping.put("price", "Price");
        return fieldColumnMapping;
    }

}
