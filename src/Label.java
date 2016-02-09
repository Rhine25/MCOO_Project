import java.util.ArrayList;

/**
 * Created by rhine on 03/02/16.
 */
public class Label {
    public String etiquette;
    public ArrayList<Transition> labeledTransitions;

    public Label(String etiquette, ArrayList<Transition> labeledTransitions) {
        this.etiquette = etiquette;
        this.labeledTransitions = labeledTransitions;
    }
}
