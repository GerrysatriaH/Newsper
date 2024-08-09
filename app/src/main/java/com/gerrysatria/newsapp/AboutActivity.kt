package com.gerrysatria.newsapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem
import com.gerrysatria.newsapp.databinding.ActivityAboutBinding
import com.gerrysatria.newsapp.databinding.ActivityMainBinding

class AboutActivity : AppCompatActivity() {

    private lateinit var bindingAbout: ActivityAboutBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        bindingAbout = ActivityAboutBinding.inflate(layoutInflater)
        setContentView(bindingAbout.root)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        supportActionBar?.title = ""
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        if (item.itemId == android.R.id.home) {
            onBackPressed()
            return true
        }
        return super.onOptionsItemSelected(item)
    }
}