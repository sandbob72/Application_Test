package com.example.application__test

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.support.v4.content.ContextCompat
import android.support.v4.view.ViewPager
import android.support.v7.app.AlertDialog
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.text.Html
import android.view.View
import android.view.ViewGroup
import android.widget.*
import kotlinx.android.synthetic.main.activity_main.*
import java.text.ParsePosition

class MainActivity : AppCompatActivity() {

    internal lateinit var viewPager: ViewPager
    lateinit var dotsLayout: LinearLayout
    lateinit var dots: Array<ImageView>

    lateinit var viewFlipper: ViewFlipper
    val image = arrayOf(R.drawable.ads_home1, R.drawable.ads_home2, R.drawable.ads_home3, R.drawable.ads_home4)

    var listNumber = 0
    var page = 0
    var isLoading = false
    var limit = 10

    lateinit var adapter: RecyclerViewAdapter
    lateinit var layoutManager: LinearLayoutManager


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


        //RecyclerView : LoadMore----------------------------------------------------------//
        layoutManager = LinearLayoutManager(this)
        recycleProduct.layoutManager = layoutManager
        getPage()

        recycleProduct.addOnScrollListener(object : RecyclerView.OnScrollListener(){
            override fun onScrolled(recyclerView: RecyclerView, dx: Int, dy: Int) {
                val visibleItemCount = layoutManager.childCount
                val pastVisibleItem = layoutManager.findFirstCompletelyVisibleItemPosition()
                val total = adapter.itemCount

                if (!isLoading)
                {
                    if ((visibleItemCount + pastVisibleItem) >= total)
                    {
                        page++
                        getPage()
                    }
                }
                super.onScrolled(recyclerView, dx, dy)
            }
        })
        //---------------------------------------------------------------------------------//

        //ImageButton to CategoryActivity---------------------------------------------------------//
        val btnOpenCategory1 = findViewById(R.id.category1) as ImageButton
        btnOpenCategory1.setOnClickListener(){
            val intent = Intent(this@MainActivity,  CategoryActivity :: class.java)
            startActivity(intent)
        }

        val btnOpenCategory2 = findViewById(R.id.category2) as ImageButton
        btnOpenCategory2.setOnClickListener(){
            val intent = Intent(this@MainActivity,  CategoryActivity :: class.java)
            startActivity(intent)
        }

        val btnOpenCategory3 = findViewById(R.id.category3) as ImageButton
        btnOpenCategory3.setOnClickListener(){
            val intent = Intent(this@MainActivity,  CategoryActivity :: class.java)
            startActivity(intent)
        }

        val btnOpenCategory4 = findViewById(R.id.category4) as ImageButton
        btnOpenCategory4.setOnClickListener(){
            val intent = Intent(this@MainActivity,  CategoryActivity :: class.java)
            startActivity(intent)
        }
        //ImageButton to CategoryActivity---------------------------------------------------------//


        //AlertDialog-----------------------------------------------------------------//
        layout1.setOnClickListener(){
            val mAlertDialog = AlertDialog.Builder(this@MainActivity)
            mAlertDialog.setMessage("กดค้นหา")
            mAlertDialog.setPositiveButton("OK"){
                    dialog, which ->
                //Toast.makeText(this@MainActivity, "กดค้นหา", Toast.LENGTH_SHORT).show()
            }
            mAlertDialog.show()
        }
        button_1.setOnClickListener(){
            val mAlertDialog = AlertDialog.Builder(this@MainActivity)
            mAlertDialog.setMessage("กดเสนอซื้อสินค้า")
            mAlertDialog.setPositiveButton("OK"){
                    dialog, which ->
            }
            mAlertDialog.show()
        }
        button_2.setOnClickListener(){
            val mAlertDialog = AlertDialog.Builder(this@MainActivity)
            mAlertDialog.setMessage("กดเสนอขายสินค้า")
            mAlertDialog.setPositiveButton("OK"){
                    dialog, which ->
            }
            mAlertDialog.show()
        }
        //AlertDialog-----------------------------------------------------------------//

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


    //RecycleView : LoadMore----------------------------------------------------------------------------------//
    fun getPage()
    {
        isLoading = true
        progressBar.visibility = View.VISIBLE
        val start = ((page)*limit)+1
        val end = (page+1) * limit

        for (i in start..end)
        {
            listNumber++
        }

        Handler() .postDelayed({
            if (::adapter.isInitialized){
                adapter.notifyDataSetChanged()
            }
            else
            {
                adapter = RecyclerViewAdapter(this,this)
                recycleProduct.adapter = adapter
            }
            isLoading =false
            progressBar.visibility = View.GONE
        },3000)
    }
    //RecycleView : LoadMore----------------------------------------------------------------------------------//

}
