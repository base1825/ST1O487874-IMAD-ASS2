package da.co.varsitycollege.st10487874.assignment2

import android.content.Intent
import android.os.Bundle
import android.os.CountDownTimer
import android.util.Log
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class SecondActivity : AppCompatActivity() {

    val questions = arrayOf(
        "Is Milan the capital of France?",
        "is the Earth flat?",
        "1960 is the correct independence year of DRC?",
        "Is Brazil a country?",
        "Human body has 104 muscles?"
    )

    val correctAnswers = arrayOf(
        "false", "false", "true", "true", "false"
    )

    var currentQuestionIndex = 0
    var score = 0
    val correctAnswersGiven = mutableListOf<String>()

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
        questionTextView = findViewById(R.id.questionTextView)
        feedbackTextView = findViewById(R.id.feedbackTextView)
        nextButton = findViewById(R.id.nextButton)
        trueButton = findViewById(R.id.trueButton)
        falseButton = findViewById(R.id.falseButton)
        timerTextView = findViewById(R.id.timerTextView)

        // Disable Next button initially
        nextButton.isEnabled = false

        // Log all questions (debugging)
        for (i in questions.indices) {
            Log.d("SecondActivity", "Question ${i + 1}: ${questions[i]}")
        }

        // Button listeners
        trueButton.setOnClickListener { handleAnswer("true") }
        falseButton.setOnClickListener { handleAnswer("false") }
        nextButton.setOnClickListener { moveToNextQuestion() }

        // Show first question
        showQuestion()
    }

    private fun showQuestion() {
        // Display question
        questionTextView.text = questions[currentQuestionIndex]
        feedbackTextView.text = ""

        // Re-enable answer buttons
        trueButton.isEnabled = true
        falseButton.isEnabled = true

        // Disable next button until answer or timeout
        nextButton.isEnabled = false

        // Start countdown
        timer = object : CountDownTimer(5000, 1000) {
            override fun onTick(millisUntilFinished: Long) {
                timerTextView.text = "Time left: ${millisUntilFinished / 1000}s"
            }

            override fun onFinish() {
                feedbackTextView.text = "⏳ Time's up!"
                trueButton.isEnabled = false
                falseButton.isEnabled = false
                nextButton.isEnabled = true
            }
        }
        timer.start()
    }

    private fun handleAnswer(answer: String) {
        // Stop the timer when answered
        timer.cancel()

        // Disable answer buttons
        trueButton.isEnabled = false
        falseButton.isEnabled = false

        // Check answer
        if (answer == correctAnswers[currentQuestionIndex]) {
            score++
            feedbackTextView.text = "✅ Correct!"
            correctAnswersGiven.add(questions[currentQuestionIndex])
        } else {
            feedbackTextView.text = "❌ Incorrect!"
        }

        // Enable next button
        nextButton.isEnabled = true
    }

    private fun moveToNextQuestion() {
        if (currentQuestionIndex < questions.size - 1) {
            currentQuestionIndex++
            showQuestion()
        } else {
            val intent = Intent(this, result_Activity::class.java)
            intent.putExtra("score", score)
            intent.putStringArrayListExtra("correctAnswersGiven", ArrayList(correctAnswersGiven))
            intent.putStringArrayListExtra("questions", ArrayList(questions.toList()))
            intent.putStringArrayListExtra("correctAnswersAll", ArrayList(correctAnswers.toList()))
            startActivity(intent)
        }
    }
}
