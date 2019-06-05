package com.example.application__test

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.view.View
import android.widget.ImageView

class Intro_Activity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_intro)

        window.decorView.systemUiVisibility = View.SYSTEM_UI_FLAG_HIDE_NAVIGATION or
                View.SYSTEM_UI_FLAG_LAYOUT_STABLE or
                View.SYSTEM_UI_FLAG_LAYOUT_HIDE_NAVIGATION or
                View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN or
                View.SYSTEM_UI_FLAG_FULLSCREEN or
                View.SYSTEM_UI_FLAG_IMMERSIVE_STICKY

        Handler().postDelayed({
            val intent = Intent(this@Intro_Activity,  MainActivity :: class.java)
            startActivity(intent)
        },3000)

        val btnOpenHome = findViewById(R.id.home) as ImageView
        btnOpenHome.setOnClickListener(){
            val intent = Intent(this@Intro_Activity,  MainActivity :: class.java)
            startActivity(intent)
        }
    }
}
