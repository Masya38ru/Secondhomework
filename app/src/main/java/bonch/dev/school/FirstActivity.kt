package bonch.dev.school

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import bonch.dev.school.modules.Counter

class FirstActivity : AppCompatActivity() {

    private lateinit var indicatorButton: Button
    private lateinit var counterButton: Button
    private lateinit var textField: EditText
    private lateinit var nextActivityButton: Button
    private lateinit var counter: Counter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        initializeViews()
        counter = Counter()
        counterButton.text = "${counter.value}"
        indicatorButton.setOnClickListener {
            indicatorButton.isEnabled = false
        }
        counterButton.setOnClickListener {
            counter.increment()
            counterButton.text = "${counter.value}"
        }
        nextActivityButton.setOnClickListener {
            val intent = Intent(this, SecondActivity::class.java)
            intent.putExtra("IS_INDICATOR_BUTTON_CLICKED", !indicatorButton.isEnabled)
            intent.putExtra("COUNTER_VALUE", counter.value)
            intent.putExtra("FIELD_TEXT", textField.text.toString())
            startActivity(intent)
        }
    }

    private fun initializeViews() {
        indicatorButton = findViewById(R.id.indicator_button)
        counterButton = findViewById(R.id.counter_button)
        nextActivityButton = findViewById(R.id.next_activity_button)
        textField = findViewById(R.id.text_field)
    }
}
