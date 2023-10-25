public class Adherent extends Client {
    public int idAdherent;
    public int nbrDePointsFidel;
    static public int seuil=200;
    static public float rabais = 10;
    public Adherent(Panier panier) {
        super(panier);
        nbrDePointsFidel = 0;
    }
    public Adherent(ServiceMarket serviceMarket) {
        super(serviceMarket);
        nbrDePointsFidel = 0;
    }
    public Adherent(Client client) throws UnauthorizedActionException {
        super(client.getPanier());
        if(client.isMembrePersonnel()) {
            throw new UnauthorizedActionException("Un membre du personnel ne peut pas devenir adhérent.");
        }
    }
    @Override
    public float adherentRabais(int ptFidelite) {
        this.nbrDePointsFidel+=ptFidelite;
        if(nbrDePointsFidel<seuil) {
            return 0;
        } else {
            return rabais;
        }
    }
}
