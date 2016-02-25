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
        String str;
        Iterator<Transition> i = a.activeState.departing.iterator();
        Transition tmp;

        while(!a.activeState.finalState){ //TODO gérer si des transitions sont possibles à partir de l'état final
            System.out.println(a);
            System.out.println("Transitions disponibles :\n" + a.activeState + "\nQuelle transition prendre ? : ");
            str = sc.nextLine();
            tmp = i.next();
            while(!tmp.etiquette.etiquette.equals(str)){
                if(i.hasNext()){
                    tmp = i.next();
                }
                else{ //transition asked for didn't exist
                    System.out.println("Veuillez choisir une transition existante parmis : " + a.activeState + "\n");
                    str = sc.nextLine();
                    i = a.activeState.departing.iterator();
                }
            }
            a.activeState = tmp.cible;
            i = a.activeState.departing.iterator();
        }
        System.out.println("Vous etes arriver sur un etat final");
        return true;
    }

    public Object visit(Etat e){
        return e;
    }
}
