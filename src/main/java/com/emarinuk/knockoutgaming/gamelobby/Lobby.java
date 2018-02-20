package com.emarinuk.knockoutgaming.gamelobby;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by Eduardo on 19/02/2018
 */

@Component
public class Lobby {

    Gson gson = new GsonBuilder().setPrettyPrinting().create();

    private static List<Provider> providers = new ArrayList<>();

    public void addProvider(String provider, List<String> games){
        providers.add(new Provider(provider, games));
    }
    public static List<Provider> getProviders() {
        return providers;
    }

    public static void setProviders(List<Provider> providers) {
        Lobby.providers = providers;
    }

    public String retrieveProvidersJSON(){
        List<ProviderJSON> providersJSON = new LinkedList<ProviderJSON>();
        for(Provider provider:providers){
            for(String game:provider.listAllGames()){
                providersJSON.add(new ProviderJSON(provider.getProviderName(),game));
            }
        }
        return gson.toJson(providersJSON);
    }



}
