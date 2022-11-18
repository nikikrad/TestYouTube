package com.example.testyoutube

import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.MediaController
import android.widget.Toast
import android.widget.VideoView
import com.example.testyoutube.databinding.ActivityMainBinding
import com.google.android.youtube.player.YouTubeBaseActivity
import com.google.android.youtube.player.YouTubeInitializationResult
import com.google.android.youtube.player.YouTubePlayer
import com.google.android.youtube.player.YouTubePlayerView

class MainActivity : YouTubeBaseActivity() {

    private lateinit var youtubePlayerInit: YouTubePlayer.OnInitializedListener
    private lateinit var youtubePlayer: YouTubePlayerView
    private lateinit var binding: ActivityMainBinding

    var simpleVideoView: VideoView? = null

    // declaring a null variable for MediaController
    var mediaControls: MediaController? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)


        val videoId = intent.extras?.get("YTVideo").toString()


        youtubePlayerInit = object : YouTubePlayer.OnInitializedListener {
            override fun onInitializationSuccess(
                p0: YouTubePlayer.Provider?,
                p1: YouTubePlayer?,
                p2: Boolean
            ) {
                p1?.loadVideo("GOniB0Ykp1M")
                p1?.setFullscreen(true)
            }

            override fun onInitializationFailure(
                p0: YouTubePlayer.Provider?,
                p1: YouTubeInitializationResult?
            ) {
                Toast.makeText(applicationContext, "Fail", Toast.LENGTH_SHORT).show()
            }


        }

        binding.simpleVideoView.initialize(
            "AIzaSyCF1j71oYhcrKqet9yAOlRS2LA2iz05k3E",
            youtubePlayerInit
        )
    }
}