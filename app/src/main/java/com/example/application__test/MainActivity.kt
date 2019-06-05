package com.example.application__test

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v4.content.ContextCompat
import android.support.v4.view.ViewPager
import android.support.v7.widget.LinearLayoutManager
import android.text.Html
import android.view.View
import android.view.ViewGroup
import android.widget.AdapterViewFlipper
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.ViewFlipper
import kotlinx.android.synthetic.main.activity_main.*
import java.text.ParsePosition

class MainActivity : AppCompatActivity() {

    internal lateinit var viewPager: ViewPager
    lateinit var dotsLayout: LinearLayout
    lateinit var dots: Array<ImageView>

    lateinit var viewFlipper: ViewFlipper
    val image = arrayOf(R.drawable.ads_home1, R.drawable.ads_home2, R.drawable.ads_home3, R.drawable.ads_home4)

    var listNumber = 20


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //ViewPage-------------------------------------------------------//
        viewPager = findViewById<View>(R.id.banner) as ViewPager
        viewPager.adapter = ViewPageAdapter(this)
        //---------------------------------------------------------------//


        //ViewPage: Add Indicator---------------------------------------------------------//
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
        //---------------------------------------------------------------------------------//


        //ViewFlipper: Auto Slider Image---------------------------------------------------//
        viewFlipper = findViewById(R.id.ads_home)
        for (i in 0 until image.size)
        {
            flip_image(image[i])
        }
        //---------------------------------------------------------------------------------//


        recycleProduct.layoutManager = LinearLayoutManager(this)
        recycleProduct.adapter = RecyclerViewAdapter(this,this)

    }

    //createDots----------------------------------------------------------------------------------------------//
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
    //createDots----------------------------------------------------------------------------------------------//


    //ViewFlipper : Auto Slider Image-------------------------------------------------------------------------//
    fun flip_image(i : Int)
    {
        val view = ImageView(this)
        view.setBackgroundResource(i)
        viewFlipper.addView(view)
        viewFlipper.setFlipInterval(3000)
        viewFlipper.isAutoStart = true
        viewFlipper.setInAnimation(this, android.R.anim.slide_in_left)
        viewFlipper.setOutAnimation(this, android.R.anim.slide_out_right)
    }
    //ViewFlipper : Auto Slider Image-------------------------------------------------------------------------//
}
