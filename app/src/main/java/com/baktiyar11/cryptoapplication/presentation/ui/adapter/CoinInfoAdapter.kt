package com.baktiyar11.cryptoapplication.presentation.ui.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import com.baktiyar11.cryptoapplication.R
import com.baktiyar11.cryptoapplication.databinding.ItemCoinInfoBinding
import com.baktiyar11.cryptoapplication.presentation.model.CoinInfoPresentation
import com.squareup.picasso.Picasso

class CoinInfoAdapter(private val context: Context) :
    ListAdapter<CoinInfoPresentation, CoinInfoViewHolder>(CoinInfoDiffCallback()) {

    var onCoinClickListener: ((CoinInfoPresentation) -> Unit)? = null

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CoinInfoViewHolder =
        CoinInfoViewHolder(ItemCoinInfoBinding.inflate(LayoutInflater.from(parent.context),
            parent, false))

    override fun onBindViewHolder(holder: CoinInfoViewHolder, position: Int) {
        val coin = getItem(position)
        holder.binding.apply {
            tvSymbols.text = String.format(context.resources.getString(R.string.symbols_template),
                coin.fromSymbol, coin.toSymbol)
            tvPrice.text = coin.price
            tvLastUpdate.text = String.format(context.resources
                .getString(R.string.last_update_template), coin.lastUpdate)
            Picasso.get().load(coin.imageUrl).into(ivLogoCoin)
        }
        holder.itemView.setOnClickListener { onCoinClickListener?.invoke(getItem(position)) }
    }
}