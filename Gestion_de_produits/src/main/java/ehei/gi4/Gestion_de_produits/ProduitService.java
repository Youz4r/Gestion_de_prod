package ehei.gi4.Gestion_de_produits;
import java.util.*;

public class ProduitService {
	private Map<Long, Produit> produits = new HashMap<>();
	 public void ajouterProduit(Produit produit) throws Exception {
	        produits.put(produit.getId(), produit);
	    }

}
