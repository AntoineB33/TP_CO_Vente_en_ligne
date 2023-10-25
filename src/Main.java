// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {
    public static void main(String[] args) {
        System.out.println("Connexion de client1");
        ServiceMarket serviceMarket = new ServiceMarket();
        serviceMarket.addAlert(new Alerte(
                panier -> {
                    if(panier.isSimpleClient() && panier.getTotalPrice() > 100.0) {
                        System.out.println("Votre panier dépasse 100 euros alors que vous êtes simple client.");
                    };
                }
        ));
        Alerte missingOneAlert = new Alerte(
                panier -> {
                    ArticleQuantity articleQuantity = panier.getOneMissingArticle();
                    if(articleQuantity != null) {
                        System.out.println("Il vous manque "+articleQuantity.getQuantity()+" fois "+
                                articleQuantity.getProduct()+" pour bénéficier d'une offre flash.");
                    }
                }
        );
        CategoryArticle livre = new CategoryArticle();
        Article laCiboulette = new Article("La ciboulette",10,1,2);
        laCiboulette.addOffreProduit(new OffreProduit(4));
        livre.addArticle(laCiboulette);
        Article TV = new Article("TV",100,10,3);
        Client client1 = new SimpleClient(serviceMarket);
        System.out.println("Client1 ajoute livre dans son panier.");
        client1.addProduit(laCiboulette, 2);
        double prix = client1.payer();
        System.out.println("Client1 doit payer "+prix+" euros.");
        client1.addProduit(TV, 1);
    }
}