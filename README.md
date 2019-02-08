# Space_challenge
_Course project_

Program simulates expedition to Mars. 

There are 2 types of cargo described in files 
* _phase-1.txt_
* _phase-2.txt_

that should be transported to Mars.

We have 2 rockets to choose. Both with different parameters.

* **Rocket 1**


    * Rocket cost = $100 Million
    * Rocket weight = 10 Tonnes
    * Max weight (with cargo) = 18 Tonnes
    * Chance of launch explosion = 5% * (cargo carried / cargo limit)
    * Chance of landing crash = 1% * (cargo carried / cargo limit)
    
* **Rocket 2**


    * Rocket cost = $120 Million
    * Rocket weight = 18 Tonnes
    * Max weight (with cargo) = 29 Tonnes
    * Chance of launch explosion = 4% * (cargo carried / cargo limit)
    * Chance of landing crash = 8% * (cargo carried / cargo limit)
    
Simulation load both rockets with items from both files and test their launching and landing. If any rocket crashes, another rocket has to be sent. Program outputs costs of both rockets to transport all cargo