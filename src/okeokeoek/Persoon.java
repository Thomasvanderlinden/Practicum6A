package okeokeoek;

import java.util.ArrayList;

public class Persoon {


    private String naam;
    private double budget;
    ArrayList<Game> mijnGames = new ArrayList<>();

    public Persoon(String nm, double bud) {
        naam = nm;
        budget = bud;
    }

    public double getBudget() {
        return budget;
    }


    public boolean koop(Game g) {

        if(budget < g.huidigeWaarde()){
            return false;
        }
        if(mijnGames.contains(g)){
            return false;
        }
        budget = budget - g.huidigeWaarde();
        mijnGames.add(g);
        return true;
    }


    public boolean verkoop(Game g, Persoon koper) {
        if (!mijnGames.contains(g)) {
            return false;
        }
        if (koper.mijnGames.contains(g)) {
            return false;
        }
        if (koper.budget < g.huidigeWaarde()) {
            return false;
        }

        mijnGames.remove(g);
        koper.mijnGames.add(g);
        budget = budget + g.huidigeWaarde();
        koper.budget = koper.budget - g.huidigeWaarde();
    return true;}



    public Game zoekGameOpNaam(String s){
        for(Game g : mijnGames){
            if(s.contains(g.getNaam())){
                return g;
            }
        }
        return null;
    }




    public ArrayList<Game> bepaalGamesNietInBezit(ArrayList <Game> tekoop) {
        ArrayList<Game> nogNietInBezit = new ArrayList<>();

            for(Game g : mijnGames){
                tekoop.remove(g);}

            for(Game x : tekoop){
                nogNietInBezit.add(x);
            }

        return nogNietInBezit;



    }


    public String toString() {
        StringBuilder sb = new StringBuilder(naam + String.format(" heeft een budget van €%.2f", budget) + " en bezit de volgende games:");

        for (Game e : mijnGames){
            sb.append("\n"+ e);
        }
        return  sb.toString();
    }

}



