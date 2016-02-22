package MCOO_Project;

import java.util.ArrayList;

/**
 * Created by Célia Dehors & Benjamin Goodwin on 03/02/16.
 */
public class Main {

    public static void main(String[] args) {
        //TODO plusieurs automates précréés avec options pour lequel créer
        //TODO trier les transitions par nom d'état source

        ArrayList<Etat> etats = new ArrayList<>();
        ArrayList<Transition> transitions = new ArrayList<>();

        //Etats
        Etat un = createState("1", "initial", etats);
        Etat deux = createState("2", etats);
        Etat trois = createState("3", etats);
        Etat quatre = createState("4","final", etats);
        Etat cinq = createState("5", etats);

        //Terminaux
        Label a = new Label("a");
        Label b = new Label("b");
        Label c = new Label("c");

        //Transitions
        Transition unTOdeux = createTransition(a, un, deux, transitions);
        Transition deuxTOtrois = createTransition(a, deux, trois, transitions);
        Transition troisTOun = createTransition(a, trois, un, transitions);
        Transition quatreTOquatre = createTransition(a, quatre, quatre, transitions);
        Transition troisTOquatre = createTransition(b, trois, quatre, transitions);
        Transition troisTOcinq = createTransition(c, trois, cinq, transitions);
        Transition cinqTOquatre = createTransition(a, cinq, quatre, transitions);

        //Automate
        Automate auto = createAutomate(etats, transitions, un);

        Object o = auto.accept(Validateur.getINSTANCE());
        System.out.println("Erreur(s) : " + o);

        auto.accept(Executeur.getINSTANCE());
    }

    private static Etat createState(String nom, ArrayList<Etat> etats){
        return createState(nom, "", etats);
    }
    private static Etat createState(String nom, String iniFin, ArrayList<Etat> etats){
        Etat etat;
        if(iniFin.equals("initial")){
            etat = new Etat(nom, true, false, new ArrayList<Automate>(), new ArrayList<Transition>(), new ArrayList<Transition>());
        }
        else if(iniFin.equals("final")){
            etat =  new Etat(nom, false, true, new ArrayList<Automate>(), new ArrayList<Transition>(), new ArrayList<Transition>());
        }
        else if(iniFin.equals("initial final")){
            etat =  new Etat(nom, true, true, new ArrayList<Automate>(), new ArrayList<Transition>(), new ArrayList<Transition>());
        }
        else{
            etat = new Etat(nom, false, false, new ArrayList<Automate>(), new ArrayList<Transition>(), new ArrayList<Transition>());
        }
        etats.add(etat);
        return etat;
    }

    private static Transition createTransition(Label label, Etat source, Etat cible, ArrayList<Transition> transitions){
        Transition transition = new Transition(label, source, cible);
        source.departing.add(transition);
        cible.incoming.add(transition);
        transitions.add(transition);
        return transition;
    }

    private static Automate createAutomate(ArrayList<Etat> etats, ArrayList<Transition> transitions, Etat activeState){
        return new Automate(etats, transitions, activeState);
    }
}
