package com.example.lab5_pnguye68

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class TipRecordAdapter(private val tipList: List<TipRecord>) :
    RecyclerView.Adapter<TipRecordAdapter.TipViewHolder>() {

    class TipViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val textViewDate: TextView = view.findViewById(R.id.textViewDate)
        val textViewDetails: TextView = view.findViewById(R.id.textViewDetails)
    }

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): TipRecordAdapter.TipViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.tip_record_item, parent, false)
        return TipViewHolder(view)
    }

    override fun onBindViewHolder(holder: TipRecordAdapter.TipViewHolder, position: Int) {
        val record = tipList[position]
        holder.textViewDate.text = record.date
        holder.textViewDetails.text = "Bill: \$%.2f | Tip: \$%.2f | Total: \$%.2f".format(
            record.billAmount, record.tipAmount, record.totalAmount
        )
    }

    override fun getItemCount() = tipList.size

}
