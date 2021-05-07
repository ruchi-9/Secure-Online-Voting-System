# Secure-Online-Voting-System
In order to offer a new alternative to paper-based ballots and EVMs, where the voterneeds to be Physically present. 
I have created an Online Voting system, robust to SQL injection with essential authentication service.

Have three domain
- Admin
- Voter
- Voting Candidate

## Features
- Instead of Storing password directly to the database, I have used the MD5 hashing with salt(random value).
- Candidate Registartion is done by the admin. Voter can register itself, a email is sent after registartion to verify the voter.
- Voter get the OTP every time  whenever they want to login. 
- A voter can only try 3 incorrect password after that its login is locked and they need to reset the password.
- Voter can only give vote to one candidate.
- Admin can see the count of vote given to each candidate.
- After voting is over admin can declare the result or reset the voting system. After declaring the result each voter can login and see the result of voting.

## Database Schema

![text](https://github.com/ruchi-9/Secure-Online-Voting-System/blob/master/Database%20Schema.png)

## Screenshots
- Login Screen

![text](https://github.com/ruchi-9/Secure-Online-Voting-System/blob/master/Screenshots/login.PNG)

- Voter Registration

![text](https://github.com/ruchi-9/Secure-Online-Voting-System/blob/master/Screenshots/new%20reg.PNG)

- Action select by the Admin 

 ![text](https://github.com/ruchi-9/Secure-Online-Voting-System/blob/master/Screenshots/action.PNG)
 
 - Candidate Registration done by Admin
 
 ![text](https://github.com/ruchi-9/Secure-Online-Voting-System/blob/master/Screenshots/candidate%20register.PNG)
 
 - Vote count
 
 ![text](https://github.com/ruchi-9/Secure-Online-Voting-System/blob/master/Screenshots/vote%20count.PNG)
 
 
 ## Admin Login Details
 Username: admin9 
 Password: 9
 
