package bonch.dev.school

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.FrameLayout
import androidx.appcompat.app.AppCompatActivity
import bonch.dev.school.fragments.MyFragment
import bonch.dev.school.modules.Counter

class FirstActivity : AppCompatActivity() {

    private lateinit var indicatorButton: Button
    private lateinit var counterButton: Button
    private lateinit var textField: EditText
    private lateinit var attachFragmentButton: Button
    private lateinit var counter: Counter
    lateinit var fragmentContainer: FrameLayout
    val fragmentManager = supportFragmentManager

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
        attachFragmentButton.setOnClickListener {
            val fragment = MyFragment()
            val arguments = Bundle()
            arguments.putBoolean("IS_INDICATOR_BUTTON_CLICKED", !indicatorButton.isEnabled)
            arguments.putInt("COUNTER_VALUE", counter.value)
            arguments.putString("FIELD_TEXT", textField.text.toString())

            fragmentManager
                .beginTransaction()
                .add(fragmentContainer.id, fragment.newInstance(arguments))
                .addToBackStack("my_fragment")
                .commit()
        }
    }

    private fun initializeViews() {
        indicatorButton = findViewById(R.id.indicator_button)
        counterButton = findViewById(R.id.counter_button)
        attachFragmentButton = findViewById(R.id.attach_fragment_button)
        fragmentContainer = findViewById(R.id.fragment_container)
        textField = findViewById(R.id.text_field)
    }
}
