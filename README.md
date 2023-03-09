# Random Story Prompter for The Sims 4

### **Table of Contents**
* [**About Project**](#about-project)
    * [Built with](#built-with)
    * [Dependencies](#dependencies)

## About Project

The app allows you to get four different modalities of random prompts for the simulation game The Sims 4 (only base game).
- Enums Controller: random result for each data category (age, aspiration, difficulty, gender, job, lifespan, sexual preference, and skills).
- Legacy Controller: it generates all the necessary information to create the main sim of your legacy challenge, plus basic information for a few other sims (if you choose to).
- New Sim Controller: it generates all the necessary information to create one sim.
- Starter Household Controller: it generates all the necessary information to create an entire household of sims.


### <span style="color: blue;">**Built With**</span>

* IntelliJ IDEA (Ultimate Edition)
* Spring
* Maven
### <span style="color: blue;">**Dependencies**</span>

* spring-boot-starter-web
* spring-boot-devtools
* springdoc-openapi-ui
* spring-boot-starter-test
* junit-vintage-engine
* hamcrest
* rest-assured
  


## Getting Started

1. Clone the repository
```
git clone https://github.com/yoyesu/sims4randomizer
```
2. Check Maven dependencies are installed

3. Edit application.properties with your preferred server port. Default is 8090.

4. Run application via Sims4RandomnizerApplication.java