package com.example.gitrobotdreamslessonsfragmentshometasks

import android.annotation.SuppressLint
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import io.reactivex.android.schedulers.AndroidSchedulers
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

    @SuppressLint("CheckResult")
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val recyclerView:RecyclerView = view.findViewById(R.id.recyclerView)
        val api = ApiClient.client.create(ApiInterface::class.java)

        api.getSuperHeroes()
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe ({
                if(it != null) {
                    val items = it
                    val myAdapter = SuperheroViewAdapter(items as MutableList<SuperHero>){
                        Log.e("SuccessfulResponse", "Items were received!")
                    }
                    recyclerView.adapter = myAdapter
                }
            },{
                Log.e("SuperHeroRequest", "Fetch error ${it.message} on response]")
            })

        recyclerView.apply {
            // set a LinearLayoutManager to handle Android RecyclerView behavior
            layoutManager = LinearLayoutManager(activity)
        }

        //recyclerView.OnItemClickListener{}
    }
    fun setItemsClickListener(lambda: (String) -> Unit){
        onItemClick = lambda
    }
}

