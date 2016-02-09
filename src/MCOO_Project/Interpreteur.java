package MCOO_Project;

/**
 * Created by Célia Dehors & Benjamin Goodwin on 03/02/16.
 */
public class Interpreteur implements VisiteurTomate{
    private static Interpreteur INSTANCE = null;

    private Interpreteur(){
    }

    public synchronized static Interpreteur getINSTANCE(){
        if(INSTANCE == null){
            INSTANCE = new Interpreteur();
        }
        return INSTANCE;
    }

    public Object visit(Automate a){
        return a.accept(this); //?
    }

    @Override
    public Object visit(Etat e){
        //TODO
        return null;
    }
}
