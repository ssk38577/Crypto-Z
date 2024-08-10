package com.example.cryptoz.Adapter

import android.content.Context
import android.icu.text.ConstrainedFieldPosition
import android.icu.text.DecimalFormat
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.bumptech.glide.Glide
import com.example.cryptoz.Model.CryptoModel
import com.example.cryptoz.R
import com.example.cryptoz.databinding.ViewholderWalletBinding


class CryptoListAdapter(private val items:MutableList<CryptoModel>):RecyclerView.Adapter<CryptoListAdapter.Viewholder>() {
    class Viewholder (val binding: ViewholderWalletBinding):RecyclerView.ViewHolder(binding.root)

    private lateinit var context:Context
    var formatter:DecimalFormat?=null

    override fun onCreateViewHolder(parent:ViewGroup, viewType: Int): CryptoListAdapter.Viewholder {
        context = parent.context
        formatter= DecimalFormat("###,###,###,###")
        val binding = ViewholderWalletBinding.inflate(LayoutInflater.from(context),parent,false)
        return Viewholder(binding)
    }

    override fun onBindViewHolder(holder: CryptoListAdapter.Viewholder, position: Int) {
            val item =items[position]
        holder.binding.cryptoNameTxt.text=item.Symbol
        holder.binding.cryptoPriceTxt.text="$" + formatter?.format(item.Price)
        holder.binding.changePercentTxt.text=item.ChangePercent.toString()+"%"
        holder.binding.propertySizeTxt.text=item.AmountNumber.toString() + item.ShortSymbol.replace("/USDT","")
        holder.binding.propertyAmountTxt.text="$"+ formatter?.format(item.AmountDoller)
        if(item.ChangePercent<0) holder.binding.changePercentTxt.setTextColor(
            context.resources.getColor(R.color.red)
        )
        val drawableResourceId = holder.itemView.resources.getIdentifier(
            item.SymbolLogo,
            "drawable",
            holder.itemView.context.packageName
        )
        Glide.with(context)
            .load(drawableResourceId)
            .into(holder.binding.logoimg)
    }

    override fun getItemCount(): Int = items.size
}