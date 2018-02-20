package com.emarinuk.knockoutgaming.gamelobby;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Eduardo on 19/02/2018
 */

@RestController
public class LobbyRes {

    @Autowired
    private Lobby lobby;

    //GET /providers
    //retrieveAllProviders
    @GetMapping("/lobby")
    public String retrieveAllProviders() {
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
        return lobby.retrieveProvidersJSON();
    }
}
