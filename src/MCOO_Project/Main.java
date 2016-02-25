package MCOO_Project;

import java.util.ArrayList;
import java.util.Scanner;

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
        Etat un;
        Etat deux;
        Etat trois;
        Etat quatre;

        //Terminaux
        Label a = new Label("a");
        Label b = new Label("b");
        Label c = new Label("c");

        String question="Quelles type d'automate voulez-vous ?"+
                "\n (1) Automate Valide" +
                "\n (2) Automate avec deux etats initiaux" +
                "\n (3) Automate avec Etat puits sans final" +
                "\n (4) Automate avec Etat Final non accesible" +
                "\n (5) Automate avec Automate non deterministe" +
                "\n (6) Automate avec Etat possedant le meme nom";
        Scanner sc = new Scanner(System.in);
        System.out.println(question);
        String res = sc.nextLine();
        Automate auto;
        Object o;
        boolean choiceOK = false;
        while (!choiceOK) {
            switch (res) {
                case "1":
                    choiceOK = true;

                    //Etats
                    un = createState("1", "initial", etats);
                    deux = createState("2", etats);
                    trois = createState("3", etats);
                    quatre = createState("4","final", etats);

                    //Transitions
                    Transition unTOdeux1 = createTransition(a, un, deux, transitions);
                    Transition deuxTOtrois1 = createTransition(b, deux, trois, transitions);
                    Transition troisTOtrois1 = createTransition(a, trois, trois, transitions);
                    Transition troisTOquatre1 = createTransition(c, trois, quatre, transitions);
                    Transition quatreTOdeux1 = createTransition(a, quatre, deux, transitions);
                    Transition deuxTOquatre1 = createTransition(c, deux, quatre, transitions);

                    //Automate
                    auto = createAutomate(etats, transitions, un);

                    o = auto.accept(Validateur.getINSTANCE());
                    System.out.println("Erreur(s) : " + o);

                    auto.accept(Executeur.getINSTANCE());
                    break;
                case "2":
                    choiceOK = true;
                    //Etats
                    un = createState("1", "initial", etats);
                    deux = createState("2", "initial", etats);
                    trois = createState("3", "final", etats);

                    //Transitions
                    Transition unTOdeux2 = createTransition(a, un, deux, transitions);
                    Transition deuxTOtrois2 = createTransition(b, deux, trois, transitions);

                    //Automate
                    auto = createAutomate(etats, transitions, un);

                    o = auto.accept(Validateur.getINSTANCE());
                    System.out.println("Erreur(s) : " + o);

                    auto.accept(Executeur.getINSTANCE());
                    break;
                case "3":
                    choiceOK = true;
                    //Etats
                    un = createState("1", "initial", etats);
                    deux = createState("2", etats);
                    trois = createState("3", "final", etats);

                    //Transitions
                    Transition unTOdeux3 = createTransition(a, un, deux, transitions);
                    Transition unTOtrois3 = createTransition(b, un, trois, transitions);

                    //Automate
                    auto = createAutomate(etats, transitions, un);

                    o = auto.accept(Validateur.getINSTANCE());
                    System.out.println("Erreur(s) : " + o);

                    auto.accept(Executeur.getINSTANCE());
                    break;
                case "4":
                    choiceOK = true;
                    //Etats
                    un = createState("1", "initial", etats);
                    deux = createState("2", etats);
                    trois = createState("3", "final", etats);

                    //Transitions
                    Transition unTOdeux4 = createTransition(a, un, deux, transitions);
                    Transition deuxTOtrois4 = createTransition(b, deux, trois, transitions);

                    //Automate
                    auto = createAutomate(etats, transitions, un);

                    o = auto.accept(Validateur.getINSTANCE());
                    System.out.println("Erreur(s) : " + o);

                    auto.accept(Executeur.getINSTANCE());
                    break;
                case "5":
                    choiceOK = true;
                    //Etats
                    un = createState("1", "initial", etats);
                    deux = createState("2", etats);
                    trois = createState("3", etats);
                    quatre = createState("4","final", etats);

                    //Transitions
                    Transition unTOdeux5 = createTransition(a, un, deux, transitions);
                    Transition unTOtrois5 = createTransition(a, un, trois, transitions);
                    Transition deuxTOquatre5 = createTransition(b, deux, quatre, transitions);
                    Transition troisTOquatre5 = createTransition(c, trois, quatre, transitions);

                    //Automate
                    auto = createAutomate(etats, transitions, un);

                    o = auto.accept(Validateur.getINSTANCE());
                    System.out.println("Erreur(s) : " + o);

                    auto.accept(Executeur.getINSTANCE());
                    break;
                case "6":
                    choiceOK = true;
                    //Etats
                    un = createState("1", "initial", etats);
                    deux = createState("1", etats);
                    trois = createState("3", "final", etats);

                    //Transitions
                    Transition unTOdeux = createTransition(a, un, deux, transitions);
                    Transition deuxTOtrois = createTransition(b, deux, trois, transitions);

                    //Automate
                    auto = createAutomate(etats, transitions, un);

                    o = auto.accept(Validateur.getINSTANCE());
                    System.out.println("Erreur(s) : " + o);

                    auto.accept(Executeur.getINSTANCE());
                    break;
                default :
                    System.out.println(question);
                    res = sc.nextLine();
            }
        }
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
