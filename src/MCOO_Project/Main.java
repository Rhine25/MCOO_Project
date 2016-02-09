package MCOO_Project;

import java.util.ArrayList;

/**
 * Created by Célia Dehors & Benjamin Goodwin on 03/02/16.
 */
public class Main {

    public static void main(String[] args) {
        Etat un = new Etat("1", true, false);
        Etat deux = new Etat("2", false, true);
        Label label = new Label("a");
        Transition unTOdeux = new Transition(label, un, deux);
        ArrayList<Etat> etats = new ArrayList<>();
        etats.add(un);
        etats.add(deux);
        ArrayList<Transition> transitions = new ArrayList<>();
        transitions.add(unTOdeux);
        Automate a = new Automate(etats, transitions, un);
        System.out.println(a.toString());
    }
}
