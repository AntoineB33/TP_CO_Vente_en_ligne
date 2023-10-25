public class MembrePersonnel extends Client{
    public MembrePersonnel(Panier panier) {
        super(panier);
    }
    public MembrePersonnel(ServiceMarket serviceMarket) {
        super(serviceMarket);
    }
    @Override
    public float membreReduc(Article article) {
        return 100 - article.getTauxReducPersonnel() / 100;
    }
    @Override
    public boolean isMembrePersonnel() {return true;}
}
