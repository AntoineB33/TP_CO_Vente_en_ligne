import java.util.ArrayList;

public class ServiceMarket {
    private ArrayList<Alerte> alertes;
    private ArrayList<OffreFlash> offresFlash;

    public ServiceMarket(ArrayList<Alerte> alertes, ArrayList<OffreFlash> offresFlash) {
        this.alertes = new ArrayList<>();
        for(Alerte alerte : alertes) {
            addAlert(alerte);
        }
        this.offresFlash = new ArrayList<>();
        for(OffreFlash offreFlash : offresFlash) {
            addOffreFalsh(offreFlash);
        }
    }
    public ServiceMarket() {
        this(new ArrayList<Alerte>(), new ArrayList<OffreFlash>());
    }

    public void addAlert(Alerte alert) {
        if(!alertes.contains(alert)) {
            alertes.add(alert);
        }
    }
    public void addOffreFalsh(OffreFlash offreFlash) {
        if(!offresFlash.contains(offreFlash)) {
            offresFlash.add(offreFlash);
        }
    }

    public boolean removeAlert(Alerte alert) {
        if(alertes.contains(alert)) {
            alertes.remove(alert);
            return true;
        }
        return false;
    }
    public boolean removeOffreFlash(OffreFlash offreFlash) {
        if(offresFlash.contains(offreFlash)) {
            offresFlash.remove(offreFlash);
            return true;
        }
        return false;
    }
    public void activerAlerte(Panier panier) {
        for (Alerte alerte : alertes) {
            alerte.activerAlerte(panier);
        }
    }
    public float getOffresFlashReduc(ArrayList<ArticleQuantity> articlesQuantities) {
        float reduc = 0;
        for(OffreFlash offreFlash : offresFlash) {
            reduc += offreFlash.getReduc(articlesQuantities);
        }
        return reduc;
    }
    public ArticleQuantity getOneMissingArticle(ArrayList<ArticleQuantity> panier) {
        for(OffreFlash offreFlash : offresFlash) {
            ArrayList<ArticleQuantity> missings = offreFlash.getMissingArticles(panier);
            if (missings.size() == 1) {
                return missings.get(0);
            }
        }
        return null;
    }
}
