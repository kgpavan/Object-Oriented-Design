//package net.guillaume.teaching.refactoring.monopoly;
//
//import java.util.ArrayList;
//import java.util.Collections;
//
//public class Monopoly {
//
//	private final ArrayList<Joueur> joueurs = new ArrayList<>();
//	public boolean finPartie = false;
//	private ArrayList<net.guillaume.teaching.refactoring.monopoly.CaseConstructible> caseLibreAAchater = new ArrayList<>();
//	private Plateau plateau ;
//	int totalDes = 0;
//
//	public Monopoly() {
//
//		initialiserNouvellePartie();
//	}
//
//
//	public void initialiserNouvellePartie(){
//
//	    plateau= new Plateau();
//
//	    joueurs.add(new Joueur("Marina","Elle", plateau.getDepart()));
//        joueurs.add(new Joueur("Ambre", "Elle", plateau.getDepart()));
//        joueurs.add(new Joueur("Loubna","Elle", plateau.getDepart()));
//        joueurs.add(new Joueur("Mathieu","Il", plateau.getDepart()));
//        joueurs.add(new Joueur("Cedric","Il", plateau.getDepart()));
//
//        caseLibreAAchater=  new ArrayList<>(plateau.getCaseAchetable());
//	}
//
//	public void jouerUnePartie() {
//	    while (!finPartie) {
//	        for (Joueur joueur : joueurs) {
//	            joueur.jouerUnTour(this);
//	            joueur.seLiberer();
//	        }
//	    }
//	    afficheFinDePartie();
//	}
//
//	private void afficheFinDePartie() {
//		System.out.println("La partie est terminee !!!");
//		trierListeJoueurs();
//		System.out.println("Le vainqueur est " + joueurs.get(0).getNomJoueur() + " avec " + joueurs.get(0).getArgent() +".");
//		joueurs.get(0).afficherProprietes() ;
//		for (int i=1; joueurs.size()>i; i++) {
//			if(joueurs.get(i).getArgent()>0){
//				System.out.println(joueurs.get(i).getNomJoueur() + " est " + (i + 1) + " place avec " + joueurs.get(i).getArgent() +".");
//				joueurs.get(i).afficherProprietes();
//			}
//			else {
//				System.out.println(joueurs.get(i).getNomJoueur() + " est " + (i + 1) + " place avec 0 argent.");
//				joueurs.get(i).afficherProprietes();
//			}
//		}
//	}
//
//    private void trierListeJoueurs() {
//		Collections.sort(joueurs);
//		Collections.sort(joueurs, Collections.reverseOrder());
//	}
//
//
//
//    public boolean isFinPartie() {
//        return finPartie;
//    }
//
//    public void setFinPartie(boolean finPartie) {
//        this.finPartie = finPartie;
//    }
//
//    public ArrayList<Joueur> getJoueurs() {
//        return joueurs;
//    }
//
//    public ArrayList<CaseConstructible> getCaseLibreAAchater() {
//        return caseLibreAAchater;
//    }
//
//    public Plateau getPlateau() {
//        return plateau;
//    }
//
//}
//
