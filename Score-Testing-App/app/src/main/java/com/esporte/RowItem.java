package com.esporte;

/**
 * Created by Aky on 12/23/2015.
 */
public class RowItem {

    private String player_name;
    private String ranking;
    public RowItem(String player_name,
                   String ranking) {

        this.player_name = player_name;
        this.ranking = ranking;;
    }

    public String getPlayer_name() {
        return player_name;
    }

    public void setPlayer_name(String player_name) {
        this.player_name = player_name;
    }

    public String getRanking() {
        return ranking;
    }

    public void setRanking(String ranking) {
        this.ranking = ranking;
    }
}