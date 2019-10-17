package bonch.dev.school.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import bonch.dev.school.R

class MyFragment : Fragment() {
    lateinit var textView: TextView

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val view: View = inflater.inflate(R.layout.fragment_layout, container, false)
        textView = view.findViewById(R.id.text_view)
        textView.text = "IS_INDICATOR_BUTTON_CLICKED = ${arguments?.getBoolean("IS_INDICATOR_BUTTON_CLICKED")}\n" +
                "COUNTER_VALUE = ${arguments?.getInt("COUNTER_VALUE")}\n" +
                "FIELD_TEXT = ${arguments?.getString("FIELD_TEXT")}"
        return view
    }

    fun newInstance(args: Bundle): Fragment {
        val fragment = MyFragment()
        fragment.arguments = args
        return fragment
    }
}