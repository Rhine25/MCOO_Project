package MCOO_Project;

import java.util.ArrayList;

/**
 * Created by Célia Dehors & Benjamin Goodwin on 03/02/16.
 */
public class Main {

    public static void main(String[] args) {

        //Etats
        Etat un = new Etat("1", true, false, new ArrayList<Automate>(), new ArrayList<Transition>(), new ArrayList<Transition>());
        Etat deux = new Etat("2", false, true, new ArrayList<Automate>(), new ArrayList<Transition>(), new ArrayList<Transition>());

        //Transition
        Label label = new Label("a");
        Transition unTOdeux = new Transition(label, un, deux);

        un.departing.add(unTOdeux);
        deux.incoming.add(unTOdeux);

        //Automate
            //ses etats
        ArrayList<Etat> etats = new ArrayList<>();
        etats.add(un);
        etats.add(deux);
            //ses transitions
        ArrayList<Transition> transitions = new ArrayList<>();
        transitions.add(unTOdeux);

        Automate a = new Automate(etats, transitions, un);



        Object o = a.accept(new Validateur());
        System.out.println(o);
    }
}
