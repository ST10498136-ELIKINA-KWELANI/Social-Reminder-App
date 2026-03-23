package za.ac.iie.socialreminderapp

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        //declarations
        val edTime = findViewById<EditText>(R.id.edTime)
        val btnReset = findViewById<Button>(R.id.btnReset)
        val btnEnter = findViewById<Button>(R.id.btnEnter)
        val tvResult = findViewById<TextView>(R.id.tvResult)

        // the action begins
        btnEnter.setOnClickListener {

            // the suggestions code
            var result = ""
            if (edTime.text.toString().lowercase() == "morning") {
                result = " Good Morning!" +
                        "\n Here's your suggestion:" +
                        "\n" +
                        "\n -Send a “good morning” text to a family member." +
                        "\n -Check in with a close friend and wish them a good day." +
                        "\n -Compliment someone you live or work with." +
                        "\n -Share a motivational quote or positive message in a group chat." +
                        "\n -Reply to any messages you missed the previous night."

                tvResult.text = "$result"
            } else if (edTime.text.toString().lowercase() == "afternoon") {
                    result = " Good Afternoon!" +
                            "\n Here's your suggestion:" +
                            "\n" +
                            "\n -Check in with a friend you haven’t spoken to in a while." +
                            "\n -Send a short message appreciating someone’s help or effort." +
                            "\n -Share a useful article or tip relevant to a friend’s interests." +
                            "\n -Invite a colleague or friend for a mid-day coffee or walk." +
                            "\n -Engage with a friend’s social media post with a thoughtful comment."

                    tvResult.text = "$result"
                } else if (edTime.text.toString().lowercase() == "dinner"){
                        result = " Good Evening!" +
                                "\n Here's your suggestion:" +
                                "\n" +
                                "\n -Text someone “How was your day?” to spark conversation." +
                                "\n -Share a funny or heartwarming video with family or friends." +
                                "\n -Arrange a casual virtual or in-person catch-up over dinner." +
                                "\n -Express gratitude to someone who helped you during the day." +
                                "\n -Post a photo of your dinner or evening activity and tag friends."

                        tvResult.text = "$result"

                // the error handling of wrong inputs or no inputs at all
                    } else {
                        tvResult.text = "Please enter these times: Morning, Afternoon, and Dinner"
                    }


        }

        // clearing the info inside both edit text and text view
        btnReset.setOnClickListener {

            if (edTime.text.toString().isNotEmpty() && tvResult.text.toString().isNotEmpty()) {

                edTime.setText("")
                tvResult.text = ""
            } else {
                if (edTime.text.toString().isNotEmpty() || tvResult.text.toString().isNotEmpty()) {
                    edTime.setText("")
                    tvResult.text = ""
                }
            }
        }






    }
}