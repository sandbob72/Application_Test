package com.example.application__test

import android.content.Context
import android.support.v7.app.AlertDialog
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import kotlinx.android.synthetic.main.row_category_main.view.*

class RecyclerViewCategoryAdapter(private val context: Context, val activity: CategoryActivity) : RecyclerView.Adapter<NumberViewHolder>(){
    override fun onCreateViewHolder(p0: ViewGroup, p1: Int): NumberViewHolder {
        val layoutInflater = LayoutInflater.from(p0?.context)
        val cellForRow = layoutInflater.inflate(R.layout.row_category_main, p0, false)
        return NumberViewHolder(cellForRow)
    }

    override fun getItemCount(): Int {
        return activity.listNumber
    }

    override fun onBindViewHolder(p0: NumberViewHolder, p1: Int) {
        p0?.view?.text1?.text = "ยี่ห้อ BFGoodrich"
        p0?.view?.text2?.text = "ขนาด 215/45 R17 91V"
        p0?.view?.text3?.text = "รุ่น Advantage T/A Drive"
        p0?.view?.text4?.text = "จำนวนคงเหลือ 100"
        p0?.view?.text5?.text = "4,090.-"

        p0?.view?.btn1?.setOnClickListener(){
            //Toast.makeText(context, "กดเเลือกซื้อสินค้ารายการที่ "+ (p1+1) +" ตามลำดับรายการ", Toast.LENGTH_SHORT).show()
            val mAlertDialog = AlertDialog.Builder(context)
            mAlertDialog.setMessage("กดเเลือกซื้อสินค้ารายการที่ "+ (p1+1) +" ตามลำดับรายการ")
            mAlertDialog.setPositiveButton("OK"){
                    dialog, which ->
            }
            mAlertDialog.show()
        }
    }

}

class NumberViewHolder(val view: View): RecyclerView.ViewHolder(view){

}
