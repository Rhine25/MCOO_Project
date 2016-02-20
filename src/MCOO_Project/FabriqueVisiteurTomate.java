package MCOO_Project;

/**
 * Created by rhine on 20/02/16.
 */
public class FabriqueVisiteurTomate {
    public VisiteurTomate getVisiteurTomate(String typeVisiteur) throws CreationException{
        if(typeVisiteur.equals("Validateur")){
            return Validateur.getINSTANCE();
        }
        else if(typeVisiteur.equals("Executeur")){
            return Executeur.getINSTANCE();
        }
        else{
            throw new CreationException("Impossible de créer un visiteur de type " + typeVisiteur);
        }
    }
}
