import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by Formation on 02/11/2016.
 */
public class testPoolChampions {

    List<Top> topListe = new LinkedList<>();
    List<Jungle> jglListe = new LinkedList<>();
    List<Mid> midListe = new LinkedList<>();
    List<Adc> adcListe = new LinkedList<>();
    List<Support> supportList = new LinkedList<>();

    public LinkedList<LinkedList<? extends Champion>> getList(){
        LinkedList<LinkedList<? extends Champion>> l = new LinkedList<>();
        l.add((LinkedList<? extends Champion>) topListe);
        l.add((LinkedList<? extends Champion>)jglListe);
        l.add((LinkedList<? extends Champion>)midListe);
        l.add((LinkedList<? extends Champion>)adcListe);
        l.add((LinkedList<? extends Champion>)supportList);
        return l;
    }
}
