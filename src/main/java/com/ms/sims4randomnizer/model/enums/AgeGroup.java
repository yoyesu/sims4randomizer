package com.ms.sims4randomnizer.model.enums;

public enum AgeGroup {
    TODDLER(1), CHILD(2), TEEN(3), YOUNG_ADULT(4), ADULT(5), ELDERLY(6);
    private int id;

    AgeGroup(int id){this.id = id;}


    public static AgeGroup getAgeById(int id) {
        AgeGroup[] ages = AgeGroup.values();
        for(AgeGroup age : ages){
            if(age.id == id){
                return age;
            }
        }
        return null;
    }
}
