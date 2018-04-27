//package net.guillaume.teaching.refactoring.monopoly;
//
//import java.util.ArrayList;
//import java.util.List;
//
//public class Joueur implements Comparable {
//
//    private final De[] des = new De[2];
//    private final String nom;
//    private final String sexe;
//    private int argent;
//    private Case positionActuelle;
//    private int nombreDeDouble = 0;
//    private int nombreTourPlateau = 0;
//    private boolean enPrison = false;
//    private int nombreTourEnPrison = 0;
//    private boolean rejouerApresDouble = false;
//    private boolean liberable = false;
//    private boolean allerPrisonCeTour = false;
//    private int totalDes = 0;
//
//    private int violet = 0;    // Nombre de propriétés pour chaque couleur
//    private int bleu = 0;
//    private int pervenche = 0;
//    private int orange = 0;
//    private int rouge = 0;
//    private int jaune = 0;
//    private int vert = 0;
//    private int gris = 0;
//    private int gare = 0;
//    private List<CaseConstructible> listCasesPossedes= new ArrayList<CaseConstructible>();
//
//    public Joueur(String nom, String sexe, Case position) {
//
//        this.nom = nom;
//        this.sexe= sexe;
//        this.positionActuelle = position;
//
//        des[0] = new De();
//        des[1] = new De();
//    }
//
//    public boolean getLiberable() {
//        return liberable;
//    }
//
//    public Case getPosition() {
//        return positionActuelle;
//    }
//
//    public int getArgent() {
//        return argent;
//    }
//
//    public String getNomJoueur() {
//        return nom;
//    }
//
//    public String getSexeJoueur() {
//        return sexe;
//    }
//
//    public boolean isEnPrison() {
//        return enPrison;
//    }
//
//    public boolean getRejouer() {
//        return rejouerApresDouble;
//    }
//
//    public boolean isFinPartie() {
//        return nombreTourPlateau == 100 || argent < 0;
//    }
//
//    //----------------------------------------------------------------------
//    public void jouerUnTour(Monopoly monopoly){
//
//        if (!monopoly.isFinPartie()) {
//            int[] valeurLancer = this.getValeursApresLancerDes();
//            totalDes = Utility.calculerSomme(valeurLancer);
//            boolean isDouble = Utility.estUnDouble(valeurLancer);
//
//            this.imprimerTotal(totalDes);
//            this.jouerSelonDoubleDe(monopoly, isDouble);
//        }
//    }
//
//    public void jouerSelonDoubleDe(Monopoly monopoly, boolean isDouble){
//
//        if (isDouble) {
//            this.gererDoubleDes(monopoly.getPlateau().getPrison());
//
//            if (!this.isEnPrison()) {
//                jouerTotalDes(totalDes, monopoly);
//                this.imprimerEtatJoueur();
//            }
//            if (this.getRejouer()){
//                System.out.println(this.getNomJoueur() +" rejoue.");
//                this.initialiserRejouer();
//                jouerUnTour(monopoly);
//            }
//            if (this.getLiberable()) {
//                this.liberationDouble();
//                jouerTotalDes(totalDes, monopoly);
//                this.imprimerEtatJoueur();
//            }
//        }
//        else {
//            this.initialiserCompteurDoubleDe();
//            if (!this.isEnPrison()) {
//                jouerTotalDes(totalDes, monopoly);
//            }
//            this.imprimerEtatJoueur();
//        }
//    }
//
//    private void jouerTotalDes(int totalDe, Monopoly monopoly) {
//
//        this.seDeplacer(totalDe, monopoly.getPlateau());
//        if(this.getPosition() instanceof  CaseConstructible) {
//            this.acheterCase((CaseConstructible) this.getPosition(), monopoly.getCaseLibreAAchater());
//            this.payerLoyer((CaseConstructible) this.getPosition(), monopoly.getCaseLibreAAchater(), monopoly.getJoueurs());
//        }
//        monopoly.setFinPartie(this.isFinPartie());
//    }
//
//    public void seLiberer() {
//        if (this.isEnPrison()){
//            this.liberationEnVue();
//        }
//    }
//    //----------------------------------------------------------------------
//
//    public int[] getValeursApresLancerDes() {
//        int[] valeurDe = new int[2];
//        for (int i = 0; i < des.length; i++) {
//            des[0].lancer();
//            valeurDe[i] = des[0].getValeur();
//        }
//        return valeurDe;
//    }
//
//    public void imprimerEtatJoueur() { //Old name: ouSuisJe()
//        if(argent >0){
//            System.out.println("Sa position est " + positionActuelle.getName() + ", son argent est : " + argent + ".");
//        }
//        else {
//            System.out.println("Sa position est " + positionActuelle.getName() + ". " +getSexeJoueur() +" n'a plus d'argent.");
//        }
//
//    }
//
//
//    public void imprimerTotal(int total) {
//        System.out.println( nom + " fait un total pour son lancer de des de " + total +".");
//    }
//
//    public void gererDoubleDes(Case prison) {
//
//        if (!enPrison && !allerPrisonCeTour) {
//            nombreDeDouble++;
//            if (nombreDeDouble == 3) {
//                enPrison = true;
//                positionActuelle = prison;
//                System.out.println(nom + " est jete en prison.");
//                imprimerEtatJoueur();
//            } else {
//                rejouerApresDouble = true;
//            }
//        } else {
//            liberable = true;
//        }
//    }
//
//    public void liberationDouble() {
//        System.out.println(nom + " est libere de prison grace a un double.");
//        enPrison = false;
//        nombreTourEnPrison = 0;
//        liberable = false;
//    }
//
//
//    public void initialiserCompteurDoubleDe() {
//        nombreDeDouble = 0;
//    }
//
//    //Adil: Rename uneFoisCaSuffis
//    public void initialiserRejouer() {
//        rejouerApresDouble = false;
//    }
//
//
//    public void liberationEnVue() {
//        nombreTourEnPrison++;
//        System.out.println( nom + " passe 1 tour en  prison.");
//        allerPrisonCeTour = false;
//        if (nombreTourEnPrison == 4) {
//            nombreTourEnPrison = 0;
//            argent = argent - 50;
//            enPrison = false;
//            System.out.println(nom + " est libere de prison.");
//        }
//    }
//
//    public void seDeplacer(int totalDes, Plateau plateau) {
//
//        for (int i = 0; i < totalDes; i++) {
//            positionActuelle = positionActuelle.getCaseSuivante();
//            if (positionActuelle.equals(plateau.getDepart())) {
//                argent = argent + 200;
//                nombreTourPlateau++;
//            }
//        }
//        if (positionActuelle.equals(plateau.getImpot())) {
//            argent = (int) Math.floor(argent * 0.9);
//        }
//        else if (positionActuelle.equals(plateau.getLuxe())) {
//            argent = argent - (5 * totalDes);
//        }
//        else if (positionActuelle.equals(plateau.getAllerEnPrison())) {
//            positionActuelle = plateau.getPrison();
//            System.out.println(nom + " est sur Aller en prison. " + getSexeJoueur() + " va directement en prison sans passer par le départ !!!");
//            allerPrisonCeTour = true;
//            enPrison = true;
//        }
//
//        if (argent < 0) {
//            System.out.println(nom + " a perdu. " + getSexeJoueur() + " n'a plus d'argent !!!!");
//        }
//    }
//
//    public void acheterCase(CaseConstructible caseConstructible, ArrayList<CaseConstructible> listeCaseConstructible) {
//        if (caseConstructible.getCoutAchat() < argent && listeCaseConstructible.contains(caseConstructible)) {
//            argent = argent - caseConstructible.getCoutAchat();
//            listeCaseConstructible.remove(caseConstructible);
//            System.out.println(" * "+ nom + " achete " + caseConstructible.getName() + " *");
//            augmenterCardinalite(caseConstructible.getCouleur());
//            listCasesPossedes.add(caseConstructible);
//        }
//    }
//
//
//    public void payerLoyer(CaseConstructible caseConstructible, ArrayList<CaseConstructible> listeCaseConstructible, ArrayList<Joueur> listJoueurs) {
//        if (!listeCaseConstructible.contains(caseConstructible) && !listCasesPossedes.contains(caseConstructible)) {
//            if(caseConstructible.getCouleur()=="gare") {
//                int montantLoyer = 0;
//                int nombreGare = 0;
//                for (Joueur joueur : listJoueurs) {
//                    if (joueur.listCasesPossedes.contains(caseConstructible)) {
//                        nombreGare=joueur.getNombreProprieteCouleur(caseConstructible.getCouleur()) -1;
//                        argent = argent - caseConstructible.getLoyer()* (int) Math.pow(2,nombreGare);
//                        if(argent >=0){
//                            joueur.argent += caseConstructible.getLoyer()*(int) Math.pow(2,nombreGare);
//                            montantLoyer= caseConstructible.getLoyer()*(int) Math.pow(2,nombreGare);
//                        }
//                        else{
//                            joueur.argent += caseConstructible.getLoyer()*(int) Math.pow(2,nombreGare) + argent;
//                        }
//                        if (argent>=0){
//                            System.out.println(nom + " paye un loyer de " + montantLoyer + " a " + joueur.getNomJoueur() +" car " +joueur.getNomJoueur() +" possede " + (nombreGare +1)  +" gares." );
//                        }
//                        else {
//                            faireFailliteACauseLoyer();
//                        }
//                    }
//                }
//            }
//            else {
//                for (Joueur joueur : listJoueurs) {
//                    if (joueur.listCasesPossedes.contains(caseConstructible)) {
//                        if (joueur.getNombreProprieteCouleur(caseConstructible.getCouleur()) == caseConstructible.nombreProprieteDeLaCouleur(caseConstructible.getCouleur())){  // si le propriatire a toutes les propriétés
//                            argent = argent - caseConstructible.getLoyer()*2;
//                            if (argent >= 0){
//                                joueur.argent += caseConstructible.getLoyer()*2;
//                                System.out.println(nom + " paye un loyer double de " + caseConstructible.getLoyer()*2 + " a " + joueur.getNomJoueur() +" car " +nom +" possede toutes les proprietes de cette couleur.");
//                            }
//                            else {
//                                joueur.argent += caseConstructible.getLoyer()*2 +argent;
//                                faireFailliteACauseLoyer();
//                            }
//                        }
//                        else { // si il n a pas toutes les proprietes
//                            argent = argent - caseConstructible.getLoyer();
//                            if (argent>=0){ // si il paye le loyer
//                                joueur.argent += caseConstructible.getLoyer();
//                                System.out.println(nom + " paye un loyer de " + caseConstructible.getLoyer() + " a " + joueur.getNomJoueur() +".");
//                            }
//                            else{ // si il ne peut pas payer le loyer
//                                joueur.argent += caseConstructible.getLoyer() + argent;
//                                faireFailliteACauseLoyer();
//                            }
//                        }
//                    }
//                }
//            }
//
//        }
//
//    }
//
//    private void faireFailliteACauseLoyer(){
//        System.out.print(getNomJoueur() +" ne peut pas payer le loyer en entier. Il fait faillite.");
//    }
//
//
//
//    private void   augmenterCardinalite(String couleur){
//        switch (couleur){
//        case "v" :
//            violet++;
//            break;
//        case "b" :
//            bleu++;
//            break;
//        case "p" :
//            pervenche++;
//            break;
//        case "o" :
//            orange++;
//            break;
//        case "r" :
//            rouge++;
//            break;
//        case "j":
//            jaune++;
//            break;
//        case "w":
//            vert++ ;
//            break;
//        case "g" :
//            gris++;
//            break;
//        case "gare":
//            gare++;
//            break;
//        }
//    }
//
//
//    private int   getNombreProprieteCouleur(String couleur){
//        if (couleur=="v"){
//            return violet;}
//        else if (couleur=="b"){
//            return bleu;}
//        else if (couleur== "p"){
//            return pervenche;}
//        else if (couleur=="o"){
//            return orange;}
//        else if (couleur=="r"){
//            return rouge;}
//        else if (couleur=="j"){
//            return jaune;}
//        else if (couleur=="w"){
//            return vert;}
//        else if (couleur=="g"){
//            return gris;}
//        else if (couleur=="gare"){
//            return gare;}
//        else return 0;
//    }
//
//
//
//
//    public int compareTo(Object other) {
//        int argentOtherJoueur = ((Joueur) other).getArgent();
//        int argentJoueur = this.getArgent();
//        if (argentOtherJoueur > argentJoueur)
//            return -1;
//        else if (argentOtherJoueur == argentJoueur)
//            return 0;
//        else
//            return 1;
//    }
//
//
//    public void afficherProprietes(){
//        int compteur=0;
//
//        System.out.print(getSexeJoueur() +" est proprietaire de :") ;
//        for (CaseConstructible caseConstructible : listCasesPossedes) {
//            if (compteur == 0) {
//                System.out.print(" " + caseConstructible.getName()) ;
//            }
//            else {
//                System.out.print(", " + caseConstructible.getName()) ;
//            }
//            compteur++;
//        }
//        System.out.println(".") ;
//    }
//
//
//}
//
