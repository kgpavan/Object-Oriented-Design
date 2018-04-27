//package net.guillaume.teaching.refactoring.monopoly;
//
//public class CaseConstructible extends Case{
//
//    private final int coutAchat;
//    private final int loyer;
//    private final String couleur;
//
//    public CaseConstructible(String name, int coutAchat, int loyer, String couleur) {
//        super(name);
//        this.coutAchat = coutAchat;
//        this.loyer = loyer;
//        this.couleur=couleur;
//    }
//
//
//    public int getCoutAchat() {
//        return coutAchat;
//    }
//
//    public int getLoyer() {
//        return loyer;
//    }
//
//    public String getCouleur(){
//        return couleur ;
//    }
//
//
//    public int nombreProprieteDeLaCouleur(String couleur){
//        switch (couleur) {
//            case "v": return 2;
//            case "b": return 3;
//            case "o": return 3;
//            case "r": return 3;
//            case "j": return 3;
//            case "w": return 3;
//            case "g": return 2;
//        }
//        return 0;
//     }
//
//
//}
