package com.example.gitrobotdreamslessonsfragmentshometasks

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val listFragment =
            supportFragmentManager.findFragmentById(R.id.listContainer) as ListFragment
        val detailsFragment =
            supportFragmentManager.findFragmentById(R.id.detailsContainer) as? DetailsFragment
        listFragment.setItemsClickListener {
            if (detailsFragment != null) {
                detailsFragment.setDescription(it)
                detailsFragment.show()
            } else {
                val detailsFragmentToAdd = DetailsFragment()
                detailsFragmentToAdd.setDescription(it)
                supportFragmentManager.beginTransaction()
                    .add(R.id.listContainer, detailsFragmentToAdd)
                    .addToBackStack("details_fragment")
                    .commit()
            }
        }
    }
}