package com.example.gitrobotdreamslessonsfragmentshometasks

import android.annotation.SuppressLint
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.gitrobotdreamslessonsfragmentshometasks.SuperheroViewAdapter.*
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers

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
        val api = ApiClient.client.create(ApiInterface::class.java)

        api.getSuperHeroes()
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe ({
                if(it != null) {
                    val items = it
                    val myAdapter = SuperheroViewAdapter(items as MutableList<SuperHero>, clickListener = {item:SuperHero ->
                        val activity = activity as OnItemClickListener
                        activity.onClick(item)})
                    recyclerView.adapter = myAdapter
                    //Toast.makeText(requireContext(), "Maybe, listener was set",Toast.LENGTH_SHORT).show()
                }
            },{
                Log.e("SuperHeroRequest", "Fetch error ${it.message} on response]")
            })

        recyclerView.apply {
            // set a LinearLayoutManager to handle Android RecyclerView behavior
            layoutManager = LinearLayoutManager(activity)
        }
    }
}

