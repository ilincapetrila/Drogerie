package Model;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Set;
import javax.persistence.*;

@Entity
@Table(name="[Order]")
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    //data cumpararii
    LocalDate boughtDate;

    int sum;

    public LocalDate getBoughtDate() {
        return boughtDate;
    }

    public void setBoughtDate(LocalDate boughtDate) {
        this.boughtDate = boughtDate;
    }

    public int getSum() {
        return sum;
    }

    public void setSum(int sum) {
        this.sum = sum;
    }

    public Order() {
        this.boughtDate = LocalDate.now();
    }

    @ManyToMany(cascade= {CascadeType.PERSIST,CascadeType.MERGE})
    @JoinTable(name="order_item", joinColumns =@JoinColumn(name="order_id"),inverseJoinColumns = @JoinColumn(name = "product_id"))
    private List<Product> products=new ArrayList<>();

    @ManyToOne
    @JoinColumn(name = "client_id")
    private Client client;

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public List<Product> getProducts() {
        return products;
    }

    public void setProducts(List<Product> products) {
        this.products = products;
    }

    public void addTag(Product tag) {
        products.add(tag);
        tag.getOrders().add(this);
    }

    @Override
    public String toString() {
        return "Order{" +
                "id=" + id +
                ", boughtDate=" + boughtDate +
                ",sum=" + sum +
                ", products=" + products +
                '}';
    }
}