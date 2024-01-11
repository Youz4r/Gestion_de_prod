package ehei.gi4.Gestion_de_produits;
import java.util.*;

public class ProduitService {
    private Map<Long, Produit> produits = new HashMap<>();

    public void ajouterProduit(Produit produit) throws Exception {
        verifierUniciteEtValidite(produit);
        produits.put(produit.getId(), produit);
    }

    public Produit obtenirProduit(Long id) {
        return produits.get(id);
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
}

