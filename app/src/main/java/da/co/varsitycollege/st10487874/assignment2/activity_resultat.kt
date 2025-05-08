package da.co.varsitycollege.st10487874.assignment2

import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class ActivityResultat : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_resultat)

        // Initialize UI elements
        val scoreTextView = findViewById<TextView>(R.id.scoreTextView)
        val reviewTextView = findViewById<TextView>(R.id.reviewTxeView)
        val exitButton = findViewById<Button>(R.id.exitButton)

        // Retrieve the score and correct answers list passed from the previous activity
        val score = intent.getIntExtra("score", 0)  // Get score from the Intent, default is 0 if not passed
        val correctAnswersList = intent.getStringArrayListExtra("correctAnswers") // List of correct answers

        // Display the score
        scoreTextView.text = "Your score: $score"

        // Display the correct answers
        if (correctAnswersList != null && correctAnswersList.isNotEmpty()) {
            val correctAnswersString = correctAnswersList.joinToString("\n") { "✔ $it" }
            reviewTextView.text = "Correct Answers:\n$correctAnswersString"
        } else {
            reviewTextView.text = "No correct answers"
        }

        // Exit button listener
        exitButton.setOnClickListener {
            finishAffinity()  // This will close the app by finishing all activities
        }
    }
}
