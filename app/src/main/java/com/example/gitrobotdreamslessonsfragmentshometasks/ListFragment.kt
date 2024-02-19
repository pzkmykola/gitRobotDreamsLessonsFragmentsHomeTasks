package com.example.gitrobotdreamslessonsfragmentshometasks

import android.annotation.SuppressLint
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.gitrobotdreamslessonsfragmentshometasks.SuperheroViewAdapter.*

class ListFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.list_fragment_layout, container, false)
    }

    @SuppressLint("CheckResult")
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val recyclerView:RecyclerView = view.findViewById(R.id.recyclerView)
        val viewModel = ViewModelProvider(this@ListFragment)[MyViewModel::class.java]
        viewModel.getData()

        viewModel.uiState.observe(viewLifecycleOwner) {
            when (it) {
                is MyViewModel.UIState.Empty -> {}
                is MyViewModel.UIState.Processing -> {}

                is MyViewModel.UIState.Result -> {
                    val items = it.list
                    val myAdapter = SuperheroViewAdapter(
                        items as MutableList<SuperHero>,
                        clickListener = { item: SuperHero ->
                            val activity = activity as OnItemClickListener
                            activity.onClick(item)
                        })
                    recyclerView.adapter = myAdapter
                    recyclerView.apply {
                        // set a LinearLayoutManager to handle Android RecyclerView behavior
                        layoutManager = LinearLayoutManager(activity)
                    }
                }
            }
        }
    }
}

