package com.example.myapplication.sidebar

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.ArrayAdapter.createFromResource
import android.widget.Toast
import com.example.myapplication.R
import kotlinx.android.synthetic.main.fragment_profile.*

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [Profile.newInstance] factory method to
 * create an instance of this fragment.
 */
class Profile : Fragment() {
    // TODO: Rename and change types of parameters
    private var param1: String? = null
    private var param2: String? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            param1 = it.getString(ARG_PARAM1)
            param2 = it.getString(ARG_PARAM2)
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_profile, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        /*notify_contact.setOnCheckedChangeListener(){_,_->
            Toast.makeText(context,"Contacts will be notified on button press",Toast.LENGTH_SHORT).show()
        }*/
    val spinner : ArrayAdapter<CharSequence> = createFromResource(requireContext(),R.array.Gender,android.R.layout.simple_spinner_item)
        spinner.setDropDownViewResource(android.R.layout.simple_spinner_item)
        gender.adapter = spinner
    }

    companion object {
        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @param param1 Parameter 1.
         * @param param2 Parameter 2.
         * @return A new instance of fragment Profile.
         */
        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            Profile().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }
    /*
    * {"timeCreated":{"seconds":1654608600,"nanoseconds":0},"sosType":0,
    * "status":"unresolved","message":"SOS (Default)","location":{"latitude":0,"longitude":0},
    * "clientDetails":{"phone":"987654321","gender":"female","name":"Anonymous"},"medInfo":{"bloodGroup":"B+"
    * ,"medHistory":"Any past medical conditions needed to be informed prior(Paragraph)"}}*/
}