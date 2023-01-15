package com.baktiyar11.cryptoapplication.presentation.ui.adapter

import androidx.recyclerview.widget.DiffUtil
import com.baktiyar11.cryptoapplication.presentation.model.CoinInfoPresentation

class CoinInfoDiffCallback : DiffUtil.ItemCallback<CoinInfoPresentation>() {

    override fun areItemsTheSame(oldItem: CoinInfoPresentation, newItem: CoinInfoPresentation)
            : Boolean = oldItem.id == newItem.id

    override fun areContentsTheSame(oldItem: CoinInfoPresentation, newItem: CoinInfoPresentation)
            : Boolean = oldItem == newItem
}