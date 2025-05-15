### ST10487874/FLASH QUIZ APP
##DESCRIPTION
this is a simple True/False flashcard-style quiz app .Users are presented with a welcome screen and,upon starting,go through
a series of five questions to test their knowledge.Each question is worth one point, and users receive immediate feedback on their answers. the app also enclude a 5 second timer.
## FEATURES
the app run with a welcome screen with a "start" button 
5 question flashcard quiz
set timer
true/false interaction 
score tracking
### APP LOGIC 
1.WELCOME SCREEN LOGIC
the user is greeted wirh a welcome screen and a description of the app
by clicking the "start" button navigates the user to the flashcard question screen

## 2.FLASHCARD QUESTION LOGIC
parallel arrays are used for this logic
-Question[] : holds five true/false statements.
-Answer [] : holds corresponding correct answers(true or false )
-A score counter is initialized to 0
+QUIZ LOOP 
 a loop iterates through all five questions
 for each iteration
 1. the current question is displayed on screen
 2. a timer counts down from 5 
 3. the user selects"true" or "false" by clicking the respective button.
 4. the app compares the user's response with the correct answer
 5. instant feedback is displayed :
    -"correct" : if the correct matches.
    -"incorrect" : if it does not.
6. the score counter is incremented after each question
7. the app proceeds to the next question

## 3.SCORE SCREEN LOGIC
An appropriate feedback is displayed based on performances.
a review button allows the user to go through all questions and answers. 
and an "EXIT " button that ends the app.

## HOW TO USE THE APP
 1.  install Android studio
 -download and install android studio
 - launch android studio
 - open the project
   2.   build the App
   -let Android studio download any required dependencies
   -click build , make project
   3.  Run the APP
   -connect an android device via USB or start an emulator
   -click the RUN button
   -select the device/emulator to launch the app
   -start using the quiz.
   ## GitHub Actions and Github
   This project uses GitHub Actions to automates the  build and test process.
   every time code is opened , github Actions automatically :
   -Checks out the latest code
   -builds the project using gradle
   -Runs tests to ensure everything works as expected.
 This project is managed using to track changes in the codebase
A central place to collaborate, manage issues, and review code
integration with tools like github for automating builds,tests,and deployments.
## DESIGN CONSIDERATIONS
the app runs on a cozy screen that makes wanna interact with it 
the second screen is a white screen that makes the user  think, and helps create an clear and distraction free enviroment 
the third screen is where the score is displayed on a cheerful  bright and fun screen
Bright colors, playful visuals, or animations are used to uplift the user’s mood, creating a positive vibe
 and joy to the user experience, making the app more enjoyable and memorable.
 ## links and screenshots
 use this link to assess my repository
 https://github.com/base1825/ST1O487874-IMAD-ASS2.git
 
   
   
   ![welcome screen](https://github.com/user-attachments/assets/805f7afe-4e3d-4ca9-a784-bcabac29986f)

   ![Screensh![Screenshot 2025-05-15 220800](https://github.com/user-attachments/ass![Screenshot 2025-05-15 221227](https://github.com/user-attachments/assets/e5893d75-78fc-4707-8b69-b01cd5a3579a)
ets/6d641b45-5619-48be-9ebb-ee83f1a68a48)
ot 2025-05-15 220611](https://github.com/user-attachments/assets/e41f6fed-9b76-4e8b-922b-e302a3d33930)

   ![Screenshot 2025-05-15 221911](https://github.com/user-attachments/assets/dfb98587-5ddc-4b03-9039-27b3b30fe441)

   ![Screenshot 2025-05-15 222013](https://github.com/user-attachments/assets/3f91![secondActivity code](https://github.com/user-attachments/assets/336771a![Screenshot 2025-05-15 234820](https://github.com/user-attachments/assets/cd2ab8cd-7a8e-4304-8460-d3cd7c1fb676)
9-6e12-4707-ad58-a2198dede637)
1e37-87d2-4045-9847-3122b9e7bb9e)

![Screenshot 2025-05-15 222108](https://github.com/user-
attachments/assets/7303971d-b655-46a0-97b7-5fc44227ffd1)
