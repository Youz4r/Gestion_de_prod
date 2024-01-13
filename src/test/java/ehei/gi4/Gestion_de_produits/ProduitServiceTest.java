package ehei.gi4.Gestion_de_produits;

import org.junit.Before;
import org.junit.Test;

import java.util.NoSuchElementException;

import static org.junit.Assert.*;

public class ProduitServiceTest {

    private ProduitService produitService;

    @Before
    public void setUp() {
        produitService = new ProduitService();
    }

    @Test
    public void testAjouterProduit() throws Exception {
        Produit produit = new Produit(1L, "Produit1", 10.0, 5);
        produitService.ajouterProduit(produit);

        assertEquals(produit, produitService.getProduit(1L));
    }

    @Test(expected = Exception.class)
    public void testAjouterProduitAvecDuplication() throws Exception {
        Produit produit1 = new Produit(1L, "Produit1", 10.0, 5);
        Produit produit2 = new Produit(1L, "Produit2", 20.0, 10);

        produitService.ajouterProduit(produit1);
        produitService.ajouterProduit(produit2);
    }

    @Test
    public void testMettreAJourProduit() throws Exception {
        Produit produit = new Produit(1L, "Produit1", 10.0, 5);
        produitService.ajouterProduit(produit);

        produit.setPrix(20.0);
        produitService.mettreAJourProduit(produit);

        Produit updatedProduit = produitService.getProduit(1L);
        assertEquals(20.0, updatedProduit.getPrix(), 0.001);
    }

    @Test(expected = NoSuchElementException.class)
    public void testMettreAJourProduitNonExistant() throws Exception {
        Produit produit = new Produit(1L, "Produit1", 10.0, 5);
        produitService.mettreAJourProduit(produit);
    }

    @Test
    public void testSupprimerProduit() throws Exception {
        Produit produit = new Produit(1L, "Produit1", 10.0, 5);
        produitService.ajouterProduit(produit);
        produitService.supprimerProduit(1L);

        assertNull(produitService.getProduit(1L));
    }

}
