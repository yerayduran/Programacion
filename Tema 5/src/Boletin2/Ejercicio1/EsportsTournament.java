package Boletin2.Ejercicio1;

public class EsportsTournament {

    static void main(String[] args) {

        Gamer fps = new FPSGamer();
        Gamer moba = new MOBAGamer();
        Gamer sport = new SportsGamer();
        Gamer[] players = {fps, moba, sport};
        startTournament(players);
    }

    public static void startTournament(Gamer[] players){
        for (Gamer gamer : players){
            gamer.playGame();
        }
    }
}
