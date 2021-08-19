package com.example.jetpackdemo

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.example.jetpackdemo.fragment.FragmentTabActivity
import com.example.jetpackdemo.fragment.FragmentTabActivity2

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        findViewById<View>(R.id.btn_fragment_tab_host)?.setOnClickListener {
            startActivity(Intent(this, FragmentTabActivity::class.java))
        }
        findViewById<View>(R.id.btn_fragment_view_pager)?.setOnClickListener {
            startActivity(Intent(this, FragmentTabActivity2::class.java))
        }
    }
}