package Controller;

import Model.Order;
import Model.Product;

public interface RepoInterface {

    void remove(Long Id);

    public Product findIdProduct(Long id);

    void buyProduct( Order order);
}
