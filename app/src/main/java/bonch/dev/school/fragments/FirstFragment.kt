package bonch.dev.school.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.fragment.app.Fragment
import bonch.dev.school.R

class FirstFragment : Fragment() {

    lateinit var nextActivityButton: Button

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val view: View = inflater.inflate(R.layout.fragment_first, container, false)
        nextActivityButton = view.findViewById(R.id.next_activity_button)
        nextActivityButton.setOnClickListener {
            fragmentManager
                ?.beginTransaction()
                ?.replace(R.id.fragment_container, SecondFragment())
                ?.addToBackStack("second_fragment")
                ?.commit()
        }
        return view

    }
}