package MCOO_Project;

import java.util.ArrayList;
import java.util.Iterator;

/**
 * Created by Célia Dehors & Benjamin Goodwin on 03/02/16.
 */
public class Validateur implements VisiteurTomate{
    private static Validateur INSTANCE = null;

    private ArrayList<String> errors;

    public Validateur() {
        this.errors = new ArrayList<>();
    }

    public synchronized static Validateur getINSTANCE(){
        if(INSTANCE == null){
            INSTANCE = new Validateur();
        }
        return INSTANCE;
    }

    public Object visit(Automate a){

        int c = 0;
        int nbInitial = 0;
        Iterator<Etat> i = a.etats.iterator();
        while(i.hasNext()){

            System.out.println("c : " + c);
            c ++;

            Etat tmp = i.next();

            //checking single initial state
            if(tmp.initial) {
                nbInitial++;
            }
            //checking at least one incoming transition if non initial
            else{
                if(tmp.incoming.isEmpty()){
                    errors.add("Etat non accessible et non initial");
                }
            }

            //checking final if no departing transition
            if(tmp.departing.isEmpty() && !tmp.finalState){
                errors.add("Etat puits non final");
            }

            Iterator<Etat> i2 = a.etats.iterator();
            while(i2.next() != tmp){
                //catching up i
            }
            while (i2.hasNext()){
                Etat tmp2 = i2.next();

                //checking name duplicates
                if(tmp2.nom.compareTo(tmp.nom) == 0){
                    errors.add("Deux etats ont le nom " + tmp.nom);
                }
            }

            Iterator<Transition> it = tmp.departing.iterator();
            while(it.hasNext()){
                Transition tmpTransition = it.next();
                Iterator<Transition> it2 = it;
                while(it2.hasNext()){
                    Transition tmpTransition2 = it2.next();
                    //checking determinism
                    if(tmpTransition2.etiquette == tmpTransition.etiquette){
                        errors.add("Non déterministe");
                    }
                }
            }
        }

        if(nbInitial < 1){
            errors.add("Il n'y a pas d'état initial");
        }
        else if(nbInitial > 1){
            errors.add("Il y a trop d'états initiaux");
        }

        //return a.accept(this);
        return errors;
    }

    public Object visit(Etat e){
        return e;
    }
}
