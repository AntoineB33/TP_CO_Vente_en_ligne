import java.util.ArrayList;

public class OffreFlash extends OffreCommerciale{
    private ArrayList<ArticleQuantity> combinaison;
    public OffreFlash(float reduc, ArrayList<ArticleQuantity> combinaisons) {
        super(reduc);
        this.combinaison = combinaisons;
    }
    public OffreFlash(float reduc) {
        this(reduc, new ArrayList<ArticleQuantity>());
    }
    public void addCategorie(ArticleQuantity articleQuantity) {
        this.combinaison.add(articleQuantity);
    }
    public float getReduc(ArrayList<ArticleQuantity> articlesQuantities) {
        int nbReduc = 0;
        for(ArticleQuantity articleQuantity : combinaison) {
            for(ArticleQuantity articleQuantityPanier : articlesQuantities) {
                if(articleQuantityPanier.getProduct() == articleQuantity.getProduct()) {
                    int newNbReduc = articleQuantity.getQuantity()/articleQuantityPanier.getQuantity();
                    if(newNbReduc==0) {
                        return 0;
                    } else if(newNbReduc<nbReduc) {
                        nbReduc = newNbReduc;
                    }
                }
            }
        }
        return nbReduc * reductionFixe;
    }
    public ArrayList<ArticleQuantity> getMissingArticles(ArrayList<ArticleQuantity> panier) {
        ArrayList<ArticleQuantity> missing = new ArrayList<ArticleQuantity>();
        for(ArticleQuantity element : combinaison) {
            boolean loop = true;
            for(ArticleQuantity article : panier) {
                if (article.getProduct() == element.getProduct()) {
                    int lack = element.getQuantity() - article.getQuantity();
                    if(lack>0) {
                        missing.add(new ArticleQuantity(article.getProduct(), lack));
                    }
                    loop = false;
                    break;
                }
            }
            if(loop) {
                missing.add(new ArticleQuantity(element.getProduct(), element.getQuantity()));
            }
        }
        return missing;
    }
}
