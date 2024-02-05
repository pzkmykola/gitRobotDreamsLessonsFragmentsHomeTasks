package com.example.gitrobotdreamslessonsfragmentshometasks

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment

class DetailsFragment : Fragment() {
    private var description:String = ""
    var titleTextView: TextView? = null

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.details_fragment_layout, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        titleTextView = view.findViewById(R.id.details)
        titleTextView?.text = description
}
    fun setDescription(title:String){
        description = title
    }

    fun show(){
        titleTextView?.text = description
    }
}