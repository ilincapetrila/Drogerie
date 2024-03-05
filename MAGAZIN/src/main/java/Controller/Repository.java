import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Scanner;

import org.hibernate.*;
import org.hibernate.graph.RootGraph;
import org.hibernate.procedure.ProcedureCall;
import org.hibernate.query.NativeQuery;
import org.hibernate.query.Query;
import org.hibernate.stat.SessionStatistics;
import org.junit.jupiter.api.Assertions;

import javax.persistence.*;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaDelete;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.CriteriaUpdate;
import javax.persistence.metamodel.Metamodel;
import java.io.Serializable;
import java.sql.Connection;
import java.util.*;

//public class Repository {
//    List <Model.Client> clientList= new ArrayList<>();
//    List<Model.Makeup> makeupList= new ArrayList<>();
//    List<Model.Skincare> skincareList= new ArrayList<>();
//    List <Model.Perfume> perfumeList = new ArrayList<>();

//    public Repository() {
//        populateMakeup();
//        populateSkincare();
//        populatePerfume();
//    }
//    void populateMakeup(){
//        makeupList.add(new Model.Makeup(275, "Eyeliner", "01.01.2024", 32, "eyes"));
//        makeupList.add(new Model.Makeup(381, "Concealer", "01.06.2024", 10, "face"));
//        makeupList.add(new Model.Makeup(292, "red Lipstick", "21.12.2024", 25, "lips"));
//        makeupList.add(new Model.Makeup(871, "blue Eyeshadow", "01.01.2025", 30, "eyes"));
//        makeupList.add(new Model.Makeup(124, "pink Lipstick", "21.12.2024", 25, "lips"));
//        makeupList.add(new Model.Makeup(413, "nude Eyeshadow", "01.01.2025", 30, "eyes"));
//    }
//    void populateSkincare(){
//        skincareList.add(new Model.Skincare(724, "Vitamin C Serum", "01.01.2024", 36, "normal"));
//        skincareList.add(new Model.Skincare(293, "Retinol", "21.12.2024", 40, "normal"));
//        skincareList.add(new Model.Skincare(613, "Face mask", "11.02.2023", 16, "normal"));
//        skincareList.add(new Model.Skincare(124, "Hyaluronic acid", "21.12.2023", 38, "normal"));
//        skincareList.add(new Model.Skincare(634, "Moisturiser", "18.06.2024", 36, "dry"));
//        skincareList.add(new Model.Skincare(263, "Cleanser", "29.03.2024", 27, "normal"));
//    }
//    void populatePerfume(){
//        perfumeList.add(new Model.Perfume(924, "La Vie est Belle", "21.12.2024", 498, "sweet"));
//        perfumeList.add(new Model.Perfume(835, "Kashmir", "21.12.2024", 103, "vanilla"));
//        perfumeList.add(new Model.Perfume(700, "Mugler", "21.12.2024", 269, "floral"));
//        perfumeList.add(new Model.Perfume(293, "Tom Ford Tabacco Vanille", "21.12.2024", 947, "tabac"));
//    }

//    /***
//     * Adds a makeup-product to the list of makeup
//     * @param makeup
//     */
//    void addMakeup(Model.Makeup makeup){
//        makeupList.add(makeup);
//    }
//     Model.Makeup searchMakeup(String name, int price){
//         for (Model.Makeup makeup: makeupList){
//             if(Objects.equals(makeup.getName(), name) & makeup.getPrice()==price){
//                 return makeup;
//             }
//         }
//         return null;
//     }
//
//    /**
//     *Deletes a makeup-product from the list of makeup
//     * @param name
//     */
//    void deleteMakeup(String name){
//        makeupList.removeIf(makeup -> Objects.equals(makeup.getName(), name));
//    }
//
//    /**
//     * Updates a makeup-product from the list of makeup
//     * @param name
//     * @param updateField
//     * @param newInfo
//     */
//    void updateMakeup(String name, int updateField, int newInfo){
//        Scanner in= new Scanner(System.in);
//        int index=0;
//        for(Model.Makeup makeup : makeupList){
//            if(makeup.getName().equals(name)){
//                index=makeupList.indexOf(makeup);
//                break;
//            }
//        }
//        if(updateField==1){
//            makeupList.get(index).setQuantity(newInfo);
//        }
//        else
//        if(updateField==2) {
//            makeupList.get(index).setPrice(newInfo);
//        }
//    }
//
//    /**
//     * Prints the list of makeup
//     */
//    void printMakeup(){
//        for (Model.Makeup makeup: makeupList){
//            System.out.println(makeup.toString());
//        }
//    }
//
//    /**
//     * Customers can return the products and the quantity of that product will be updated
//     * @param nameProduct
//     * @param quantity
//     */
//    void returnMakeup(String nameProduct, int quantity){
//        int index=0;
//        for(Model.Makeup makeup : makeupList){
//            if(makeup.getName().equals(nameProduct)){
//                index=makeupList.indexOf(makeup);
//                break;
//            }
//        }
//        makeupList.get(index).setQuantity(makeupList.get(index).getQuantity()+quantity);
//    }

//    /**
//     * Adds a client to the list of clients
//     * @param client
//     */
//    void addClient(Model.Client client){
//        clientList.add(client);
//    }
//
//    /**
//     * Deletes a client from the list of clients
//     * @param name
//     */
//    void deleteClient(String name){
//        clientList.removeIf(client -> Objects.equals(client.getLastName(),name));
//    }
//
//    /**
//     * Prints the list of clients
//     */
//    void printClient(){
//        for (Model.Client client:clientList){
//            System.out.println(client.toString());
//        }
//    }
//
//    /**
//     * Returns date of birth
//     * @param firstName
//     * @param lastName
//     * @return BDay
//     */
//    String getDateOfBirthClient(String firstName,String lastName){
//        for (Model.Client client:clientList){
//            if (Objects.equals(client.getFirstName(), firstName) & Objects.equals(client.getLastName(), lastName)){
//                return client.getDateOfBirth();
//        }}
//        return "no client";
//    }
//
//    /***
//     * Adds a skincare-product to the list of skincare
//     * @param skincare
//     */
//    void addSkincare(Model.Skincare skincare){
//        skincareList.add(skincare);
//    }
//
//    /***
//     * Deletes skincare by name
//     * @param name
//     */
//    void deleteSkincare(String name){
//        skincareList.removeIf(skincare -> Objects.equals(skincare.getName(), name));
//    }
//    Model.Skincare searchSkincare(String name, int price) {
//        for (Model.Skincare skincare: skincareList){
//            if(Objects.equals(skincare.getName(), name) & skincare.getPrice()==price){
//                return skincare;
//            }
//        }
//        return null;
//    }
//
//    /**
//     * Updates a skincare-product from the list of skincare
//     * @param name
//     * @param updateField
//     * @param newInfo
//     */
//    void updateSkincare(String name, int updateField, int newInfo){
//        Scanner in= new Scanner(System.in);
//        int index=0;
//        for(Model.Skincare skincare : skincareList){
//            if(skincare.getName().equals(name)){
//                index=skincareList.indexOf(skincare);
//                break;
//            }
//        }
//        if(updateField==1){
//            skincareList.get(index).setQuantity(newInfo);
//        }
//        else
//        if(updateField==2) {
//            skincareList.get(index).setPrice(newInfo);
//        }
//    }
//
//    /**
//     * Customers can return the products and the quantity of that product will be updated
//     * @param nameProduct
//     * @param quantity
//     */
//    void returnSkincare(String nameProduct, int quantity){
//        int index=0;
//        for(Model.Skincare skincare : skincareList){
//            if(skincare.getName().equals(nameProduct)){
//                index=skincareList.indexOf(skincare);
//                break;
//            }
//        }
//        skincareList.get(index).setQuantity(skincareList.get(index).getQuantity()+quantity);
//    }
//
//    /**
//     * Prints list of skincare products
//     */
//    void printSkincare(){
//        for( Model.Skincare skincare :skincareList){
//            System.out.println(skincare.toString());
//        }
//    }
//
//    /**
//     * Adds a perfume-product to the list of perfumes
//     * @param perfume
//     */
//    void addPerfume(Model.Perfume perfume){
//        perfumeList.add(perfume);
//    }
//
//    /**
//     * Deletes a perfume-product from the list of perfumes
//     * @param name
//     */
//    void deletePerfume(String name){
//        perfumeList.removeIf(perfume -> Objects.equals(perfume.getName(), name));
//    }
//
//    /**
//     * Searches for the specific perfume
//     * @param name
//     * @param price
//     * @return searched perfume
//     */
//    Model.Perfume searchPerfume(String name, int price) {
//        for (Model.Perfume perfume:perfumeList){
//
//            if(Objects.equals(perfume.getName(), name) & perfume.getPrice()==price){
//                return perfume;
//            }
//        }
//        return null;
//
//    }
//
//    /**
//     * Updates a perfume-product from the list of perfumes
//     * @param name
//     * @param updateField
//     * @param newInfo
//     */
//    void updatePerfume(String name, int updateField, int newInfo){
//        Scanner in= new Scanner(System.in);
//        int index=0;
//        for(Model.Perfume perfume : perfumeList){
//            if(perfume.getName().equals(name)){
//                index=perfumeList.indexOf(perfume);
//                break;
//            }
//        }
//        if(updateField==1){
//            perfumeList.get(index).setQuantity(newInfo);
//        }
//        else
//        if(updateField==2) {
//            perfumeList.get(index).setPrice(newInfo);
//        }
//    }
//
//    /**
//     * Customers can return the products and the quantity of that product will be updated
//     * @param nameProduct
//     * @param quantity
//     */
//    void returnPerfume(String nameProduct, int quantity){
//        int index=0;
//        for(Model.Perfume perfume : perfumeList){
//            if(perfume.getName().equals(nameProduct)){
//                index=perfumeList.indexOf(perfume);
//                break;
//            }
//        }
//        perfumeList.get(index).setQuantity(perfumeList.get(index).getQuantity()+quantity);
//    }
//
//    /**
//     * Prints list of perfumes
//     */
//    void printPerfume(){
//        for( Model.Perfume perfume :perfumeList){
//            System.out.println(perfume.toString());
//        }
//    }
//
//}
