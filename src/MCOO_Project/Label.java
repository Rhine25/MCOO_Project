package MCOO_Project;
import java.util.ArrayList;

/**
 * Created by Célia Dehors & Benjamin Goodwin on 03/02/16.
 */
public class Label {
    public String etiquette;
    public ArrayList<Transition> labeledTransitions;

    public Label(String etiquette, ArrayList<Transition> labeledTransitions) {
        this.etiquette = etiquette;
        this.labeledTransitions = labeledTransitions;
    }

    public Label(String etiquette) {
        this.etiquette = etiquette;
    }

    public String toString(){
        return etiquette;
    }
}
