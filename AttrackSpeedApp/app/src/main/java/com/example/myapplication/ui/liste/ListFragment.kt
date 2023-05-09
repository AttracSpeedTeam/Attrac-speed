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


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val dashboardViewModel =
            ViewModelProvider(
                this,
                ViewModelProvider.NewInstanceFactory()
            ).get(ListViewModel::class.java)

        val view = inflater.inflate(R.layout.fragment_liste, container, false)

        return view
    }

    override fun onDestroyView() {
        super.onDestroyView()
    }
}