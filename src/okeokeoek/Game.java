package okeokeoek;



public class Game   {

    private String naam;
    private int releaseJaar;
    private double nieuwprijs;


    public Game(String nm, int rJ, double nwpr) {
        naam = nm;
        releaseJaar = rJ;
        nieuwprijs = nwpr;
    }


    public String getNaam() {
        return naam;
    }

    public double huidigeWaarde() {

        double nummer = Math.pow(0.7, 2022 - releaseJaar);
        return nieuwprijs * nummer;

    }

    public int getReleaseJaar(){return releaseJaar;}


    public boolean equals(Object andereObject) {//if naam en releasejaar equals
        boolean gelijkeObjecten = false;

        if (andereObject instanceof Game) {
            Game andereGame = (Game) andereObject;

            if (this.naam.equals(andereGame.naam) && this.releaseJaar == andereGame.releaseJaar
            ){
                gelijkeObjecten = true;
            }
        }
        return gelijkeObjecten;

    }

    public String toString() {
        StringBuilder sb = new StringBuilder(naam + ", uitgegeven in " + releaseJaar + String.format("; nieuwprijs: €%.2f", nieuwprijs) + String.format(" nu voor: €%.2f", huidigeWaarde()));
        return sb.toString();
    }

}
