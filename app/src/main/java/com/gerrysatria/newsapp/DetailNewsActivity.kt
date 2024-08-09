package com.gerrysatria.newsapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import com.gerrysatria.newsapp.databinding.ActivityDetailNewsBinding

class DetailNewsActivity : AppCompatActivity() {

    private lateinit var binding : ActivityDetailNewsBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDetailNewsBinding.inflate(layoutInflater)
        setContentView(binding.root)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        supportActionBar?.title = ""

        getDetailData()

        val shareTitle = intent.getStringExtra("title")
        val shareDescription = intent.getStringExtra("description")

        binding.actionShare.setOnClickListener {
            val shareIntent = Intent(Intent.ACTION_SEND)

            shareIntent.type = "text/plain"
            shareIntent.putExtra(Intent.EXTRA_SUBJECT, title)
            shareIntent.putExtra(Intent.EXTRA_TEXT, "$shareTitle \n\n $shareDescription")

            startActivity(Intent.createChooser(shareIntent, "Bagikan via"))
        }
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        if (item.itemId == android.R.id.home) {
            onBackPressed()
            return true
        }
        return super.onOptionsItemSelected(item)
    }

    private fun getDetailData() {
        val title = intent.getStringExtra("title")
        val publishDate = intent.getStringExtra("publishDate")
        val description = intent.getStringExtra("description")
        val source = intent.getStringExtra("source")
        val photo = intent.getIntExtra("photo", 0)

        binding.tvTitle.text = title
        binding.tvPublishDate.text = "Publish by $publishDate"
        binding.tvDescription.text = description
        binding.imgDetailNews.setImageResource(photo)
        binding.tvSource.text = "Source : $source"
    }
}