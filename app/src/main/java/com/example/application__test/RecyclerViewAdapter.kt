package com.example.application__test

import android.app.AlertDialog
import android.content.Context
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView

class RecyclerViewAdapter (private  val context: Context, val activity: MainActivity) : RecyclerView.Adapter<RecyclerViewAdapter.NumberViewHolder>(){
    override fun onCreateViewHolder(p0: ViewGroup, p1: Int): NumberViewHolder{
        return NumberViewHolder(LayoutInflater.from(activity).inflate(R.layout.row_main, p0 ,false))
    }
    override fun getItemCount(): Int {
        return activity.listname.size
    }

    override fun onBindViewHolder(p0: NumberViewHolder, p1 : Int){
        p0.text1.text = "ยี่ห้อ ${activity.listname[p1]}"
        p0.text2.text = "ขนาด ${activity.listsize[p1]}"
        p0.text3.text = "รุ่น Advantage T/A Drive"
        p0.text4.text = "จำนวนคงเหลือ 100"
        p0.text5.text = "4,090.-"
        p0.button.setOnClickListener() {
            //Toast.makeText(context, "กดเเลือกซื้อสินค้ารายการที่ "+ (p1+1) +" ตามลำดับรายการ", Toast.LENGTH_SHORT).show()
            val mAlertDialog = AlertDialog.Builder(context)
            mAlertDialog.setMessage("กดเเลือกซื้อสินค้ารายการที่ " + (p1 + 1) + " ตามลำดับรายการ")
            mAlertDialog.setPositiveButton("OK") { dialog, which ->
            }
            mAlertDialog.show()
        }
    }

    class NumberViewHolder(v: View): RecyclerView.ViewHolder(v){
        val text1 = v.findViewById<TextView>(R.id.text1)
        val text2 = v.findViewById<TextView>(R.id.text2)
        val text3 = v.findViewById<TextView>(R.id.text3)
        val text4 = v.findViewById<TextView>(R.id.text4)
        val text5 = v.findViewById<TextView>(R.id.text5)
        val button = v.findViewById<Button>(R.id.btn1)
    }

}
