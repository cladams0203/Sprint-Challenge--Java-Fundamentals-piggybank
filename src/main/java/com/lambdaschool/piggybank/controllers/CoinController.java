package com.lambdaschool.piggybank.controllers;


import com.lambdaschool.piggybank.models.Coin;
import com.lambdaschool.piggybank.repositories.CoinRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
public class CoinController {
    @Autowired
    CoinRepository coinRepository;

    //http://localhost:2019/total
    @GetMapping(value = "/total", produces = {"application/json"})
    public ResponseEntity<?> ListallCoins(){
        List<Coin> coinList = new ArrayList<>();
        coinRepository.findAll().iterator().forEachRemaining(coinList::add);
        double total = 0;
        for (Coin c : coinList){
            if(c.getQuantity() > 1 ){
                System.out.println(c.getQuantity() + "  " + c.getNameplural());
                total = total + c.getQuantity() * c.getValue();

            }else {
                System.out.println(c.getQuantity() + "  " + c.getName());
                total = total + c.getValue();
            }
        }
        System.out.println("The Piggy Bank Holds " + total);
        return new ResponseEntity<>(coinList, HttpStatus.OK);
    }
}
