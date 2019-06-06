package com.example.application__test

import android.content.Context
import android.databinding.DataBindingUtil
import android.renderscript.ScriptGroup
import android.support.v7.app.AlertDialog
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.application__test.databinding.RowCategoryMainBinding
import kotlinx.android.synthetic.main.row_category_main.view.*

class RecyclerViewCategoryAdapter(private val context: Context, val activity: CategoryActivity) : RecyclerView.Adapter<NumberViewHolder>(){
    override fun onCreateViewHolder(p0: ViewGroup, p1: Int): NumberViewHolder {
        val layoutInflater = LayoutInflater.from(p0.context)
        val binding: RowCategoryMainBinding = DataBindingUtil.inflate(layoutInflater, R.layout.row_category_main, p0,false)
        return NumberViewHolder(binding)
    }

    override fun getItemCount(): Int {
        return activity.listNumber
    }

    override fun onBindViewHolder(p0: NumberViewHolder, p1: Int) {
        p0.bind(context,p1)
    }

}

class NumberViewHolder(val binding: RowCategoryMainBinding): RecyclerView.ViewHolder(binding.root){
    fun bind(context: Context, p1: Int){
        binding.dataRowCategory = RowCategoryTextModel("ยี่ห้อ BFGoodrich","ขนาด 215/45 R17 91V",
            "รุ่น Advantage T/A Drive","จำนวนคงเหลือ 100", "4,090.-")
        binding.btn1.text = "สั่งซื้อสินค้า"
        binding.btn1.setOnClickListener{
            val mAlertDialog = android.app.AlertDialog.Builder(context)
            mAlertDialog.setMessage("กดเเลือกซื้อสินค้ารายการที่ " + (p1 + 1) + " ตามลำดับรายการ")
            mAlertDialog.setPositiveButton("OK") { dialog, which ->
            }
            mAlertDialog.show()
        }
    }

}
