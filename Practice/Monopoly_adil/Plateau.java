//package net.guillaume.teaching.refactoring.monopoly;
//
//import java.util.ArrayList;
//
//public class Plateau {
//
//
//    private  Case depart;
//    private  CaseSpeciale luxe;
//    private  CaseSpeciale impot;
//    private  CaseSpeciale prison;
//    private  CaseSpeciale allerenprison;
//
//    public  CaseConstructible bellevile;
//    public  CaseConstructible lecourbe;
//    public  CaseConstructible vaugirard;
//    public  CaseConstructible courcelles;
//    public  CaseConstructible republique;
//    public  CaseConstructible neuilly;
//    public  CaseConstructible villette;
//    public  CaseConstructible paradis;
//    public  CaseConstructible mozart;
//    public  CaseConstructible stmichel;
//    public  CaseConstructible pigalle;
//    public  CaseConstructible malesherbes;
//    public  CaseConstructible matignon;
//    public  CaseConstructible henrimartin;
//    public  CaseConstructible bourse;
//    public  CaseConstructible sthonore;
//    public  CaseConstructible fayette;
//    public  CaseConstructible foch;
//    public  CaseConstructible breteuil;
//    public  CaseConstructible capucines;
//    public  CaseConstructible champs;
//    public  CaseConstructible paix;
//    public  CaseConstructible garemontparnasse;
//    public  CaseConstructible garedelyon;
//    public  CaseConstructible garedunord;
//    public  CaseConstructible garesaintlazard;
//    private ArrayList<CaseConstructible> caseSansProprietaire = new ArrayList<>();
//
//    public Plateau(){
//        creerLesCases();
//        creerLesCasesSuivantes();
//        genererListeCaseSansProprietaire();
//    }
//
//    public Case getDepart() {
//        return depart;
//    }
//
//    public CaseSpeciale getLuxe() {
//        return luxe;
//    }
//
//    public CaseSpeciale getImpot() {
//        return impot;
//    }
//
//    public CaseSpeciale getPrison() {
//        return prison;
//    }
//
//    public CaseSpeciale getAllerEnPrison() {
//        return allerenprison;
//    }
//
//    public ArrayList<CaseConstructible> getCaseSansProprietaire() {
//        return caseSansProprietaire;
//    }
//
//
//
//
//    private void creerLesCases(){
//        depart = new CaseSpeciale("Depart");
//        bellevile = new CaseConstructible("Boulevard de Bellevile", 20, 2,"v");
//        lecourbe = new CaseConstructible("Rue Lecourbe", 40, 4, "v");
//        vaugirard = new CaseConstructible("Rue Vaugirard", 60, 6,"b");
//        courcelles = new CaseConstructible("Rue De Courcelles", 60, 6,"b");
//        republique = new CaseConstructible("Avenue de la Republique", 80, 8,"b");
//        neuilly = new CaseConstructible("Avenue de Neuilly", 100, 10,"p");
//        villette = new CaseConstructible("Boulevard de la Villette", 100, 10,"p");
//        paradis = new CaseConstructible("Rue de Paradis", 120, 12,"p");
//        mozart = new CaseConstructible("Avenue Mozart", 140, 14,"o");
//        stmichel = new CaseConstructible("Boulevard St Michel", 140, 14,"o");
//        pigalle = new CaseConstructible("Place Pigalle", 160, 16,"o");
//        malesherbes = new CaseConstructible("Boulevard Malesherbes", 180, 18,"r");
//        matignon = new CaseConstructible("Avenue Matignon", 180, 18,"r");
//        henrimartin = new CaseConstructible("Avenue Henri Martin", 200, 20,"r");
//        bourse = new CaseConstructible("Place de la Bourse", 220, 22,"j");
//        sthonore = new CaseConstructible("Faubourg St Honore", 220, 20,"j");
//        fayette = new CaseConstructible("Rue de la Fayette", 240, 24,"j");
//        foch = new CaseConstructible("Avenue Foch", 260, 26,"w");
//        breteuil = new CaseConstructible("Avenue de Breteuil", 260, 26,"w");
//        capucines = new CaseConstructible("Boulevard des Capucines", 280, 28,"w");
//        champs = new CaseConstructible("Avenue des Champs Elysees", 300, 30,"g");
//        paix = new CaseConstructible("Rue de la paix",350,35,"g");
//        impot = new CaseSpeciale("Impot sur le Revenu");
//        luxe = new CaseSpeciale("Taxe de Luxe");
//        prison = new CaseSpeciale("Prison");
//        allerenprison = new CaseSpeciale("Aller en Prison");
//        garedelyon = new CaseConstructible("Gare De Lyon",120,25,"gare");
//        garemontparnasse = new CaseConstructible("Gare Mont-Parnasse",120,25,"gare");
//        garedunord = new CaseConstructible("Gare Du Nord",120,25,"gare");
//        garesaintlazard = new CaseConstructible("Gare Saint-Lazar",120,25,"gare");
//    }
//
//    private void creerLesCasesSuivantes(){
//        depart.setSuivante(bellevile);
//        bellevile.setSuivante(lecourbe);
//        lecourbe.setSuivante(impot);
//        impot.setSuivante(garemontparnasse);
//        garemontparnasse.setSuivante(vaugirard);
//        vaugirard.setSuivante(courcelles);
//        courcelles.setSuivante(republique);
//        republique.setSuivante(prison);
//        prison.setSuivante(villette);
//        villette.setSuivante(neuilly);
//        neuilly.setSuivante(paradis);
//        paradis.setSuivante(garedelyon);
//        garedelyon.setSuivante(mozart);
//        mozart.setSuivante(stmichel);
//        stmichel.setSuivante(pigalle);
//        pigalle.setSuivante(matignon);
//        matignon.setSuivante(malesherbes);
//        malesherbes.setSuivante(henrimartin);
//        henrimartin.setSuivante(garedunord);
//        garedunord.setSuivante(sthonore);
//        sthonore.setSuivante(bourse);
//        bourse.setSuivante(fayette);
//        fayette.setSuivante(allerenprison);
//        allerenprison.setSuivante(breteuil);
//        breteuil.setSuivante(foch);
//        foch.setSuivante(capucines);
//        capucines.setSuivante(garesaintlazard);
//        garesaintlazard.setSuivante(champs);
//        champs.setSuivante(luxe);
//        luxe.setSuivante(paix);
//        paix.setSuivante(depart);
//
//    }
//
//
//    private void genererListeCaseSansProprietaire(){
//        caseSansProprietaire.add(bellevile);
//        caseSansProprietaire.add(lecourbe);
//        caseSansProprietaire.add(vaugirard);
//        caseSansProprietaire.add(courcelles);
//        caseSansProprietaire.add(republique);
//        caseSansProprietaire.add(neuilly);
//        caseSansProprietaire.add(villette);
//        caseSansProprietaire.add(paradis);
//        caseSansProprietaire.add(mozart);
//        caseSansProprietaire.add(stmichel);
//        caseSansProprietaire.add(pigalle);
//        caseSansProprietaire.add(malesherbes);
//        caseSansProprietaire.add(matignon);
//        caseSansProprietaire.add(henrimartin);
//        caseSansProprietaire.add(bourse);
//        caseSansProprietaire.add(sthonore);
//        caseSansProprietaire.add(fayette);
//        caseSansProprietaire.add(foch);
//        caseSansProprietaire.add(breteuil);
//        caseSansProprietaire.add(capucines);
//        caseSansProprietaire.add(champs);
//        caseSansProprietaire.add(paix);
//        caseSansProprietaire.add(garedelyon);
//        caseSansProprietaire.add(garedunord);
//        caseSansProprietaire.add(garemontparnasse);
//        caseSansProprietaire.add(garesaintlazard);
//
//
//    }
//
//    public ArrayList<CaseConstructible> getCaseAchetable(){
//        return caseSansProprietaire;
//    }
//}
