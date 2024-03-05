package Controller;

import Model.*;

import java.util.List;

import static View.Main.RepoJpa;

public class Table {


    public void tableShowProducts(){
        List<Product> products=RepoJpa.getProducts();
        System.out.printf("%7s %13s %13s %17s %20s %18s", "PRODUCT ID", "STATUS", "QUANTITY", "NAME", "EX-DATE", "PRICE");
        System.out.println();
        System.out.println("---------------------------------------------------------------------------------------------");
//iterates over the list
        for(Product product : products)
        {
            System.out.format("%5s %20s %7s %25s %20s %10s", product.getId(), product.getStatusProduct(),product.getQuantity(),product.getName(),product.getExpirationDate(),product.getPrice());
            System.out.println();
        }
        System.out.println("----------------------------------------------------------------------------------------------");
    }

    public void tableShowProductsSortPrice(){
        List<Product> products=RepoJpa.getSortedList();
        System.out.printf("%7s %17s %13s %15s %20s %16s", "PROD ID", "STATUS", "QUANTITY", "NAME", "EX-DATE", "PRICE");
        System.out.println();
        System.out.println("---------------------------------------------------------------------------------------------");
        for(Product product : products)
        {
            System.out.format("%5s %20s %7s %25s %15s %15s", product.getId(), product.getStatusProduct(),product.getQuantity(),product.getName(),product.getExpirationDate(),product.getPrice());
            System.out.println();
        }
        System.out.println("----------------------------------------------------------------------------------------------");
    }

    public void tableShowProductsInStock(){
        List<Product> products=RepoJpa.getFilteredProducts();
        System.out.printf("%7s %17s %13s %15s %20s %16s", "PROD ID", "STATUS", "QUANTITY", "NAME", "EX-DATE", "PRICE");
        System.out.println();
        System.out.println("---------------------------------------------------------------------------------------------");
        for(Product product : products)
        {
            System.out.format("%5s %20s %7s %25s %15s %15s", product.getId(), product.getStatusProduct(),product.getQuantity(),product.getName(),product.getExpirationDate(),product.getPrice());
            System.out.println();
        }
        System.out.println("----------------------------------------------------------------------------------------------");
    }



    public void tableShowClients(){
        List<Client> clients=RepoJpa.getClientsList();
        System.out.printf("%5s %15s %15s %25s", "ID","FIRST NAME","LAST NAME","DATE-BIRTH");
        System.out.println();
        System.out.println("---------------------------------------------------------------------------------------------");
//iterates over the list
        for(Client client: clients)
        {
            System.out.format("%5s %16s %15s %25s ", client.getId(), client.getFirstName(), client.getLastName(),client.getDateOfBirth());
            System.out.println();
        }
        System.out.println("----------------------------------------------------------------------------------------------");
    }

    public void tableOrderClient(long id){
        List<Order> order=RepoJpa.findCustomerOrder(id);
        System.out.printf("%5s %15s %23s %27s", "ID","BOUGHT DATE","TOTAL SUM","PRODUCTS");
        System.out.println();
        System.out.println("---------------------------------------------------------------------------------------------");
//iterates over the list
        for(Order orderr: order)
        {
            System.out.format("%5s %15s %20s %45s ", orderr.getId(), orderr.getBoughtDate(), orderr.getSum(),orderr.getProducts());
            System.out.println();
        }
        System.out.println("----------------------------------------------------------------------------------------------");
    }

    public void tableMakeupProducts(){
        List<Makeup> makeupList=RepoJpa.getMakeupList();
        System.out.printf("%5s %15s %23s ", "ID","PRODUCT","CATEGORY");
        System.out.println();
        System.out.println("---------------------------------------------------------------------------------------------");
        for(Makeup makeup: makeupList)
        {
            System.out.format("%5s %18s %20s ", makeup.getId(), makeup.getProduct(), makeup.getCategory());
            System.out.println();
        }
        System.out.println("----------------------------------------------------------------------------------------------");
    }

    public void tableSkincareProducts(){
        List<Skincare> makeupList=RepoJpa.getSkincareList();
        System.out.printf("%5s %23s %20s ", "ID","PRODUCT","SKIN TYPE");
        System.out.println();
        System.out.println("---------------------------------------------------------------------------------------------");
        for(Skincare makeup: makeupList)
        {
            System.out.format("%5s %25s %15s ", makeup.getId(), makeup.getProduct(), makeup.getSkinType());
            System.out.println();
        }
        System.out.println("----------------------------------------------------------------------------------------------");
    }

    public void tablePerfumeProducts(){
        List<Perfume> makeupList=RepoJpa.getPerfumeList();
        System.out.printf("%5s %25s %20s ", "ID","PRODUCT","SCENT");
        System.out.println();
        System.out.println("---------------------------------------------------------------------------------------------");
        for(Perfume makeup: makeupList)
        {
            System.out.format("%5s %30s %15s ", makeup.getId(), makeup.getProduct(), makeup.getScent());
            System.out.println();
        }
        System.out.println("----------------------------------------------------------------------------------------------");
    }


}
