package com.example.gitrobotdreamslessonsfragmentshometasks

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

class MainActivity : AppCompatActivity(), OnItemClickListener {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
//        val listFragment =
//            supportFragmentManager.findFragmentById(R.id.listContainer) as ListFragment
//        val detailsFragment =
//            supportFragmentManager.findFragmentById(R.id.detailsContainer) as? DetailsFragment
//
//        listFragment.setOnItemsClickListener {
//            if (detailsFragment != null) {
//                detailsFragment.setDescription(it)
//                detailsFragment.show()
//            } else {
//                val detailsFragmentToAdd = DetailsFragment()
//                detailsFragmentToAdd.setDescription(it)
//                supportFragmentManager.beginTransaction()
//                    .add(R.id.listContainer, detailsFragmentToAdd)
//                    .addToBackStack("details_fragment")
//                    .commit()
//            }
//        }
    }

    override fun onClick(name: String) {
        val detailsFragmentToAdd = DetailsFragment()
        detailsFragmentToAdd.setDescription(name)
        supportFragmentManager.beginTransaction()
            .add(R.id.listContainer, detailsFragmentToAdd)
            .addToBackStack("details_fragment")
            .commit()
    }
}