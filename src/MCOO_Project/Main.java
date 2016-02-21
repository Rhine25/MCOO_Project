package MCOO_Project;

import java.util.ArrayList;

/**
 * Created by Célia Dehors & Benjamin Goodwin on 03/02/16.
 */
public class Main {

    public static void main(String[] args) {
        //TODO méthodes pour créer un automate facilement
        //TODO plusieurs automates précréés avec options pour lequel créer
        //TODO trier les transitions par nom d'état source

        //Etats
        Etat un = new Etat("1", true, false, new ArrayList<Automate>(), new ArrayList<Transition>(), new ArrayList<Transition>());
        Etat deux = new Etat("2", false, false, new ArrayList<Automate>(), new ArrayList<Transition>(), new ArrayList<Transition>());
        Etat trois = new Etat("3", false, false, new ArrayList<Automate>(), new ArrayList<Transition>(), new ArrayList<Transition>());
        Etat quatre = new Etat("4", false, true, new ArrayList<Automate>(), new ArrayList<Transition>(), new ArrayList<Transition>());
        Etat cinq = new Etat("5", false, false, new ArrayList<Automate>(), new ArrayList<Transition>(), new ArrayList<Transition>());

        //Transition
        Label labela = new Label("a");
        Label labelb = new Label("b");
        Label labelc = new Label("c");

        Transition unTOdeux = new Transition(labela, un, deux);
        un.departing.add(unTOdeux);
        deux.incoming.add(unTOdeux);

        Transition deuxTOtrois = new Transition(labela, deux, trois);
        deux.departing.add(deuxTOtrois);
        trois.incoming.add(deuxTOtrois);

        Transition troisTOun = new Transition(labela, trois, un);
        trois.departing.add(troisTOun);
        un.incoming.add(troisTOun);

        Transition quatreTOquatre = new Transition(labela, quatre, quatre);
        quatre.departing.add(quatreTOquatre);
        quatre.incoming.add(quatreTOquatre);

        Transition troisTOquatre = new Transition(labelb, trois, quatre);
        trois.departing.add(troisTOquatre);
        quatre.incoming.add(troisTOquatre);

        Transition troisTOcinq = new Transition(labelc, trois, cinq);
        trois.departing.add(troisTOcinq);
        cinq.incoming.add(troisTOcinq);

        Transition cinqTOquatre = new Transition(labela, cinq, quatre);
        cinq.departing.add(cinqTOquatre);
        quatre.incoming.add(cinqTOquatre);


        //Automate
            //ses etats
        ArrayList<Etat> etats = new ArrayList<>();
        etats.add(un);
        etats.add(deux);
        etats.add(trois);
        etats.add(quatre);
        etats.add(cinq);
            //ses transitions
        ArrayList<Transition> transitions = new ArrayList<>();
        transitions.add(unTOdeux);
        transitions.add(deuxTOtrois);
        transitions.add(troisTOun);
        transitions.add(quatreTOquatre);
        transitions.add(troisTOquatre);
        transitions.add(troisTOcinq);
        transitions.add(cinqTOquatre);
        //transitions.sort();


        Automate a = new Automate(etats, transitions, un);

        Object o = a.accept(Validateur.getINSTANCE());
        System.out.println("Erreur(s) : " + o);

        a.accept(Executeur.getINSTANCE());
    }
}
