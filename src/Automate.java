import javafx.animation.Transition;

import java.util.ArrayList;

/**
 * Created by rhine on 03/02/16.
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

    public String toString(){ //TODO faire le caca

        return "";
    }

    @Override
    public Object accept(VisiteurTomate vt) {
        return vt.visit(this); //return ?
    }
}
