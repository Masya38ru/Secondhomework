package bonch.dev.school

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.FrameLayout
import androidx.fragment.app.FragmentManager
import bonch.dev.school.fragments.FirstFragment

class FragmentActivity : AppCompatActivity() {

    lateinit var fragmentContainer: FrameLayout
    private val fragmentManager: FragmentManager = supportFragmentManager

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        fragmentContainer = findViewById(R.id.fragment_container)
        attachFragment()
    }

    private fun attachFragment() {
        fragmentManager
            .beginTransaction()
            .add(R.id.fragment_container, FirstFragment())
            .commit()
    }
}
