package Classes;

import Classes.Interfaces.GenericDAO;

import javax.sql.DataSource;
import java.lang.reflect.Field;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public abstract class AbstractDAO<T,U> implements GenericDAO<T,U> {
    protected abstract T mapRowToEntity(ResultSet resultSet) throws SQLException;
    protected abstract String getTableName();
    protected DataSource dataSource;
    protected abstract Map<String, String> getFieldColumnMapping();
    protected Connection getConnection() throws SQLException {
        return ConnectionPool.getDataSource().getConnection();
    }
    public AbstractDAO(DataSource dataSource) {
        this.dataSource = dataSource;
    }
//    @Override
//    public void insert(T entity) {
//        try (Connection connection = getConnection()) {
//            String sql = "INSERT INTO " + getTableName() + " (...) VALUES ";
//            try (PreparedStatement stmt = connection.prepareStatement(sql)) {
//                stmt.executeUpdate();
//            }
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }
//    }
@Override
public void insert(T entity) {
    Map<String, String> fieldColumnMapping = getFieldColumnMapping();
    // Build the SQL query dynamically
    StringBuilder sql = new StringBuilder("INSERT INTO ");
    sql.append(getTableName()).append(" (");

    // Field names and placeholders for values
    StringBuilder fields = new StringBuilder();
    StringBuilder placeholders = new StringBuilder();

    Field[] entityFields = entity.getClass().getDeclaredFields();
    int fieldCount = 0; // Keep track of the number of fields to match with placeholders

    for (Field field : entityFields) {
        field.setAccessible(true);  // To access private fields
        String columnName = fieldColumnMapping.get(field.getName()); // Map field name to column name

        if (columnName != null) {
            if (fieldCount > 0) { // Append a comma only after the first column
                fields.append(", ");
                placeholders.append(", ");
            }
            fields.append(columnName);
            placeholders.append("?");

            fieldCount++; // Increment field count to track the number of placeholders
        }
    }

    sql.append(fields).append(") VALUES (").append(placeholders).append(")");

    // Execute the prepared statement
    try (Connection connection = getConnection(); PreparedStatement stmt = connection.prepareStatement(sql.toString())) {
        int paramIndex = 1; // Start from parameter index 1
        for (Field field : entityFields) {
            field.setAccessible(true);  // To access private fields
            String columnName = fieldColumnMapping.get(field.getName());

            if (columnName != null) {
                Object value = field.get(entity);  // Get the field value from the entity object
                stmt.setObject(paramIndex, value);  // Set the value dynamically
                paramIndex++; // Increment for each parameter
            }
        }
        stmt.executeUpdate();
    } catch (SQLException | IllegalAccessException e) {
        e.printStackTrace();
    }
}



    @Override
    public void update(T entity) {
        try (Connection connection = getConnection()) {
            String sql = "UPDATE " + getTableName() + " SET ... WHERE id = ?";
            try (PreparedStatement stmt = connection.prepareStatement(sql)) {
                stmt.executeUpdate();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void delete(int id) {
        try (Connection connection = getConnection()) {
            String sql = "DELETE FROM " + getTableName() + " WHERE idProduct = ?";
            try (PreparedStatement stmt = connection.prepareStatement(sql)) {
                stmt.setInt(1, id);
                stmt.executeUpdate();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public T findById(int id) {
        T entity = null;
        try (Connection connection = getConnection()) {
            String sql = "SELECT * FROM " + getTableName() + " WHERE idProduct = ?";
            try (PreparedStatement stmt = connection.prepareStatement(sql)) {
                stmt.setInt(1, id);
                ResultSet resultSet = stmt.executeQuery();
                if (resultSet.next()) {
                    entity = mapRowToEntity(resultSet);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return entity;
    }
    @Override
    public List<T> findAll() {
        List<T> entities = new ArrayList<>();
        try (Connection connection = getConnection()) {
            String sql = "SELECT * FROM " + getTableName();
            try (PreparedStatement stmt = connection.prepareStatement(sql)) {
                ResultSet resultSet = stmt.executeQuery();
                while (resultSet.next()) {
                    entities.add(mapRowToEntity(resultSet));
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return entities;
    }
}
