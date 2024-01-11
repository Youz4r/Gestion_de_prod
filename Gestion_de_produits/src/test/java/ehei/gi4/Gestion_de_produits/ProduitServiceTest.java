package ehei.gi4.Gestion_de_produits;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

import java.util.NoSuchElementException;

public class ProduitServiceTest {
    private ProduitService produitService;
    private Produit produit;

    @Before
    public void setUp() {
        produitService = new ProduitService();
        produit = new Produit(1L, "ProduitTest", 100.0, 10);
    }

    @Test
    public void testAjouterProduit() throws Exception {
        produitService.ajouterProduit(produit);
        assertNotNull(produitService.obtenirProduit(produit.getId()));
    }

    @Test(expected = Exception.class)
    public void testAjouterProduitAvecDuplication() throws Exception {
        produitService.ajouterProduit(produit);
        produitService.ajouterProduit(produit); 
    }

    @Test
    public void testObtenirProduit() throws Exception {
        produitService.ajouterProduit(produit);
        Produit retrieved = produitService.obtenirProduit(produit.getId());
        assertEquals(produit, retrieved);
    }

    @Test
    public void testMettreAJourProduit() throws Exception {
        produitService.ajouterProduit(produit);
        produit.setPrix(200.0);
        produitService.mettreAJourProduit(produit);
        Produit updated = produitService.obtenirProduit(produit.getId());
        assertEquals(200.0, updated.getPrix(), 0.0);
    }

    @Test(expected = NoSuchElementException.class)
    public void testMettreAJourProduitInexistant() throws Exception {
        produitService.mettreAJourProduit(produit); 
    }

    @Test
    public void testSupprimerProduit() throws Exception {
        produitService.ajouterProduit(produit);
        produitService.supprimerProduit(produit.getId());
        assertNull(produitService.obtenirProduit(produit.getId()));
    }

}
