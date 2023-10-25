abstract public class Client {
    private Panier panier;
    public Client(Panier panier) {
        this.panier = panier;
    }
    public Client(ServiceMarket serviceMarket) {
        Panier panier = new Panier(serviceMarket, this);
        this.panier = panier;
    }
    public void addProduit(Article a,Integer q){
        panier.addPanier(a,q);
    }
    public double payer() {return panier.payer();}
    public Panier getPanier() {return panier;}
    public boolean isSimpleClient() {return false;}
    public boolean isMembrePersonnel() {return false;}
    public float membreReduc(Article article) {
        return 1;
    }
    public float adherentRabais(int ptFidelite) {return 0;}
    public SimpleClient deconnexion(){
        return new SimpleClient(getPanier());
    }
}
