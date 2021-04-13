package no.gruppe6.yatzy.util;


import no.gruppe6.yatzy.entities.Bruker;
import no.gruppe6.yatzy.entities.Kopp;
import no.gruppe6.yatzy.entities.Spilldeltagelse;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class YatzyUtil {


    /**
     * This method checks the thrown of a user according to which scores it will get
     * @param kopp holds the five dices that are being thrown
     * @param runde is the current round
     * @return the value of the dices
     */
    public static int sjekkKast(Kopp kopp, int runde) {
        int verdi = 0;
        switch (runde) {
            case 1:
            case 2:
            case 3:
            case 4:
            case 5:
            case 6:
                verdi = enkleRuter(kopp, runde);
                break;
            case 7:
                verdi = ettPar(kopp);
                break;
            case 8:
                verdi = toPar(kopp);
                break;
            case 9:
                verdi = treLike(kopp);
                break;
            case 10:
                verdi = fireLike(kopp);
                break;
            case 11:
                verdi = litenStraight(kopp);
                break;
            case 12:
                verdi = storStraight(kopp);
                break;
            case 13:
                verdi = hus(kopp);
                break;
            case 14:
                verdi = sjanse(kopp);
                break;
            case 15:
                verdi = yatzy(kopp);
                break;
            default:
                System.out.println("Noe gikk feil");
                break;
        }

        return verdi;
    }

    /**
     * This method handles the scores of a round when a game is being played, according to which values you should get
     * to receive the highest amount of points
     * @param runde is the current round
     * @return the name of the round according to what dices you should roll to score the most points
     */
    public static String rundeNavn(int runde) {
        String rundenavn = "Du skal ha ";
        switch (runde) {
            case 1: rundenavn+="enere"; break;
            case 2:rundenavn+="toere"; break;
            case 3:rundenavn+="treere"; break;
            case 4:rundenavn+="firere"; break;
            case 5:rundenavn+="femere"; break;
            case 6:rundenavn+="seksere"; break;
            case 7:
                rundenavn+="ett par"; break;
            case 8:
                rundenavn+="to par"; break;
            case 9:
                rundenavn+="tre like"; break;
            case 10:
                rundenavn+="fire like"; break;
            case 11:
                rundenavn+="liten straight (1,2,3,4,5)"; break;
            case 12:
                rundenavn+="stor straight (2,3,4,5,6)"; break;
            case 13:
                rundenavn+="hus (2+3)"; break;
            case 14:
                rundenavn+="sjanse"; break;
            case 15:
                rundenavn+="yatzy"; break;
            default:
                System.out.println("Noe gikk feil");
                break;
        }

        return rundenavn;
    }

    /**
     * This method updates the value to a user according to which round the player is on in the game
     * @param sum is the added value of the dices
     * @param runde is the current round
     * @param spilldeltagelse is the player to update the value of
     */
    public static void oppdaterVerdi(int sum, int runde, Spilldeltagelse spilldeltagelse) {
        switch (runde) {
            case 1:
                spilldeltagelse.setEnere(sum);
                break;
            case 2:
                spilldeltagelse.setToere(sum);
                break;
            case 3:
                spilldeltagelse.setTreere(sum);
                break;
            case 4:
                spilldeltagelse.setFirere(sum);
                break;
            case 5:
                spilldeltagelse.setFemere(sum);
                break;
            case 6:
                spilldeltagelse.setSeksere(sum);
                kalkulerBonus(spilldeltagelse);
                break;
            case 7:
                spilldeltagelse.setPar(sum);
                break;
            case 8:
                spilldeltagelse.setTopar(sum);
                break;
            case 9:
                spilldeltagelse.setTrelike(sum);
                break;
            case 10:
                spilldeltagelse.setFirelike(sum);
                break;
            case 11:
                spilldeltagelse.setLitenstraight(sum);
                break;
            case 12:
                spilldeltagelse.setStorstraight(sum);
                break;
            case 13:
                spilldeltagelse.setHus(sum);
                break;
            case 14:
                spilldeltagelse.setSjanse(sum);
                break;
            case 15:
                spilldeltagelse.setYatzy(sum);
                avsluttSpill(spilldeltagelse);
                break;
            default:
                System.out.println("Noe gikk feil");
                break;
        }
    }

    /**
     * This method checks the equality of dices in the first rounds when the goal is to get as many of the
     * same dice according to which round the user is on
     * @param kopp holds the five dices that are being thrown
     * @param runde is the current round
     * @return the result of thrown
     */
    private static int enkleRuter(Kopp kopp, int runde) {
        int resultat = 0;
        for (int t : kopp.hentTerninger()) {
            if (t == runde) {
                resultat += runde;
            }
        }
        return resultat;
    }

    /**
     * This method checks if the dices being rolled is a pair, and returns the highest of the pairs if multiple
     * @param kopp holds the five dices that are being thrown
     * @return the highest pair
     */
    private static int ettPar(Kopp kopp) {
        int hoyestePar = 0;
        int nyttPar = 0;
        int[] terninger = kopp.hentTerninger();
        for (int i = 0; i < 5; i++) {
            for (int k = i + 1; k < 5; k++) {
                if (terninger[i] == terninger[k])
                    nyttPar = terninger[i] * 2;
                if (nyttPar > hoyestePar)
                    hoyestePar = nyttPar;
            }
        }
        return hoyestePar;
    }

    /**
     * This method checks if the dices being rolled are two pairs, and returns the highest of the pairs if multiple
     * @param kopp holds the five dices being thrown
     * @return the two highest pairs
     */
    private static int toPar(Kopp kopp) {
        int hoytPar = ettPar(kopp);
        int lavtPar = 0;
        int nyttPar = 0;
        int[] terninger = kopp.hentTerninger();
        for (int i = 0; i < 5; i++) {
            for (int k = i + 1; k < 5; k++) {
                if (terninger[i] == terninger[k])
                    nyttPar = terninger[i] * 2;
                if (nyttPar < hoytPar)
                    lavtPar = nyttPar;
            }
        }

        if (hoytPar > 0 && lavtPar > 0)
            return hoytPar + lavtPar;
        else {
            return 0;
        }
    }

    /**
     * This method checks if the dices being rolled consists of three equals
     * @param kopp holds the five dices that are being thrown
     * @return the three equals if that exists
     */
    private static int treLike(Kopp kopp) {
        int treLike = 0;
        int[] terninger = kopp.hentTerninger();
        for (int i = 0; i < 5; i++) {
            for (int k = i + 1; k < 5; k++) {
                if (terninger[i] == terninger[k]) {
                    for (int t = k + 1; t < 5; t++) {
                        if (terninger[t] == terninger[k])
                            treLike = terninger[t] * 3;
                    }
                }
            }
        }
        return treLike;
    }

    /**
     * This method checks if the dices being rolled consists of four equals
     * @param kopp holds the five dices that are being thrown
     * @return the four equals if that exists
     */
    private static int fireLike(Kopp kopp) {
        int fireLike = 0;
        int[] terninger = kopp.hentTerninger();
        for (int i = 0; i < 5; i++) {
            for (int k = i + 1; k < 5; k++) {
                if (terninger[i] == terninger[k]) {
                    for (int t = k + 1; t < 5; t++) {
                        if (terninger[t] == terninger[k])
                            for (int s = t + 1; s < 5; s++) {
                                if (terninger[s] == terninger[t])
                                    fireLike = terninger[t] * 4;

                            }
                    }
                }
            }
        }
        return fireLike;
    }

    /**
     * This method checks if the dices being rolled consists of a small straight, meaning the dices being rolled contains
     * the value between 1 and 5
     * @param kopp holds the five dices that are being thrown
     * @return 15 if a user rolls a small straight, and zero if not
     */
    private static int litenStraight(Kopp kopp) {
        int[] terninger = kopp.hentTerninger();
        if (sjanse(kopp) == 15) {
            for (int i = 0; i < 4; i++) {
                if (terninger[i] == terninger[i + 1])
                    return 0;
            }
            return 15;
        } else
            return 0;
    }

    /**
     * This method checks if the dices being rolled consists of a big straight, meaning the dices being rolled contains
     * the value between 2 and 6
     * @param kopp holds the five dices that are being thrown
     * @return 20 if a user rolls a big straight, and zero if not
     */
    private static int storStraight(Kopp kopp) {
        int[] terninger = kopp.hentTerninger();
        if (sjanse(kopp) == 20) {
            for (int i = 0; i < 4; i++) {
                if (terninger[i] == terninger[i + 1])
                    return 0;
            }

            return 20;
        } else
            return 0;
    }

    /**
     * This method checks if the dices being rolled consists of a full  house, meaning the dices being rolled contains
     * of a set of three and a pair
     * @param kopp holds the five dices that are being thrown
     * @return the value of the eyes of the dices if they add up to a full house, zero if not
     */
    private static int hus(Kopp kopp) {
        int trelike = treLike(kopp);
        int par = 0;
        int tempVerdi = 0;
        int[] terninger = kopp.hentTerninger();
        if (trelike > 0) {
            int likverdi = trelike / 3;
            for (int i = 0; i < 5; i++) {
                if (terninger[i] != likverdi) {
                    if (tempVerdi == 0)
                        tempVerdi = terninger[i];
                    else if (terninger[i] == tempVerdi)
                        par = tempVerdi * 2;

                }

            }
        }
        if (par > 0 && trelike > 0)
            return par + trelike;
        else
            return 0;
    }

    /**
     * This method handles a situation when a user wants to do a chance
     * @param kopp holds the five dices that are being thrown
     * @return the sum of the value of all the dices
     */
    private static int sjanse(Kopp kopp) {
        int[] terninger = kopp.hentTerninger();
        return terninger[0] + terninger[1] + terninger[2] + terninger[3] + terninger[4];
    }

    /**
     * This method checks if a user has thrown a yatzy, meaning all five dices has the same number of eyes
     * @param kopp holds the five dices that are being thrown
     * @return 50 if yatzy, 0 if not
     */
    private static int yatzy(Kopp kopp) {

        int[] terninger = kopp.hentTerninger();
        if (terninger[0] == terninger[1] && terninger[0] == terninger[2] && terninger[0] == terninger[3] && terninger[4] == terninger[0])
            return 50;
        else
            return 0;

    }

    /**
     * This method calculates the bonus after the first six throws, if the throws after being added sums up to
     * fifty or more, another 50 is being given as a bonus, 0 bonus if not
     * @param s is the player we check the throws to
     */
    private static void kalkulerBonus(Spilldeltagelse s) {
        int sumbonus = s.getEnere() + s.getToere() + s.getTreere() + s.getFirere() + s.getFemere() + s.getSeksere();
        s.setSumbonus(sumbonus);
        s.setBonus(sumbonus >= 50 ? 50 : 0);
    }

    /**
     * This method finishes the game and adds up the total sum of points during the game
     * @param s is the player we adds up the total points to
     */
    private static void avsluttSpill(Spilldeltagelse s) {
        int totalSum = s.getSumbonus() + s.getBonus() + s.getPar() + s.getTopar() + s.getTrelike() + s.getFirelike() +
                s.getLitenstraight()  +  s.getStorstraight() + s.getHus() + s.getSjanse() + s.getYatzy();
        s.setTotalsum(totalSum);
    }

    /**
     * This method calculates who's turn it is while a game is being played
     * @param spilldeltagelser is the list of all the players in the game
     * @param spilldeltagelse is the player who's turn it is now
     * @return the next user, meaning the player who's turn it is now
     */
    public static Bruker finnNeste(List<Spilldeltagelse> spilldeltagelser, Spilldeltagelse spilldeltagelse){
        spilldeltagelser.sort(Comparator.comparingInt(Spilldeltagelse::getId));
        int index = spilldeltagelser.indexOf(spilldeltagelse);

        if(index == spilldeltagelser.size()-1){
            return spilldeltagelser.get(0).getBruker();
        }else {
            return spilldeltagelser.get(index+1).getBruker();
        }

    }

}