package da.co.varsitycollege.st10487874.assignment2

import android.content.Intent
import android.os.Bundle
import android.os.CountDownTimer
import android.view.View
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class SecondActivity : AppCompatActivity() {

    val questions = arrayOf(
        "Is Milan the capital of France?",
        "The Earth is flat?",
        "1960 is the correct independence year of DRC?",
        "Is Brazil a country?",
        "Human body has 104 muscles?"
    )

    val correctAnswers = arrayOf(
        "false", "false", "true", "true", "false"
    )

    var currentQuestionIndex = 0
    var score = 0
    val correctAnswersGiven = mutableListOf<String>()  // List to store correct answers

    lateinit var timer: CountDownTimer

    // UI elements
    lateinit var questionTextView: TextView
    lateinit var feedbackTextView: TextView
    lateinit var nextButton: Button
    lateinit var trueButton: Button
    lateinit var falseButton: Button
    lateinit var timerTextView: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_second)

        // Initialize UI elements
        questionTextView = findViewById<TextView>(R.id.questionTextView)
        feedbackTextView = findViewById<TextView>(R.id.feedbackTextView)
        nextButton = findViewById<Button>(R.id.nextButton)
        trueButton = findViewById<Button>(R.id.trueButton)
        falseButton = findViewById<Button>(R.id.falseButton)
        timerTextView = findViewById<TextView>(R.id.timerTextView)
        nextButton = findViewById<Button>(R.id.nextButton)

        // Disable Next button initially
        nextButton.isEnabled = false

        // Set up button listeners
        trueButton.setOnClickListener { handleAnswer("true") }
        falseButton.setOnClickListener { handleAnswer("false") }
        nextButton.setOnClickListener { moveToNextQuestion() }

        // Show the first question
        showQuestion()
    }

    private fun showQuestion() {
        // Show the current question and start the timer
        questionTextView.text = questions[currentQuestionIndex]

        // Start the countdown timer
        timer = object : CountDownTimer(5000, 1000) { // 5 seconds
            override fun onTick(millisUntilFinished: Long) {
                timerTextView.text = "Time left: ${millisUntilFinished / 1000}s"
            }

            override fun onFinish() {
                // Time's up, automatically move to the next question
                feedbackTextView.text = "⏳ Time's up!"
                nextButton.isEnabled = true // Enable the Next button after time's up
            }
        }
        timer.start()
    }

    private fun handleAnswer(answer: String) {
        // Stop the timer when an answer is selected
        timer.cancel()

        // Check if the user's answer is correct
        if (answer == correctAnswers[currentQuestionIndex]) {
            score++
            feedbackTextView.text = "✅ Correct!"
            // Add the question to the list of correct answers
            correctAnswersGiven.add(questions[currentQuestionIndex])
        } else {
            feedbackTextView.text = "❌ Incorrect!"
        }

        // Enable the Next button after answering
        nextButton.isEnabled = true
    }

    private fun moveToNextQuestion() {
        if (currentQuestionIndex < questions.size - 1) {
            currentQuestionIndex++
            showQuestion() // Show the next question
            feedbackTextView.text = "" // Clear the feedback
            nextButton.isEnabled = false // Disable Next button until an answer is given
        } else {
            // After the last question, go to the results activity
            val intent = Intent(this, ActivityResultat::class.java).apply {
                putExtra("score", score)  // Pass the score
                putStringArrayListExtra("correctAnswers", ArrayList(correctAnswersGiven))  // Pass the list of correct answers
            }
            startActivity(intent)
        }
    }
}
