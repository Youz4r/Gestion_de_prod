package ehei.gi4.Gestion_de_produits;

import java.util.HashMap;
import java.util.Map;

public class ProduitService {
    Map<Long,Produit> produits = new HashMap<Long,Produit>();

    // afficher un seul produit
    private void afficherProduit(Produit produit) {
        System.out.println(produit);
    }

    // afficher tous les produits
    public void afficherTousProduits() {
        System.out.println("tous les produits :");
        for (Produit produit : produits.values()) {
            afficherProduit(produit);
        }
    }
}
