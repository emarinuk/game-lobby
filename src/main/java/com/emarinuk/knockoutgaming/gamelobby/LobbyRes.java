package com.emarinuk.knockoutgaming.gamelobby;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * Created by Eduardo on 19/02/2018
 */

@RestController
public class LobbyRes {

    @Autowired
    private Lobby lobby;

    //POST /upload
    //loadData
    @GetMapping("/upload")
    public void loadData() {
        String csvFile = "c://games.csv";
        BufferedReader br = null;
        String line = "";
        String cvsSplitBy = ",";
        int counter = 0;
        try {
            br = new BufferedReader(new FileReader(csvFile));
            while ((line = br.readLine()) != null) {
                // use comma as separator
                String[] provider = line.split(cvsSplitBy);
                if(counter>0) {
                    List<String> games = new ArrayList<>();
                    for(int i=1;i<provider.length;i++){
                        games.add(provider[i]);
                    }
                    lobby.addProvider(provider[0],games);
                }
                counter++;
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (br != null) {
                try {
                    br.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    //GET /lobby
    //retrieveAllProviders
    @GetMapping("/lobby")
    public String retrieveAllProviders() {
        return lobby.retrieveProvidersJSON();
    }

    //GET /lobby/number/{game}
    //retrieveNumberOfGames
    @GetMapping("/lobby/number/{provider}")
    public String retrieveNumberOfGamesProvider(@PathVariable String provider) {
        String output = "Provider not found.";
        Iterator<Provider> myIterator = lobby.getProviders().iterator();
        while (myIterator.hasNext()) {
            Provider myProvider = myIterator.next();
            if(provider.equals(myProvider.getProviderName())){
                output = "[  {\"provider\":\"" + provider + "\",\"numberOfGames\":\"" +  Integer.toString(myProvider.listAllGames().size()) + "\"}]";
            }
        }
        return  output;
    }

    //POST /lobby/number
    //retrieveNumberOfGames
    @PostMapping("/lobby/")
    public String retrieveNumberOfGames(@RequestAttribute String provider) {
        String output = "Provider not found.";
        Iterator<Provider> myIterator = lobby.getProviders().iterator();
        while (myIterator.hasNext()) {
            Provider myProvider = myIterator.next();
            if(provider.equals(myProvider.getProviderName())){
                output = "[  {\"provider\":\"" + provider + "\",\"numberOfGames\":\"" +  Integer.toString(myProvider.listAllGames().size()) + "\"}]";
            }
        }
        return  output;
    }
}
