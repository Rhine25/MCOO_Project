import java.util.ArrayList;

/**
 * Created by rhine on 03/02/16.
 */
public class Etat implements Tomate {
    public String nom;
    public boolean initial;
    public boolean finalState;
    public Automate automate;
    public ArrayList<Automate> sousAutomates;
    //TODO? automate dont je suis actif

    public Etat(String nom, boolean initial, boolean finalState, Automate automate, ArrayList<Automate> sousAutomates) {
        this.nom = nom;
        this.initial = initial;
        this.finalState = finalState;
        this.automate = automate;
        this.sousAutomates = sousAutomates;
    }

    public void ajouterSousAutomate(Automate a){
        this.sousAutomates.add(a);
    }

    @Override
    public Object accept(VisiteurTomate vt) {
        return vt.visit(this); //return ?
    }
}
