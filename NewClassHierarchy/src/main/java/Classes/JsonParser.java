package Classes;

import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.IOException;

public class JsonParser {
    public Products parse(String filePath){
        ObjectMapper objectMapper=new ObjectMapper();
        Products products = null;

        try{
            products=objectMapper.readValue(new File(filePath),Products.class);
        }catch(IOException e){
            e.printStackTrace();
        }
        return products;
    }
}
