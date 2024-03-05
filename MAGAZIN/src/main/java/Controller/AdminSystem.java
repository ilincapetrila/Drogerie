package Controller;

//import java.util.*;
//
public class AdminSystem {
}

//
//    Repository repo = new Repository();
//
//    void addClient(Model.Client client) {
//        repo.addClient(client);
//    }
//
//    void printClient() {
//        repo.printClient();
//    }
//
//    String getBirthDate(String firstName, String lastName) {
//        return repo.getDateOfBirthClient(firstName, lastName);
//    }
//
//    void addMakeup(Model.Makeup makeup) {
//        repo.addMakeup(makeup);
//    }
//
//    void deleteMakeup(String name) {
//        repo.deleteMakeup(name);
//    }
//    void returnMakeup(String nameProduct, int quantity){repo.returnMakeup(nameProduct, quantity);}
//
//    Model.Makeup searchMakeup(String name, int price) {
//        return repo.searchMakeup(name, price);
//    }
//
//    /**
//     * Sorts list of makeup by price
//     * @return sorted makeup list
//     */
//    List <Model.Makeup> sortByPriceMakeup( ) {
//        List <Model.Makeup> makeupList=repo.makeupList;
////        makeupList.sort(Comparator.comparing(Model.Makeup::getPrice));
//        return makeupList;
//    }
//
//    /**
//     * Filters list of makeup by category
//     * @param category
//     * @return filtered makeup list
//     */
//    List<Model.Makeup> filterByCategoryMakeup(String category){
//        List<Model.Makeup> newMakeupList=new ArrayList<Model.Makeup>();
//        for(Model.Makeup makeup:repo.makeupList){
//            if(makeup.getCategory().equals(category)){
//                newMakeupList.add(makeup);
//            }
//        }
//        return newMakeupList;
//    }
//
//    void updateMakeup(String name, int updateField, int newInfo) {repo.updateMakeup(name, updateField, newInfo);}
//    void addSkincare(Model.Skincare skincare) {
//        repo.addSkincare(skincare);
//    }
//
//    void deleteSkincare(String name) {
//        repo.deleteSkincare(name);
//    }
//
//    Model.Skincare searchSkincare(String name, int price) {
//        return repo.searchSkincare(name,price);
//    }
//
//    void updateSkincare(String name, int updateField, int newInfo) {repo.updateSkincare(name, updateField, newInfo);}
//    void returnSkincare(String nameProduct, int quantity){repo.returnMakeup(nameProduct, quantity);}
//
//    /**
//     * Sorts list of skincare by price
//     * @return sorted skincare list
//     */
//    List <Model.Skincare> sortByPriceSkincare( ) {
//        List <Model.Skincare> skincareList=repo.skincareList;
//        skincareList.sort(Comparator.comparing(Model.Skincare::getPrice));
//        return skincareList;
//    }
//
//    /**
//     * Filters list of skincare by cateory
//     * @param category
//     * @return filtered skincare list
//     */
//    List<Model.Skincare> filterByCategorySkincare(String category){
//        List<Model.Skincare> newSkincareList=new ArrayList<Model.Skincare>();
//        for(Model.Skincare skincare:repo.skincareList){
//            if(skincare.getSkinType().equals(category)){
//                newSkincareList.add(skincare);
//            }
//        }
//        return newSkincareList;
//    }
//    void addPerfume(Model.Perfume perfume) {
//        repo.addPerfume(perfume);
//    }
//
//    void deletePerfume(String name) {
//        repo.deletePerfume(name);
//    }
//
//   Model.Perfume searchPerfume(String name, int price) {
//        return repo.searchPerfume(name,price);
//    }
//
//    void updatePerfume(String name, int updateField, int newInfo) {repo.updatePerfume(name, updateField, newInfo);}
//
//    /**
//     * Sorts list of perfumes by price
//     * @return sorted perfume list
//     */
//    List <Model.Perfume> sortByPricePerfume( ) {
//        List <Model.Perfume> perfumeList=repo.perfumeList;
//        perfumeList.sort(Comparator.comparing(Model.Perfume::getPrice));
//        return perfumeList;
//    }
//
//    /**
//     * Filters list of perfumes by category
//     * @param category
//     * @return filtered perfume list
//     */
//    List<Model.Perfume> filterByCategoryPerfume(String category){
//        List<Model.Perfume> newPerfumeList=new ArrayList<Model.Perfume>();
//        for(Model.Perfume perfume:repo.perfumeList){
//            if(perfume.getScent().equals(category)){
//                newPerfumeList.add(perfume);
//            }
//        }
//        return newPerfumeList;
//    }
//    void returnPerfume(String nameProduct, int quantity){repo.returnMakeup(nameProduct, quantity);}
//    void printMakeup() {
//        repo.printMakeup();
//    }
//
//    void printSkincare() {
//        repo.printSkincare();
//    }
//
//    void printPerfume() {
//        repo.printPerfume();
//    }
//}
//
//
//
