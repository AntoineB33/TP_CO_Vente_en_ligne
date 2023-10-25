import java.util.ArrayList;
public class Alerte {
    private AlerteFunction alerteFunction;
    private String message;

    public Alerte(AlerteFunction alerteFunction) {
        this.alerteFunction = alerteFunction;
    }

    public void activerAlerte(Panier panier) {
        alerteFunction.test(panier);
    }
}
