package MCOO_Project;
import java.util.ArrayList;
import java.util.Iterator;

/**
 * Created by Célia Dehors & Benjamin Goodwin on 03/02/16.
 */
public class Automate implements Tomate {
    public ArrayList<Etat> etats; //TODO exactly one initial state
    public ArrayList<Transition> transitions;
    public Etat activeState;

    public Automate(ArrayList<Etat> etats, ArrayList<Transition> transitions, Etat currentState) {
        this.etats = etats;
        this.transitions = transitions;
        this.activeState = currentState;
    }


    public void ajouterEtat(Etat e){
        this.etats.add(e);
    }

    public void ajouterTransition(Transition t){
        this.transitions.add(t);
    }

    @Override
    public String toString(){
        //TODO afficher l'etat actif
        String res="";
        Iterator iterator = etats.iterator();
        if(iterator.hasNext()) {
            res += "Etat(s) : ";
        }
        while(iterator.hasNext()){
            Etat tmp = (Etat)iterator.next();
            res += tmp.nom;
            if(iterator.hasNext()) {
                res += ", ";
            }else{
                res += ".\n";
            }
        }
        iterator = transitions.iterator();
        while(iterator.hasNext()){
            Transition tmp = (Transition)iterator.next();
            res += "Transitions de l'état : '" + tmp.source.nom + "' à l'état : '" + tmp.cible.nom + "' with the letter '"
                    + tmp.etiquette.etiquette + "'\n";
        }
        return res;
    }

    @Override
    public Object accept(VisiteurTomate vt) {
        return vt.visit(this); //return ?
    }
}
