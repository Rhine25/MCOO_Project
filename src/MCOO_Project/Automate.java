package MCOO_Project;
import java.util.ArrayList;
import java.util.Iterator;

/**
 * Created by Célia Dehors & Benjamin Goodwin on 03/02/16.
 */
public class Automate implements Tomate {
    public ArrayList<Etat> etats;
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
        String res="";
        Iterator iterator = etats.iterator();
        if(iterator.hasNext()) {
            res += "Etat(s) : \n";
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
        res += "Transitions : \n";
        while(iterator.hasNext()){
            Transition tmp = (Transition)iterator.next();
            res += tmp.source.nom + " " + tmp.etiquette.etiquette + "-> "+tmp.cible.nom+"\n";
        }
        res += "Etat Actif : "+activeState.nom+"\n";
        return res;
    }

    @Override
    public Object accept(VisiteurTomate vt) {
        return vt.visit(this); //return ?
    }

    public boolean initialiser(){
        //On sait pas
        return false;
    }
}