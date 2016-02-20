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
        boolean b = false;
        //TODO check string entered corresponde à transition existante ou if str == tmp etiquette après le while pour changer d'actif
        while(!b) {
            if (i.hasNext()) {
                System.out.println("Transitions disponibles :\n" + a.activeState + "\nQuelle transition prendre ? : ");
                String str = "";
                str = sc.nextLine();
                tmp = i.next();
                while (i.hasNext() && !tmp.etiquette.etiquette.equals(str)) {
                    tmp = i.next();
                }
                if (tmp.etiquette.etiquette.equals(str)) {
                    a.activeState = tmp.cible;
                    b = true;
                }
                else {
                    System.out.println("La transition que vous avez demandée n'existe pas. Transitions disponibles :\n" + a.activeState + "\nRefaites un choix : ");
                }
            } else {
                System.out.println("Vous êtes sur un état final");
            }
        }
        return true;
        //TODO check string entered corresponde à transition existante
    }

    public Object visit(Etat e){
        return e;
    }
}
