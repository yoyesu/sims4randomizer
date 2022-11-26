package com.ms.sims4randomnizer.view;

import com.ms.sims4randomnizer.model.dto.GameSave;
import com.ms.sims4randomnizer.model.dto.Household;
import com.ms.sims4randomnizer.model.dto.Sim;

import java.util.List;

public class Printer {

    public static String printResults(GameSave save){
        Household household = save.getHousehold();
        List<Sim> sims = save.getSims();
        StringBuilder results = new StringBuilder("Life span: " + household.getLifeSpan().name()
                + "<br>Starter sims #: " + household.getStarterSims() + "<br><br>");

        for(int i =0; i < sims.size(); i++){
            Sim sim = sims.get(i);
            results.append("Sim #").append(i+1).append("<br>")
                    .append(sim.toString()).append("<br>--------------------------<br>");

        }

        return results.toString();
    }
}
