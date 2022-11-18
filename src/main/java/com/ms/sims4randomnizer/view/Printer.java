package com.ms.sims4randomnizer.view;

import com.ms.sims4randomnizer.model.Household;
import com.ms.sims4randomnizer.model.Sim;

import java.util.Arrays;
import java.util.List;

public class Printer {

    public static void printResults(Household household, List<Sim> sims){
        System.out.println("Life span: " + household.getLifeSpan().name()
        + "\nStarter sims #: " + household.getStarterSims());

        for(int i =0; i < sims.size(); i++){
            Sim sim = sims.get(i);
            System.out.println(
                    "Sim #" + (i +1)
                            + "\nGender: " + sim.getGender()
                            + "\nAge group: " + sim.getAgeGroup()
                            + "\nAspiration: " + sim.getAspiration()
            + "\nJob: " + sim.getJob()
            + "\nJob level to achieve: " + sim.getJob().getLevel()
            + "\n# of skills to max: " + sim.getSkillsToMax().length
            + "\nSuggested skills: " + Arrays.toString(sim.getSkillsToMax())
            + "\nIs married?: " + sim.isMarried()
            + "\nWill they marry again or for the first time? " + sim.willMarry()
                            + "\nSexual preference: " + sim.getSexualPreference()
                    + "\n# of kids to have/adopt: " + sim.getChildren());
        }
    }
}
