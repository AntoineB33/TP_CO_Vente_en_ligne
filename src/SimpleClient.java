public class SimpleClient extends Client{
    public SimpleClient(Panier panier) {
        super(panier);
    }
    public SimpleClient(ServiceMarket serviceMarket) {
        super(serviceMarket);
    }
    @Override
    public boolean isSimpleClient() {return true;}
}
