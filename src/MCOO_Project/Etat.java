package MCOO_Project;
import java.util.ArrayList;
import java.util.Iterator;

/**
 * Created by Célia Dehors & Benjamin Goodwin on 03/02/16.
 */
public class Etat implements Tomate {
    public String nom;
    public boolean initial;
    public boolean finalState;
    public Automate automate;
    public ArrayList<Automate> sousAutomates;
    public ArrayList<Transition> incoming;
    public ArrayList<Transition> departing;

    //TODO? automate dont je suis actif


    public Etat(String nom, boolean initial, boolean finalState, Automate automate, ArrayList<Automate> sousAutomates, ArrayList<Transition> incoming, ArrayList<Transition> departing) {
        this.nom = nom;
        this.initial = initial;
        this.finalState = finalState;
        this.automate = automate;
        this.sousAutomates = sousAutomates;
        this.incoming = incoming;
        this.departing = departing;
    }
    public Etat(String nom, boolean initial, boolean finalState, ArrayList<Automate> sousAutomates, ArrayList<Transition> incoming, ArrayList<Transition> departing) {
        this.nom = nom;
        this.initial = initial;
        this.finalState = finalState;
        this.sousAutomates = sousAutomates;
        this.incoming = incoming;
        this.departing = departing;
    }

    public Etat(String nom, boolean initial, boolean finalState, Automate automate) {
        this.nom = nom;
        this.initial = initial;
        this.finalState = finalState;
        this.automate = automate;
    }

    public Etat(String nom, boolean initial, boolean finalState) {
        this.nom = nom;
        this.initial = initial;
        this.finalState = finalState;

    }

    public Etat(Automate automate, ArrayList<Automate> sousAutomates) {
        this.automate=automate;
        this.sousAutomates = sousAutomates;
    }

    public void ajouterSousAutomate(Automate a){
        this.sousAutomates.add(a);
    }

    @Override
    public Object accept(VisiteurTomate vt) {
        return vt.visit(this); //return ?
    }

    public String toString(){

        String s = "";
        Iterator<Transition> i = departing.iterator();
        while(i.hasNext()){
            Transition tmp = i.next();
            s += tmp.etiquette + "->" + tmp.cible.nom + "\n";
        }
        return s;
    }
}
