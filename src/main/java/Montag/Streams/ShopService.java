package Montag.Streams;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

public class ShopService {

    private final ProductRepo myProducts;
    private final OrderRepo myOrders;

    public ShopService(ProductRepo myProducts, OrderRepo myOrders) {
        this.myProducts = myProducts;
        this.myOrders = myOrders;
    }


    public Product getProduct(String id){
        return myProducts.get(id).orElseThrow();
    }

    public List<Product> listProducts(){
        return myProducts.list();
    }

    public void addOrder(List<String> productsToOrder){
        long unknownIDPresent = productsToOrder.stream()
                .map(p -> myProducts.get(p))
                .filter(p -> p.isEmpty())
                .count();
        if (unknownIDPresent > 0){
            throw new NoSuchElementException();
        }
        /*        for (String id : productsToOrder){
            orderedProducts.add(getProduct(id));
        }*/
        List<Product> orderedProducts = productsToOrder.stream()
                .map(p -> getProduct(p))
                        .toList();
        myOrders.add(new Order(orderedProducts));
    }

    public Order getOrder(String id){
        return myOrders.get(id).orElseThrow();
    }

    public List<Order> listOrders(){
        return myOrders.list();
    }

    public List<Product> searchProducts (String searchedProduct){
        return myProducts.list().stream()
                .filter(p -> p.getName().startsWith(searchedProduct))
                .toList();
    }

}