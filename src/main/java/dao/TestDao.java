//package dao;
//
//
//import metier.entities.Produit;
//
//import java.util.List;
//
//public class TestDao {
//
//    public static void main(String[] args){
//        ProduitDaoImpl dao= new ProduitDaoImpl();
//        Produit p1 = dao.save(new Produit("HP 6580",900,45));
//        Produit p2 = dao.save(new Produit("Imprimante Espon 760",100,50));
//        System.out.println(p1.toString());
//        System.out.println(p2.toString());
//        System.out.println("chercher des produits");
//        List<Produit> prods = dao.produitsParMC("%H%");
//        for(Produit p:prods){
//            System.out.println(p.toString());
//        }
//
//
//    }
//}
