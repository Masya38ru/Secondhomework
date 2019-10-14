package bonch.dev.school

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView

class SecondActivity : AppCompatActivity() {
    lateinit var textView: TextView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_second)

        val arguments = intent.extras
        textView = findViewById(R.id.text_view)

        textView.text = "IS_INDICATOR_BUTTON_CLICKED = ${arguments.getBoolean("IS_INDICATOR_BUTTON_CLICKED")}\n" +
                "COUNTER_VALUE = ${arguments.getInt("COUNTER_VALUE")}\n" +
                "FIELD_TEXT = ${arguments.getString("FIELD_TEXT")}"
    }
}
