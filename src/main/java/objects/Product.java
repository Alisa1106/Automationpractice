package objects;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Product {
    String productName;
    String productQuantity;
    String size;
    String color;
    String price;
}