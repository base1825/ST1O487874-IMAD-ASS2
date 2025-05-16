package da.co.varsitycollege.st10487874.assignment2

import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.lifecycle.findViewTreeViewModelStoreOwner

class result_Activity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_result)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
// Initialize UI elements
            val scoreTextView = findViewById<TextView>(R.id.scoreTextView)
            val reviewTextView = findViewById<TextView>(R.id.reviewTextView)
            val reviewButton = findViewById<Button>(R.id.reviewButton)
            val completionTextView = findViewById<TextView>(R.id.completionTextView)
            val exitButton = findViewById<Button>(R.id.exitButton)
            val fedback = findViewById<TextView>(R.id.fedback)

// Retrieve the score and correct answers list
        val score = intent.getIntExtra("score", 0)
        val correctAnswersList = intent.getStringArrayListExtra("correctAnswersGiven")
        val questions = intent.getStringArrayListExtra("questions")
        val correctAnswersAll = intent.getStringArrayListExtra("correctAnswersAll")


// Display the score
            scoreTextView.text = "Your score: $score"

// Show "Quiz Completed" message
            completionTextView.text = "🎉 Quiz Completed!"

// Hide review text view initially
            reviewTextView.visibility = View.GONE
        if (score > 3) {
            fedback.text = "🎉  Congratulatessss, you're really doing good."
        } else {
            fedback.text = "💡 not so bad, just need to practice more"
        }


// Review button logic
        reviewButton.setOnClickListener {
            if (!questions.isNullOrEmpty() && !correctAnswersList.isNullOrEmpty()) {
                val reviewText = StringBuilder("✅ Réponses correctes :\n\n")
                for (i in questions.indices) {
                    val question = questions[i]
                    val correctAnswer = correctAnswersList[i]
                    reviewText.append("Q: $question\n✔ Réponse correcte : $correctAnswer\n\n")
                }
                reviewTextView.text = reviewText.toString()
            } else {
                reviewTextView.text = "⚠️ Missing data to display review."
            }
            reviewTextView.visibility = View.VISIBLE
        }




        exitButton.setOnClickListener {
                finishAffinity()
            }
    }
}