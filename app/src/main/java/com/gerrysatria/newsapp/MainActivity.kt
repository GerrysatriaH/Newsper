package com.gerrysatria.newsapp

import android.content.Intent
import android.graphics.drawable.Drawable
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import androidx.core.content.ContextCompat
import androidx.core.graphics.drawable.DrawableCompat
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import com.gerrysatria.newsapp.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private val listNews = ArrayList<News>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        listNews.addAll(getListNews())
        showAllListNews()
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.main_menu, menu)
        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            R.id.action_about -> {
                val toAboutActivity = Intent(this@MainActivity, AboutActivity::class.java)
                startActivity(toAboutActivity)
            }
        }
        return super.onOptionsItemSelected(item)
    }

    private fun getListNews() : ArrayList<News> {
        val dataTitle = resources.getStringArray(R.array.title_news)
        val dataPublishDate = resources.getStringArray(R.array.publish_date_news)
        val dataDescription = resources.getStringArray(R.array.description_news)
        val dataPhoto = resources.obtainTypedArray(R.array.photo_news)
        val dataSource = resources.getStringArray(R.array.source_news)

        val listNews = ArrayList<News>()
        for (i in dataTitle.indices) {
            val news = News(dataTitle[i], dataPublishDate[i], dataDescription[i], dataPhoto.getResourceId(i, -1), dataSource[i])
            listNews.add(news)
        }
        return listNews
    }

    private fun showAllListNews() {
        binding.rvNews.layoutManager = LinearLayoutManager(this)
        val listNewsAdapter = ListNewsAdapter(listNews)
        binding.rvNews.adapter = listNewsAdapter
    }
}