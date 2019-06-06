package com.example.application__test

import android.app.AlertDialog
import android.content.Context
import android.databinding.DataBindingUtil
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import com.example.application__test.databinding.RowMainBinding
import kotlinx.android.synthetic.main.row_main.view.*

class RecyclerViewAdapter (private  val context: Context, val activity: MainActivity) : RecyclerView.Adapter<RecyclerViewAdapter.NumberViewHolder>(){
    override fun onCreateViewHolder(p0: ViewGroup, p1: Int): NumberViewHolder{
        val layoutInflater = LayoutInflater.from(p0.context)
        val binding: RowMainBinding =
                DataBindingUtil.inflate(layoutInflater, R.layout.row_main, p0, false)
        return NumberViewHolder(binding)

    }
    override fun getItemCount(): Int {
        return activity.listNumber
    }

    override fun onBindViewHolder(p0: NumberViewHolder, p1 : Int){
        p0.bind(context,p1)
    }

    class NumberViewHolder(val binding: RowMainBinding): RecyclerView.ViewHolder(binding.root){
        fun bind(context: Context, p1: Int){
            binding.dataRow = RowMainTextModel("ยี่ห้อ BFGoodrich","ขนาด 215/45 R17 91V",
                "รุ่น Advantage T/A Drive","จำนวนคงเหลือ 100", "4,090.-")
            binding.btn1.text = "สั่งซื้อสินค้า"
            binding.btn1.setOnClickListener{
                val mAlertDialog = AlertDialog.Builder(context)
                mAlertDialog.setMessage("กดเเลือกซื้อสินค้ารายการที่ " + (p1 + 1) + " ตามลำดับรายการ")
                mAlertDialog.setPositiveButton("OK") { dialog, which ->
                }
                mAlertDialog.show()
            }
        }

    }

}
