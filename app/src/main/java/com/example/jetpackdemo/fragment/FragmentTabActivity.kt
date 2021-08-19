package com.example.jetpackdemo.fragment

import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.FragmentTabHost
import com.example.jetpackdemo.R

class FragmentTabActivity: AppCompatActivity() {

    private val specs = arrayOf("首页", "视频", "搜索", "我的")
    private val icons = arrayOf(
        R.drawable.home_tab_selector,
        R.drawable.video_tab_selector,
        R.drawable.search_tab_selector,
        R.drawable.mine_tab_selector
    )

    private var fragmentTabHost: FragmentTabHost? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_fragment_tab)
        fragmentTabHost = findViewById<FragmentTabHost>(R.id.fragment_tab_host)
        fragmentTabHost?.setup(this, supportFragmentManager, R.id.fragment_container_view)
        for ((index, value) in specs.withIndex()) {
            addFragment(index, value)
        }
        fragmentTabHost?.currentTab = 0
    }

    private fun addFragment(index: Int, title: String) {
        if (fragmentTabHost == null) {
            return
        }
        val itemView =
            layoutInflater.inflate(R.layout.fragment_tab_host_item, null, false)
        var ivTabIcon = itemView.findViewById<ImageView>(R.id.iv_tab_icon)
        var tvTabTitle = itemView.findViewById<TextView>(R.id.tv_tab_title)
        ivTabIcon.setImageResource(icons[index])
        tvTabTitle.text = title
        val indicator = fragmentTabHost?.newTabSpec(title)?.setIndicator(itemView)
        indicator?.let {
            val bundle = Bundle()
            bundle.putString("fragment_title", title)
            fragmentTabHost?.addTab(it, BaseTabFragment::class.java, bundle)
        }
    }
}