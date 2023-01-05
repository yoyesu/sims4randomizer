package com.ms.sims4randomnizer.model.enums;

import com.fasterxml.jackson.annotation.JsonFormat;

@JsonFormat(shape = JsonFormat.Shape.OBJECT)
public enum Aspiration {
    BODYBUILDER("Bodybuilder"), PAINTER("Painter"), MUSICAL_GENIUS("Musical genius"), BESTSELLING_AUTHOR("Best-selling author"), PUBLIC_ENEMY("Public enemy"), CHIEF_OF_MISCHIEF("Chief of mischief"), VILLAINOUS_VALENTINE("Villainous valentine"),
    SUCCESSFUL_LINEAGE("Successful lineage"), BIG_HAPPY_FAMILY("Big happy family"), MASTER_CHEF("Master chef"), MASTER_MIXOLOGIST("Master mixologist"), FABULOUSLY_WEALTHY("Fabulously wealthy"), MANSION_BARON("Mansion baron"),
    RENAISSANCE_SIM("Renaissance sim"), NERD_BRAIN("Nerd brain"), COMPUTER_WHIZ("Computer whiz"), SERIAL_ROMANTIC("Serial romantic"), SOULMATE("Soulmate"), FREELANCE_BOTANIST("Freelance botanist"), CURATOR("Curator"), ANGLING_ACE("Angling ace"),
    JOKE_STAR("Joke star"), PARTY_ANIMAL("Party animal"), FRIEND_OF_WORLD("Friend of the world"), NEIGHBORHOOD_CONFIDANTE("Neighborhood confidante");

    public String aspirationName;

    Aspiration(String name){
        aspirationName = name;
    }
    public String getAspirationName() {
        return aspirationName;
    }
}
