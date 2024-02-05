package com.example.gitrobotdreamslessonsfragmentshometasks

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.ListView
import androidx.fragment.app.Fragment

class ListFragment : Fragment() {
    private var onItemClick: (String) -> Unit = {}

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.list_fragment_layout, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val list:ListView = view.findViewById(R.id.listView)
        val items = arrayListOf<String>()
        repeat(100) { items.add("Element $it") }
        val adapter = ArrayAdapter(requireContext(),android.R.layout.simple_list_item_1, items)
        list.adapter = adapter
        list.onItemClickListener =
            AdapterView.OnItemClickListener { _,_,_, id -> onItemClick(id.toString())}

    }

    fun setItemsClickListener(lambda: (String) -> Unit){
        onItemClick = lambda
    }
}