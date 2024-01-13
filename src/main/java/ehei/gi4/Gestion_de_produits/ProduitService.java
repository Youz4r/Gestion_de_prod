package ehei.gi4.Gestion_de_produits;

import java.util.HashMap;
import java.util.Map;
import java.util.NoSuchElementException;

public class ProduitService {
    Map<Long,Produit> produits = new HashMap<Long,Produit>();

    private void afficherProduit(Produit produit) {
        System.out.println(produit);
    }


    public void afficherTousProduits() {
        System.out.println("tous les produits :");
        for (Produit produit : produits.values()) {
            afficherProduit(produit);
        }
    }
    public void ajouterProduit(Produit produit) throws Exception {
        verifierUniciteEtValidite(produit);
        produits.put(produit.getId(), produit);
    }
    public void mettreAJourProduit(Produit produit) throws Exception {
        if (!produits.containsKey(produit.getId())) {
            throw new NoSuchElementException("Produit non trouvé pour l'ID : " + produit.getId());
        }
        verifierUniciteEtValidite(produit);
        produits.put(produit.getId(), produit);
    }
    public void supprimerProduit(Long id) {
        produits.remove(id);
    }
    private void verifierUniciteEtValidite(Produit produit) throws Exception {
        for (Produit p : produits.values()) {
            if (p.getId().equals(produit.getId()) || p.getNom().equals(produit.getNom())) {
                throw new Exception("Un produit avec le même ID ou nom existe déjà.");
            }
        }
        if (produit.getPrix() < 0 || produit.getQuantite() < 0) {
            throw new IllegalArgumentException("Le prix et la quantité doivent être positifs.");
        }
    }

    public Produit getProduit(long l ) {
        return this.produits.get(l);
    }
}
