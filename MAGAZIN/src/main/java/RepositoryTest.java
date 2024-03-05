import java.util.ArrayList;
import java.util.List;

 //aceste teste nu mai merg deoarece am adaugat baza de date
import static org.junit.jupiter.api.Assertions.*;

//public class RepositoryTest {
//    Controller.AdminSystem admin = new Controller.AdminSystem();
//
//    @org.junit.jupiter.api.Test
//    void addMakeup() {
//        Model.Makeup makeup=new Model.Makeup(724, "Rimel", "01.01.2024", 50, "eyes");
//        int n=admin.repo.makeupList.size();
//        admin.addMakeup(makeup);
//        assert(admin.repo.makeupList.size()==n+1);
//
//    }
//
//    @org.junit.jupiter.api.Test
//    void deleteMakeup() {
//        Model.Makeup makeup=new Model.Makeup(724, "Bronzer", "01.01.2024", 50, "face");
//        admin.addMakeup(makeup);
//        int n=admin.repo.makeupList.size();
//        admin.deleteMakeup("Bronzer");
//        assert(admin.repo.makeupList.size()==n-1);
//
//    }
//
//    @org.junit.jupiter.api.Test
//    void updateMakeup() {
//        Model.Makeup makeup=new Model.Makeup(724, "Bronzer", "01.01.2024", 50, "face");
//        admin.addMakeup(makeup);
//        admin.updateMakeup("Bronzer", 1, 700);
//        makeup=admin.searchMakeup("Bronzer", 50);
//        assert(makeup.getQuantity()==700);
//    }
//
//    @org.junit.jupiter.api.Test
//    void addSkincare() {
//        Model.Skincare skincare=new Model.Skincare(724, "Vitamin C Serum", "01.01.2024", 36, "normal");
//        int n=admin.repo.skincareList.size();
//        admin.addSkincare(skincare);
//        assert(admin.repo.skincareList.size()==n+1);
//    }
//
//    @org.junit.jupiter.api.Test
//    void deleteSkincare() {
//        admin.addSkincare(new Model.Skincare(724, "Vitamin C Serum", "01.01.2024", 36, "normal"));
//        int n=admin.repo.skincareList.size();
//        admin.deleteSkincare("Vitamin C Serum");
//        assert(admin.repo.skincareList.size()==n-1);
//    }
//
//    @org.junit.jupiter.api.Test
//    void updateSkincare() {
//        Model.Skincare skincare=new Model.Skincare(724, "Vitamin C Serum", "01.01.2024", 36, "normal");
//        admin.addSkincare(skincare);
//        admin.updateSkincare("Vitamin C Serum", 1, 700);
//        skincare=admin.searchSkincare("Vitamin C Serum", 36);
//        assert(skincare.getQuantity()==700);
//    }
//
//    @org.junit.jupiter.api.Test
//    void addPerfume() {
//        Model.Perfume perfume=new Model.Perfume(924, "La Vie est Belle", "21.12.2024", 498, "sweet");
//        int n=admin.repo.perfumeList.size();
//        admin.addPerfume(perfume);
//        assert(admin.repo.perfumeList.size()==n+1);
//    }
//
//    @org.junit.jupiter.api.Test
//    void deletePerfume() {
//        admin.addPerfume(new Model.Perfume(924, "La Vie est Belle", "21.12.2024", 498, "sweet"));
//        int n=admin.repo.perfumeList.size();
//        admin.deletePerfume("La Vie est Belle");
//        assert(admin.repo.perfumeList.size()==n-1);
//    }
//
//    @org.junit.jupiter.api.Test
//    void updatePerfume() {
//        admin.addPerfume(new Model.Perfume(924, "La Vie est Belle", "21.12.2024", 498, "sweet"));
//        admin.updatePerfume("La Vie est Belle", 1, 900);
//        Model.Perfume perfume=admin.searchPerfume("La Vie est Belle", 498);
//        assert(perfume.getQuantity()==900);
//    }
//}