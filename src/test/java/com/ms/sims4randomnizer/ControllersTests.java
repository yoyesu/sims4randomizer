package com.ms.sims4randomnizer;

import io.restassured.http.ContentType;
import org.apache.http.HttpStatus;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static io.restassured.RestAssured.*;

public class ControllersTests {

    @Test
    @DisplayName("Starter Household POST status is 200")
    void starterHouseholdPostStatusIs200() {
        checkStatusOfPOSTMethod("/starter-household");
    }

    @Test
    @DisplayName("New Sim POST status is 200")
    void newSimPostStatusIs200() {
        checkStatusOfPOSTMethod("/new-sim");
    }


    @Test
    @DisplayName("Legacy POST status is 200")
    void legacyPostStatusIs200() {
        checkStatusOfPOSTMethod("/legacy");
    }

    @Test
    @DisplayName("Aspiration GET status is 200")
    void aspirationGetStatusIs200() {
        checkStatusOfEnumsGETMethod("/aspirations");
    }

    @Test
    @DisplayName("Age GET status is 200")
    void ageGetStatusIs200() {
        checkStatusOfEnumsGETMethod("/age");
    }

    @Test
    @DisplayName("Gender GET status is 200")
    void genderGetStatusIs200() {
        checkStatusOfEnumsGETMethod("/gender");
    }

    @Test
    @DisplayName("Child Aspiration GET status is 200")
    void childAspirationGetStatusIs200() {
        checkStatusOfEnumsGETMethod("/child-aspirations");
    }

    @Test
    @DisplayName("Child skills GET status is 200")
    void childSkillsGetStatusIs200() {
        checkStatusOfEnumsGETMethod("/child-skills");
    }

    @Test
    @DisplayName("Jobs GET status is 200")
    void jobsGetStatusIs200() {
        checkStatusOfEnumsGETMethod("/jobs");
    }

    @Test
    @DisplayName("Sexuality GET status is 200")
    void sexualityGetStatusIs200() {
        checkStatusOfEnumsGETMethod("/sexual-preference");
    }

    @Test
    @DisplayName("Skills GET status is 200")
    void skillsGetStatusIs200() {
        checkStatusOfEnumsGETMethod("/skills");
    }

    @Test
    @DisplayName("Teen jobs GET status is 200")
    void teenJobsGetStatusIs200() {
        checkStatusOfEnumsGETMethod("/teen-jobs");
    }

    @Test
    @DisplayName("Toddler skills GET status is 200")
    void toddlerSkillsGetStatusIs200() {
        checkStatusOfEnumsGETMethod("/toddler-skills");
    }

    private void checkStatusOfEnumsGETMethod(String endpoint){
        given().baseUri("http://localhost:8090/enums").
                when().
                get(endpoint).
                then().
                statusCode(HttpStatus.SC_OK);
    }
    private void checkStatusOfPOSTMethod(String endpoint){
        String body = "{\"difficulty\":-1,\"lifespan\":-1,\"starterSims\":-1,\"aspiration\":-1,\"gender\":-1,\"age\":-1,\"job\":-1,\"jobLevel\":-1,\"sexuality\":-1,\"skills\":null,\"skillsArrayLength\":-1,\"children\":-1,\"isMarried\":-1,\"willMarry\":-1}";
        given().baseUri("http://localhost:8090").
                contentType(ContentType.JSON).
                body(body).
                when().
                post(endpoint).
                then().
                statusCode(HttpStatus.SC_OK);
    }
}
