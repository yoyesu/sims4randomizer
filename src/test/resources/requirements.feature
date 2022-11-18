@feature1
Feature Selecting a random lifespan
  Scenario: I want to get a random lifespan among short, normal and long

    Given I am on the homepage
    When I click the random button
    Then I'll get a short, normal or long lifespan randomly

  @feature2
  Feature: Getting a random number of starter sims
    Scenario: I want to get a random number of sims to start my household

    Given I have clicked the random button
    When The lifespan has been randomized
    Then I'll get a number from 1 to 8 for my initial family members

  @feature3
    Feature: Getting random gender for starter sims
    Scenario: I want to assign a gender to each one of my initial family members

      Given I have clicked the random button
      When The starter sims have been randomized
      Then I'll get male or female per each starter member

  @feature4
  Feature: Getting random age group for starter sims
  Scenario: I want to assign an age group (teen, young adult, adult or elderly) to each one of my initial family members

    Given I have clicked the random button
    When The starter sims have been randomized
    Then I'll get an age group per each starter member

  @feature5
  Feature: Getting random aspiration for starter sims
  Scenario: I want to assign an aspiration to each one of my initial family members

    Given I have clicked the random button
    When The starter sims have been randomized
    Then I'll get an aspiration per each starter member

  @feature6
  Feature: Getting random job for starter sims
  Scenario: I want to assign a job to each one of my initial family members

    Given I have clicked the random button
    When The starter sims have been randomized
    Then I'll get a job per each starter member

  @feature7
  Feature: Getting random job level to achieve for starter sims
  Scenario: I want to assign a job level to achieve to each one of my initial family members

    Given I have clicked the random button
    When The jobs have been randomized
    Then I'll get a job level per each starter member

  @feature3
  Feature Adding the number of members in a current household and getting a random number of children (up to 7) to add to it
    Scenario: I want to get a random number of children (max 7) to grow into the household

      Given I enter a number lower than 8
      When I click the random button
      Then I'll get a random number of children within the household limit

