import java.util.ArrayList;

abstract public class Produit {
    private ArrayList<OffreProduit> offresProduit;
    public Produit(ArrayList<OffreProduit> offresProduit) {
        this.offresProduit = new ArrayList<OffreProduit>();
        for(OffreProduit offreProduit : offresProduit) {
            addOffreProduit(offreProduit);
        }
    }
    public Produit() {
        this(new ArrayList<OffreProduit>());
    }
    public void addOffreProduit(OffreProduit offreProduit) {
        if(!offresProduit.contains(offreProduit)) {
            offresProduit.add(offreProduit);
            offreProduit.addProduit(this);
        }
    }
    public float getReduc() {
        float reduc = 0;
        for(OffreProduit offreProduit : offresProduit) {
            reduc += offreProduit.getReduc();
        }
        return reduc;
    }
}
