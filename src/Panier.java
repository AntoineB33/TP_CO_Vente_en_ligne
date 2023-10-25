import java.util.ArrayList;

public class Panier{
    private ArrayList<ArticleQuantity> articlesQuantities;
    private Client client;
    private ServiceMarket serviceMarket;
    public Panier(ServiceMarket serviceMarket, Client client) {
        this.serviceMarket = serviceMarket;
        this.client = client;
        articlesQuantities = new ArrayList<ArticleQuantity>();
    }
    public ArrayList<ArticleQuantity> getArticlesQuantities() {
        return articlesQuantities;
    }
    public void addPanier(Article a,int q){
        boolean found = false;
        for (ArticleQuantity articleQuantity : articlesQuantities) {
            if(articleQuantity.getProduct()==a) {
                articleQuantity.addQuantity(q);
                found = true;
                break;
            }
        }
        if(!found) {
            articlesQuantities.add(new ArticleQuantity(a, q));
        }
        serviceMarket.activerAlerte(this);
    }
    public double getTotalPrice(){
        double total = 0.0;
        for (ArticleQuantity articleQuantity : articlesQuantities) {
            Article article = articleQuantity.getProduct();
            double itemPrice = article.getPrix();
            itemPrice *= client.membreReduc(article);
            itemPrice -= client.adherentRabais(article.getNbrPointFidel());
            total += itemPrice * articleQuantity.getQuantity();
        }
        return Math.max(0,total-serviceMarket.getOffresFlashReduc(articlesQuantities));
    }
    public double payer() {
        double price = getTotalPrice();
        articlesQuantities = new ArrayList<ArticleQuantity>();
        return price;
    }
    public boolean isSimpleClient() {
        return client.isSimpleClient();
    }

    public ArticleQuantity getOneMissingArticle() {
        return serviceMarket.getOneMissingArticle(articlesQuantities);
    }
}
