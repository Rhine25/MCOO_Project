package MCOO_Project;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;

/**
 * Created by rhine on 19/02/16.
 */
public class Executeur implements VisiteurTomate{

    private static Executeur INSTANCE = null;

    private Executeur(){

    }

    public synchronized static Executeur getINSTANCE(){
        if(INSTANCE == null){
            INSTANCE = new Executeur();
        }
        return INSTANCE;
    }

    public Object visit(Automate a){
        Scanner sc = new Scanner(System.in);
        Iterator<Transition> i = a.activeState.departing.iterator();

        Transition tmp;
        boolean transitionPassed = false;
        boolean wrongChoice = true;
        while(!transitionPassed) {
            if (i.hasNext()) {
                System.out.println(a.toString());
                System.out.println("Transitions disponibles :\n" + a.activeState + "\nQuelle transition prendre ? : ");
                tmp = i.next();
                String str = "";
                while (i.hasNext() && !tmp.etiquette.etiquette.equals(str)) {
                    tmp = i.next();
                }
                while (wrongChoice) {
                    str = sc.nextLine();
                    if (tmp.etiquette.etiquette.equals(str)) {
                        a.activeState = tmp.cible;
                        wrongChoice = false;
                    } else {
                        System.out.println("La transition que vous avez demandée n'existe pas. Transitions disponibles :\n" + a.activeState + "\nRefaites un choix : ");
                    }
                }
            } else {
                System.out.println("Vous êtes sur un état final");
            }
        }
        return true;
    }

    public Object visit(Etat e){
        return e;
    }
}
