package com.emarinuk.knockoutgaming.gamelobby;

/**
 * Created by Eduardo on 20/02/2018
 */
public class ProviderJSON {
    private String provider;
    private String gameName;

    public ProviderJSON(String provider, String gameName) {
        this.provider = provider;
        this.gameName = gameName;
    }

    public String getProvider() {
        return provider;
    }

    public void setProvider(String provider) {
        this.provider = provider;
    }

    public String getGameName() {
        return gameName;
    }

    public void setGameName(String gameName) {
        this.gameName = gameName;
    }
}
