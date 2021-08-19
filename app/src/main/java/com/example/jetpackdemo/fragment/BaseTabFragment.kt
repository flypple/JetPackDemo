package com.example.jetpackdemo.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import com.example.jetpackdemo.R

open class BaseTabFragment: Fragment() {

    companion object {
        fun newInstance(bundle: Bundle?): BaseTabFragment {
            val args = Bundle()
            bundle?.run {
                args.putAll(this)
            }
            val fragment = BaseTabFragment()
            fragment.arguments = args
            return fragment
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        container?.run {
            val view = inflater.inflate(R.layout.fragment_base_tab, container, false)
            val textView = view.findViewById<TextView>(R.id.text_view)
            arguments?.let {
                val fragmentTitle = it.getString("fragment_title")
                textView.text = fragmentTitle
            }
            return view
        }

        return null
    }
}