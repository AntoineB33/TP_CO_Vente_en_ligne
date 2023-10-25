import java.util.ArrayList;

public class OffreProduit extends OffreCommerciale{

    private ArrayList<Produit> produits;
    public OffreProduit(float reduc, ArrayList<Produit> produits) {
        super(reduc);
        this.produits = new ArrayList<Produit>();
        for(Produit produit : produits) {
            addProduit(produit);
        }
    }
    public OffreProduit(float reduc) {
        this(reduc, new ArrayList<Produit>());
    }
    public void addProduit(Produit produit) {
        if(!produits.contains(produit)) {
            produits.add(produit);
            produit.addOffreProduit(this);
        }
    }
}
