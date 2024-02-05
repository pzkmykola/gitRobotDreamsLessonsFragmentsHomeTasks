package com.example.gitrobotdreamslessonsfragmentshometasks

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.ListView
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.RecyclerView
import io.reactivex.Scheduler
import io.reactivex.schedulers.Schedulers

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
        val recyclerView:RecyclerView = view.findViewById(R.id.recyclerView)
        val api = ApiClient.client.create(ApiInterface::class.java)

        api.getSuperHeroes()
            .subscribeOn(Schedulers.io())
            .subscribe({
                Log.e("SuccessfulResponse","Items were received!")
            },{
                Log.e("SuperHeroRequest", "Fetch error ${it.message} on response]")
            })
        /*val view:RecyclerView = view.findViewById(R.id.recyclerView)
        val items = arrayListOf<String>()
        repeat(100) { items.add("Element $it") }
        val adapter = RecyclerViewA
        view.adapter = adapter
        list.onItemClickListener =
            AdapterView.OnItemClickListener { _,_,_, id -> onItemClick(id.toString())}*/

    }

    fun setItemsClickListener(lambda: (String) -> Unit){
        onItemClick = lambda
    }
}