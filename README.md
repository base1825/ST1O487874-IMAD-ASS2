### ST10487874/FLASH QUIZ APP
##DESCRIPTION
this is a simple True/False flashcard-style quiz app .Users are presented with a welcome screen and,upon starting,go through
a series of five questions to test their knowledge.Each question is worth one point, and users receive immediate feedback on their answers.
## FEATURES
the app run with a welcome screen with a "start" button 
5 question flashcard quiz
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
 2. the user selects"true" or "false" by clicking the respective button.
 3. the app compares the user's response with the correct answer
 4. instant feedback is displayed :
    -"correct" : if the correct matches.
    -"incorrect" : if it does not.
5. the score counter is incremented after each question
6. the app proceeds to the next question

## 3.SCORE SCREEN LOGIC
An appropriate feedback is displayed based on performances.
a review button allows the user to go through all questions and answers. 
and an "EXIT " button that ends the app.
## HOW TO INSTALL AND RUN THE PROJECT
