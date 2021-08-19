package com.example.jetpackdemo.fragment

import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentPagerAdapter
import androidx.viewpager.widget.ViewPager
import com.example.jetpackdemo.R
import com.google.android.material.tabs.TabLayout

class FragmentTabActivity2: AppCompatActivity() {

    private val specs = arrayOf("首页", "视频", "搜索", "我的")
    private val icons = arrayOf(
        R.drawable.home_tab_selector,
        R.drawable.video_tab_selector,
        R.drawable.search_tab_selector,
        R.drawable.mine_tab_selector
    )

    private val fragments = arrayListOf<Fragment>()

    private var viewpager: ViewPager? = null
    private var tabLayout: TabLayout? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_fragment_tab_2)
        viewpager = findViewById(R.id.view_pager_2)
        tabLayout = findViewById(R.id.tab_layout)

        // 初始化Fragment
        for ((index, value) in specs.withIndex()) {
            fragments.add(createFragment(index, value))
        }

        // 初始化Adapter
        viewpager?.adapter = object : FragmentPagerAdapter(supportFragmentManager, BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT) {

            override fun getCount(): Int {
                return specs.size
            }

            override fun getItem(position: Int): Fragment {
                return fragments[position]
            }
        }

        tabLayout?.setupWithViewPager(viewpager)
        tabLayout?.setSelectedTabIndicator(null)

        // 初始化Fragment
        for ((index, value) in specs.withIndex()) {
            addTabItem(index, value)
        }

        tabLayout?.run {
            selectTab(getTabAt(0))
        }
    }

    private fun addTabItem(index: Int, title: String) {
        tabLayout?.let {
            val itemView =
                layoutInflater.inflate(R.layout.fragment_tab_host_item, null, false)
            var ivTabIcon = itemView.findViewById<ImageView>(R.id.iv_tab_icon)
            var tvTabTitle = itemView.findViewById<TextView>(R.id.tv_tab_title)
            ivTabIcon.setImageResource(icons[index])
            tvTabTitle.text = title
            it.getTabAt(index)?.customView = itemView
        }
    }

    private fun createFragment(index: Int, title: String): BaseTabFragment {

        val bundle = Bundle()
        bundle.putString("fragment_title", title)

        val fragment = BaseTabFragment.newInstance(bundle)
        return fragment;
    }
}