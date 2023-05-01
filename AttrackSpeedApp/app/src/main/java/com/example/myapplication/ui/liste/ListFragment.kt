package com.example.myapplication.ui.liste

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import android.support.v4.app.Fragment
import android.arch.lifecycle.ViewModelProvider
import android.support.design.widget.TabItem
import com.example.myapplication.R
import com.example.myapplication.code.ApiClient
import com.example.myapplication.databinding.FragmentListeBinding
import org.osmdroid.views.MapView

class ListFragment : Fragment() {

    private var _binding: FragmentListeBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val dashboardViewModel =
            ViewModelProvider(
                this,
                ViewModelProvider.NewInstanceFactory()
            ).get(ListViewModel::class.java)

        _binding = FragmentListeBinding.inflate(inflater, container, false)
        val root: View = binding.root

        //recup de la list d'attractions
        val lAttractions= ApiClient.RecupererListeAttraction()

        val viewListe = view?.findViewById<TabItem>(R.id.listeAttraction)



        return root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}