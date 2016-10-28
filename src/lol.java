/**
 * Created by Formation on 25/10/2016.
 */
import javafx.print.Collation;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

public class lol {

    static final int TOP=0;
    static final int JUNGLE=4;
    static final int MID=1;
    static final int ADC=2;
    static final int SUPPORT=3;
    static List<Top> tops = new ArrayList();
    static List<Mid> mids = new ArrayList();
    static List<Adc> adcs = new ArrayList();
    static List<Support> supports = new ArrayList();
    static List<Jungle> junglers = new ArrayList();
    static PoolChampions poolChampions = new PoolChampions();

    public static void main(String[] args) {

        initializeValues();
        afficherResultat(poolChampions);
    }

    private static void initializeValues() {

        tops.add(new Top("Rumble"));
        tops.add(new Top("Kennen"));
        tops.add(new Top("Gnar"));
        tops.add(new Top("Poppy"));
        tops.add(new Top("Jayce"));
        tops.add(new Top("Ekko"));
        junglers.add(new Jungle("Nidalee"));
        junglers.add(new Jungle("Graves"));
        junglers.add(new Jungle("Reksai"));
        junglers.add(new Jungle("Elise"));
        junglers.add(new Jungle("Lee Sin"));
        junglers.add(new Jungle("Olaf"));
        mids.add(new Mid("Orianna"));
        mids.add(new Mid("Syndra"));
        mids.add(new Mid("Viktor"));
        mids.add(new Mid("Ziggs"));
        mids.add(new Mid("Ahri"));
        adcs.add(new Adc("Jhin"));
        adcs.add(new Adc("Ezreal"));
        adcs.add(new Adc("Jinx"));
        adcs.add(new Adc("Lucian"));
        adcs.add(new Adc("Tristana"));
        supports.add(new Support("Karma"));
        supports.add(new Support("Janna"));
        supports.add(new Support("Zyra"));
        supports.add(new Support("Tahm Kench"));
        supports.add(new Support("Taric"));
        supports.add(new Support("Alistar"));
        supports.add(new Support("Nami"));

        //on ajoute tout dans la pool
        poolChampions.topListe= tops;
        poolChampions.jglListe= junglers;
        poolChampions.midListe= mids;
        poolChampions.adcListe= adcs;
        poolChampions.supportList= supports;
    }

    public static boolean test(List<Champion> liste) {
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

    public static void afficherResultat(PoolChampions listechampions){

        List<Top> listeTop = new ArrayList();
        listeTop.addAll(tops);
        List<Mid> listeMid = new ArrayList();
        listeMid.addAll(mids);
        List<Adc> listeAdc = new ArrayList();
        listeAdc.addAll(adcs);
        List<Support> listeSupport = new ArrayList();
        listeSupport.addAll(supports);
        List<Jungle> listeJungle = new ArrayList();
        listeJungle.addAll(junglers);
        LinkedList<Champion> listeChampions = new LinkedList<>();
        LinkedList<Champion> listeTemp = new LinkedList<>();
        int j =1;
        int res =1;
        listeTemp.addAll(listeTop);
        List<List> listeComboPossible= new ArrayList<>();

        while (j < 6) {
            if (listeTemp.size() > 0) {
                Champion champManipule = listeTemp.pollFirst();
                listeChampions.add(champManipule);
                if (test(listeChampions)) {
                    switch (j) {
                        case 5:
                            System.out.print("Resultat " + res + " : ");
                            System.out.print(listeChampions.get(TOP).name + "(top), ");
                            System.out.print(listeChampions.get(JUNGLE).name + "(jungle), ");
                            System.out.print(listeChampions.get(MID).name + "(mid), ");
                            System.out.print(listeChampions.get(ADC).name + "(adc), ");
                            System.out.print(listeChampions.get(SUPPORT).name + "(support)");
                            System.out.println("");
                            listeComboPossible.add(listeChampions);
                            listeChampions.removeLast();
                            res = res + 1;
                            break;
                        case 4:
                            listeTemp.clear();
                            listeSupport.remove(champManipule);
                            listeTemp.addAll(listeJungle);
                            j = j + 1;
                            break;
                        case 3:
                            listeTemp.clear();
                            listeAdc.remove(champManipule);
                            listeTemp.addAll(listeSupport);
                            j = j + 1;
                            break;
                        case 2:
                            listeTemp.clear();
                            listeMid.remove(champManipule);
                            listeTemp.addAll(listeAdc);
                            j = j + 1;
                            break;
                        case 1:
                            listeTemp.clear();
                            listeTop.remove(champManipule);
                            listeTemp.addAll(listeMid);
                            j = j + 1;
                            break;
                    }
                }
                else {
                    listeChampions.removeLast();
                }
            }
            else {
                if (j == 1) {
                    System.out.println("fin");
                    j=6;
                }
                else {
                    listeChampions.removeLast();
                    j = j - 1;
                    switch (j) {
                        case 4:
                            listeTemp.clear();
                            listeTemp.addAll(listeSupport);
                            break;
                        case 3:
                            listeTemp.clear();
                            listeSupport.addAll(supports);
                            listeTemp.addAll(listeAdc);
                            break;
                        case 2:
                            listeTemp.clear();
                            listeAdc.addAll(adcs);
                            listeTemp.addAll(listeMid);
                            break;
                        case 1:
                            listeTemp.clear();
                            listeMid.addAll(mids);
                            listeTemp.addAll(listeTop);
                            break;
                    }
//                    System.out.println(listeTemp.get(0).name);
//                    if(true){return ;}
                }
            }
        }
        return ;
    }


//    public static List<List> listeResultats(List<String> champions_top, List<String> champions_mid,
//                                      List<String> champions_adc, List<String> champions_support, List<String> champions_jungle) {
//
//        List<List> listeResultat = new ArrayList();
//        List<Object> liste_champions = new ArrayList();
//        Integer j = 1;
//        List<String> liste_top = new ArrayList();
//        List<String> liste_mid = new ArrayList();
//        List<String> liste_adc = new ArrayList();
//        List<String> liste_support = new ArrayList();
//        List<String> liste_jungle = new ArrayList();
//        liste_top.addAll(champions_top);
//        liste_mid.addAll(champions_mid);
//        liste_adc.addAll(champions_adc);
//        liste_support.addAll(champions_support);
//        liste_jungle.addAll(champions_jungle);
//        List<String> liste = new ArrayList();
//        liste = liste_top;
//        Integer res = 1;
//
//        while (j < 6) {
//            if (liste.size() > 0) {
//                liste_champions.add(liste.get(0));
//                liste.remove(0);
//                if (test(liste_champions)) {
//                    if (j == 5) {
//                        System.out.print("Resultat " + res + " : ");
//                        System.out.print(liste_champions.get(TOP) + "(top), ");
//                        System.out.print(liste_champions.get(JUNGLE) + "(jungle), ");
//                        System.out.print(liste_champions.get(MID) + "(mid), ");
//                        System.out.print(liste_champions.get(ADC) + "(adc), ");
//                        System.out.print(liste_champions.get(SUPPORT) + "(support)");
//                        System.out.println("");
//                        listeResultat.add(liste_champions);
//                        liste_champions.remove(4);
//                        res = res + 1;
//                    }
//                    if (j == 4) {
//                        liste = liste_jungle;
//                        j = j + 1;
//                    }
//                    if (j == 3) {
//                        liste = liste_support;
//                        j = j + 1;
//                    }
//                    if (j == 2) {
//                        liste = liste_adc;
//                        j = j + 1;
//                    }
//                    if (j == 1) {
//                        liste = liste_mid;
//                        j = j + 1;
//                    }
//                } else {
//                    liste_champions.remove(liste_champions.size() - 1);
//                }
//            } else {
//                if (j == 1) {
//                    System.out.println("fin");
//                    j=6;
//                } else {
//                    liste_champions.remove(liste_champions.size() - 1);
//                    j = j - 1;
//                    if (j == 4) {
//                        liste = liste_support;
//                        liste_jungle.addAll(champions_jungle);
//                    }
//                    if (j == 3) {
//                        liste = liste_adc;
//                        liste_support.addAll(champions_support);
//                    }
//                    if (j == 2) {
//                        liste = liste_mid;
//                        liste_adc.addAll(champions_adc);
//                    }
//                    if (j == 1) {
//                        liste = liste_top;
//                        liste_mid.addAll(champions_mid);
//                    }
//                }
//            }
//        }
//        return listeResultat;
//    }
}
