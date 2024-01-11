package ehei.gi4.Gestion_de_produits;

public class ProduitService {
	private Map<Long, Produit> produits = new HashMap<>();
	 public void ajouterProduit(Produit produit) throws Exception {
	        verifierUniciteEtValidite(produit);
	        produits.put(produit.getId(), produit);
	    }

}
