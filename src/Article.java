import java.util.ArrayList;

public class Article extends Produit{
    private ArrayList<CategoryArticle> categories;
    private double prix;
    private String nom;
    private int nbrPointFidel;
    private float tauxReducPersonnel;
    //taux de réduction pour les membres du personnel en pourcentage (e.g 50 pour 50% de réduction)
    public Article(String nom, double prix, int ptf, float tauxReducPersonnel, ArrayList<CategoryArticle> categories, ArrayList<OffreProduit> offreProduits) {
        super(offreProduits);
        this.nom=nom;
        this.nbrPointFidel=ptf;
        this.prix=prix;
        this.tauxReducPersonnel = tauxReducPersonnel;
        this.categories = new ArrayList<CategoryArticle>();
        for(CategoryArticle categoryArticle : categories) {
            addCategorie(categoryArticle);
        }
    }
    public Article(String nom, double prix, int ptf, float tauxReducPersonnel){
        this(nom, prix, ptf, tauxReducPersonnel, new ArrayList<CategoryArticle>(), new ArrayList<OffreProduit>());
    }
    public void setPrix(float p){
        this.prix=p;
    }
    @Override
    public float getReduc() {
        float reduc = super.getReduc();
        for(CategoryArticle categorie : categories) {
            reduc += categorie.getReduc();
        }
        return reduc;
    }
    public double getPrix(){
        return this.prix - getReduc();
    }
    public void setNbrPointFidel(int ptf){
        this.nbrPointFidel=ptf;
    }
    public int getNbrPointFidel(){
        return nbrPointFidel;
    }
    public float getTauxReducPersonnel(){
        return tauxReducPersonnel;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getNom() {
        return nom;
    }

    public void addCategorie(CategoryArticle categoryArticle) {
        if(!categories.contains(categoryArticle)) {
            categories.add(categoryArticle);
            categoryArticle.addArticle(this);
        }
    }
}
