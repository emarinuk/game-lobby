package com.emarinuk.knockoutgaming.gamelobby;

import java.util.List;

/**
 * Created by Eduardo on 19/02/2018
 */
public class Provider {

    private String providerName;

    public Provider(String providerName, List<String> games) {
        this.providerName = providerName;
        this.games = games;
    }

    private List<String> games;

    public String getProviderName() {
        return providerName;
    }

    public void setProviderName(String providerName) {
        this.providerName = providerName;
    }

    public List<String> listAllGames(){
        return games;
    }

    @Override
    public String toString() {
        return "Provider{" +
                "providerName='" + providerName + '\'' +
                ", games=" + games +
                '}';
    }
}
