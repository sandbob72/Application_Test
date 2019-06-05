package com.example.application__test

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v4.content.ContextCompat
import android.support.v4.view.ViewPager
import android.text.Html
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.LinearLayout
import java.text.ParsePosition

class MainActivity : AppCompatActivity() {

    internal lateinit var viewPager: ViewPager
    lateinit var dotsLayout: LinearLayout
    lateinit var dots: Array<ImageView>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //ViewPage-------------------------------------------------------
        viewPager = findViewById<View>(R.id.banner) as ViewPager
        viewPager.adapter = ViewPageAdapter(this)
        //---------------------------------------------------------------

        dotsLayout = findViewById(R.id.dotsLayout) as LinearLayout
        createDots(0)

        viewPager.addOnPageChangeListener(object : ViewPager.OnPageChangeListener{
            override fun onPageScrollStateChanged(p0: Int) {

            }

            override fun onPageScrolled(p0: Int, p1: Float, p2: Int) {

            }

            override fun onPageSelected(p0: Int) {
                createDots(p0)
            }

        })



    }

    fun createDots(position: Int){
        if (dotsLayout != null)
        {
            dotsLayout.removeAllViews()
        }
        dots = Array(2,{i -> ImageView(this) })

        for(i in 0..2 - 1)
        {
            dots[i] = ImageView(this)
            if (i == position)
            {
                dots[i].setImageDrawable(ContextCompat.getDrawable(this, R.drawable.activity_dots))
            }
            else
            {
                dots[i].setImageDrawable(ContextCompat.getDrawable(this, R.drawable.activity_indots))
            }
            var params: LinearLayout.LayoutParams = LinearLayout.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT)
            params.setMargins(4,0,4,0)
            dotsLayout.addView(dots[i],params)

        }
    }
}
