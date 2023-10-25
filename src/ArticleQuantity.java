public class ArticleQuantity {
    private Article article; // Référence à l'article
    private int quantity;    // Quantité associée

    public ArticleQuantity(Article article, int quantity) {
        this.article = article;
        this.quantity = quantity;
    }

    public Article getProduct() {
        return article;
    }

    public int getQuantity() {
        return quantity;
    }
    public void addQuantity(int quantity) {
        this.quantity += quantity;
    }
}
