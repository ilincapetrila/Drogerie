//import org.junit.Test;
//import java.util.List;
//
//public class AdminSystemTest {
//    Repository repo= new Repository();
//    Controller.AdminSystem admin= new Controller.AdminSystem();
//    @Test
//    public void sortByPriceMakeup() {
//        List<Model.Makeup> makeupList= repo.makeupList;
//        List <Model.Makeup> makeupListSorted = admin.sortByPriceMakeup();
//        boolean ok=true;
//        for(int i=0; i<makeupListSorted.size()-1; i++){
//            if (makeupListSorted.get(i).getPrice()>makeupListSorted.get(i+1).getPrice()){
//                ok=false;
//                break;
//            }
//        }
//        assert(ok);
//    }
//
//    @Test
//    public void filterByCategoryMakeup() {
//        List<Model.Makeup> makeupList= repo.makeupList;
//        List <Model.Makeup> makeupListFiltered = admin.filterByCategoryMakeup("eyes");
//        boolean ok=true;
//        for(int i=0; i<makeupListFiltered.size()-1; i++){
//            if(!makeupListFiltered.get(i).getCategory().equals("eyes")){
//                ok=false;
//                break;
//            }
//        }
//        assert(ok);
//    }
//
//    @Test
//    public void sortByPriceSkincare() {
//        List<Model.Skincare> skincareList= repo.skincareList;
//        List <Model.Skincare> skincareListSorted = admin.sortByPriceSkincare();
//        boolean ok=true;
//        for(int i=0; i<skincareListSorted.size()-1; i++){
//            if (skincareListSorted.get(i).getPrice()>skincareListSorted.get(i+1).getPrice()){
//                ok=false;
//                break;
//            }
//        }
//        assert(ok);
//    }
//
//    @Test
//    public void filterByCategorySkincare() {
//        List<Model.Skincare> skincareList= repo.skincareList;
//        List <Model.Skincare> skincareListFiltered = admin.filterByCategorySkincare("dry");
//        boolean ok=true;
//        for(int i=0; i<skincareListFiltered.size()-1; i++){
//            if (!skincareListFiltered.get(i).getSkinType().equals("dry")){
//                ok=false;
//                break;
//            }
//        }
//        assert(ok);
//    }
//
//    @Test
//    public void sortByPricePerfume() {
//        List<Model.Perfume> perfumeList= repo.perfumeList;
//        List <Model.Perfume> perfumeListSorted = admin.sortByPricePerfume();
//        boolean ok=true;
//        for(int i=0; i<perfumeListSorted.size()-1; i++){
//            if (perfumeListSorted.get(i).getPrice()>perfumeListSorted.get(i+1).getPrice()){
//                ok=false;
//                break;
//            }
//        }
//        assert(ok);
//    }
//
//    @Test
//    public void filterByCategoryPerfume() {
//        List<Model.Perfume> perfumeList= repo.perfumeList;
//        List <Model.Perfume> perfumeListFiltered = admin.filterByCategoryPerfume("sweet");
//        boolean ok=true;
//        for(int i=0; i<perfumeListFiltered.size()-1; i++){
//            if (!perfumeListFiltered.get(i).getScent().equals("sweet")){
//                ok=false;
//                break;
//            }
//        }
//        assert(ok);
//    }
//}