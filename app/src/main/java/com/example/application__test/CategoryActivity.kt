package com.example.application__test

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.support.v7.app.AlertDialog
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.view.View
import kotlinx.android.synthetic.main.activity_category.*
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.activity_main.progressBar
import kotlinx.android.synthetic.main.activity_main.recycleProduct

class CategoryActivity : AppCompatActivity() {

    var listNumber = 0
    var page =  0
    var isLoading = false
    var limit = 5

    lateinit var adapter: RecyclerViewCategoryAdapter
    lateinit var layoutManager: LinearLayoutManager

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_category)


        //RecyclerView : LoadMore-----------------------------------------------------------------------//
        layoutManager = LinearLayoutManager(this)
        recycleProduct.layoutManager = layoutManager
        getPage()

        recycleProduct.addOnScrollListener(object : RecyclerView.OnScrollListener(){
            override fun onScrolled(recyclerView: RecyclerView, dx: Int, dy: Int) {
                val visibleItemCount = layoutManager.childCount
                val pastVisibleItem = layoutManager.findFirstCompletelyVisibleItemPosition()
                val total = adapter.itemCount

                if (!isLoading) {
                    if ((visibleItemCount + pastVisibleItem) >= total){
                        page++
                        getPage()
                    }
                }
                super.onScrolled(recyclerView, dx, dy)
            }
        })
        //RecyclerView : LoadMore-----------------------------------------------------------------------//


        //AlertDialog-----------------------------------------------------------------//
        b1.setOnClickListener(){
            val mAlertDialog = AlertDialog.Builder(this@CategoryActivity)
            mAlertDialog.setMessage("กดเเมนูการกรอง")
            mAlertDialog.setPositiveButton("OK"){
                    dialog, which ->
            }
            mAlertDialog.show()
        }

        b2.setOnClickListener(){
            val mAlertDialog = AlertDialog.Builder(this@CategoryActivity)
            mAlertDialog.setMessage("กดเเมนูเรียงตาม")
            mAlertDialog.setPositiveButton("OK"){
                    dialog, which ->
            }
            mAlertDialog.show()
        }
        //AlertDialog-----------------------------------------------------------------//

    }

    //RecyclerView : LoadMore-----------------------------------------------------------------------//
    fun getPage()
    {
        isLoading = true
        progressBar.visibility = View.VISIBLE
        val start = ((page)*limit) + 1
        val end = (page + 1) * limit

        for (i in start..end)
        {
            listNumber++
        }
        Handler().postDelayed({
            if (::adapter.isInitialized)
            {
                adapter.notifyDataSetChanged()
            }
            else
            {
                adapter = RecyclerViewCategoryAdapter(this,this)
                recycleProduct.adapter = adapter
            }
            isLoading = false
            progressBar.visibility = View.GONE
        },3000)
    }
    //RecyclerView : LoadMore-----------------------------------------------------------------------//
}
