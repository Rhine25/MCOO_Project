package MCOO_Project;

/**
 * Created by Célia Dehors & Benjamin Goodwin on 03/02/16.
 */
public class Transition {
    public Label etiquette;
    public Etat source;
    public Etat cible;

    public Transition(Label etiquette, Etat source, Etat cible) {
        this.etiquette = etiquette;
        this.source = source;
        this.cible = cible;
    }
}
