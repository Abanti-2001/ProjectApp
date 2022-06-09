package com.example.myapplication.sidebar

import android.annotation.SuppressLint
import android.os.Build
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import android.provider.ContactsContract
import com.example.myapplication.R
import android.widget.Toast
import com.example.myapplication.emergency_con.contacts
import com.example.myapplication.emergency_con.contacts_adapter
import com.example.myapplication.emergency_con.dummy_dataset
import kotlinx.android.synthetic.main.fragment_em_con.*


// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [Em_con.newInstance] factory method to
 * create an instance of this fragment.
 */
class Em_con : Fragment() {
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
        return inflater.inflate(R.layout.fragment_em_con, container, false)
    }

    companion object {
        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @param param1 Parameter 1.
         * @param param2 Parameter 2.
         * @return A new instance of fragment Em_con.
         */
        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            Em_con().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val contact_list = listOf(contacts(ContactsContract.Contacts.DISPLAY_NAME_PRIMARY.toString(),ContactsContract.Contacts.CONTACT_STATUS))

        contact_view.layoutManager=LinearLayoutManager(context)
        contact_view.adapter= contacts_adapter(contact_list
        ) { position -> onItemClick(position) }
    }
    private fun onItemClick(position: Int) {
        Toast.makeText(context, (position+1).toString(), Toast.LENGTH_SHORT).show()
    }
}