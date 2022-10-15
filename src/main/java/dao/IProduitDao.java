package dao;

import metier.entities.Produit;

import java.util.List;
// quand j'ai créé une interface je jeux le role d'un concepteur et gand j'ai créé une class je jeux le role d'un developeur
public interface IProduitDao {
    public Produit save(Produit p);
    public List<Produit> produitsParMC(String mc);
    public Produit getProduit(Long id);
    public Produit update(Produit p);
    public void deleteProduit(Long id);
}
