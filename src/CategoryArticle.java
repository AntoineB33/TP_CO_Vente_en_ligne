import java.util.ArrayList;

public class CategoryArticle extends Produit {
    private ArrayList<Article> articles;
    public CategoryArticle(ArrayList<Article> articles) {
        super();
        this.articles = new ArrayList<Article>();
        for(Article article : articles) {
            addArticle(article);
        }
    }
    public CategoryArticle() {
        this(new ArrayList<Article>());
    }
    public void addArticle(Article article) {
        if(!articles.contains(article)) {
            articles.add(article);
            article.addCategorie(this);
        }
    }
}
