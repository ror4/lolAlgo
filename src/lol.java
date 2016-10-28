/**
 * Created by Formation on 25/10/2016.
 */
import java.util.ArrayList;
import java.util.List;

public class lol {

    static final int TOP=0;
    static final int JUNGLE=4;
    static final int MID=1;
    static final int ADC=2;
    static final int SUPPORT=3;

    public static void main(String[] args) {

        List<String> champions_top = new ArrayList();
        List<String> champions_mid = new ArrayList();
        List<String> champions_adc = new ArrayList();
        List<String> champions_support = new ArrayList();
        List<String> champions_jungle = new ArrayList();

        champions_top.add("Rumble");
        champions_top.add("Kennen");
        champions_top.add("Griar");
        champions_top.add("Poppy");
        champions_top.add("Jayce");
        champions_top.add("Ekko");
        champions_jungle.add("Nidalee");
        champions_jungle.add("Graves");
        champions_jungle.add("Reksai");
        champions_jungle.add("Elise");
        champions_jungle.add("Lee Sin");
        champions_jungle.add("Olaf");
        champions_mid.add("Orianna");
        champions_mid.add("Syndra");
        champions_mid.add("Viktor");
        champions_mid.add("Ziggs");
        champions_mid.add("Ahri");
        champions_adc.add("Jhin");
        champions_adc.add("Ezreal");
        champions_adc.add("Jinx");
        champions_adc.add("Lucian");
        champions_adc.add("Tristana");
        champions_support.add("Karma");
        champions_support.add("Janna");
        champions_support.add("Zyra");
        champions_support.add("Tahm Kench");
        champions_support.add("Taric");
        champions_support.add("Alistar");
        champions_support.add("Nami");

        listeResultats(champions_top, champions_mid, champions_adc, champions_support, champions_jungle);
    }

    public static boolean test(List<Object> liste) {
        if(liste.size()>1) {
            if (liste.get(TOP).equals("Poppy") && liste.get(MID).equals("Ziggs"))
                return false;
        }
        if(liste.size()>2) {
            if (liste.get(TOP).equals("Poppy") && liste.get(MID).equals("Syndra") && liste.get(ADC).equals("Lucian"))
                return false;
            if (liste.get(TOP).equals("Rumble") && liste.get(MID).equals("Syndra") && liste.get(ADC).equals("Lucian"))
                return false;
            if (liste.get(TOP).equals("Kennen") && liste.get(MID).equals("Syndra") && liste.get(ADC).equals("Lucian"))
                return false;
            if (liste.get(TOP).equals("Ekko") && liste.get(MID).equals("Syndra") && liste.get(ADC).equals("Lucian"))
                return false;
        }
        if(liste.size()>3) {
            if (liste.get(ADC).equals("Jhin") && liste.get(SUPPORT).equals("Taric"))
                return false;
            if (liste.get(TOP).equals("Kennen") && liste.get(SUPPORT).equals("Janna"))
                return false;
        }
        if(liste.size()>4) {
            if (liste.get(SUPPORT).equals("Janna") && liste.get(JUNGLE).equals("Elise"))
                return false;
            if (liste.get(SUPPORT).equals("Janna") && liste.get(JUNGLE).equals("Zac"))
                return false;
            if (liste.get(SUPPORT).equals("Janna") && liste.get(JUNGLE).equals("Nunu"))
                return false;
            if (liste.get(ADC).equals("Jhin") && liste.get(JUNGLE).equals("Nunu"))
                return false;
            if (liste.get(MID).equals("Viktor") && liste.get(JUNGLE).equals("Reksai"))
                return false;
            if (liste.get(MID).equals("Orianna") && liste.get(JUNGLE).equals("Zac"))
                return false;
            if (liste.get(MID).equals("Orianna") && liste.get(JUNGLE).equals("Hecarim"))
                return false;
            if (liste.get(MID).equals("Ziggs") && liste.get(JUNGLE).equals("Reksai"))
                return false;
            if (liste.get(JUNGLE).equals("Kindred") && liste.get(MID).equals("Syndra") && liste.get(ADC).equals("Lucian"))
                return false;
        }
        return true;
    }

    public static List<List> listeResultats(List<String> champions_top, List<String> champions_mid,
                                      List<String> champions_adc, List<String> champions_support, List<String> champions_jungle) {

        List<List> listeResultat = new ArrayList();
        List<Object> liste_champions = new ArrayList();
        Integer j = 1;
        List<String> liste_top = new ArrayList();
        List<String> liste_mid = new ArrayList();
        List<String> liste_adc = new ArrayList();
        List<String> liste_support = new ArrayList();
        List<String> liste_jungle = new ArrayList();
        liste_top.addAll(champions_top);
        liste_mid.addAll(champions_mid);
        liste_adc.addAll(champions_adc);
        liste_support.addAll(champions_support);
        liste_jungle.addAll(champions_jungle);
        List<String> liste = new ArrayList();
        liste = liste_top;
        Integer res = 1;

        while (j < 6) {
            if (liste.size() > 0) {
                liste_champions.add(liste.get(0));
                liste.remove(0);
                if (test(liste_champions)) {
                    if (j == 5) {
                        System.out.print("Resultat " + res + " : ");
                        System.out.print(liste_champions.get(TOP) + "(top), ");
                        System.out.print(liste_champions.get(4) + "(jungle), ");
                        System.out.print(liste_champions.get(1) + "(mid), ");
                        System.out.print(liste_champions.get(2) + "(adc), ");
                        System.out.print(liste_champions.get(3) + "(support)");
                        System.out.println("");
                        listeResultat.add(liste_champions);
                        liste_champions.remove(4);
                        res = res + 1;
                    }
                    if (j == 4) {
                        liste = liste_jungle;
                        j = j + 1;
                    }
                    if (j == 3) {
                        liste = liste_support;
                        j = j + 1;
                    }
                    if (j == 2) {
                        liste = liste_adc;
                        j = j + 1;
                    }
                    if (j == 1) {
                        liste = liste_mid;
                        j = j + 1;
                    }
                } else {
                    liste_champions.remove(liste_champions.size() - 1);
                }
            } else {
                if (j == 1) {
                    System.out.println("fin");
                    j=6;
                } else {
                    liste_champions.remove(liste_champions.size() - 1);
                    j = j - 1;
                    if (j == 4) {
                        liste = liste_support;
                        liste_jungle.addAll(champions_jungle);
                    }
                    if (j == 3) {
                        liste = liste_adc;
                        liste_support.addAll(champions_support);
                    }
                    if (j == 2) {
                        liste = liste_mid;
                        liste_adc.addAll(champions_adc);
                    }
                    if (j == 1) {
                        liste = liste_top;
                        liste_mid.addAll(champions_mid);
                    }
                }
            }
        }
        return listeResultat;
    }
}
