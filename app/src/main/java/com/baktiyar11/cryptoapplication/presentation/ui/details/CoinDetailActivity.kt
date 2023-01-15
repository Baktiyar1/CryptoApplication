package com.baktiyar11.cryptoapplication.presentation.ui.details

import android.content.Context
import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.baktiyar11.cryptoapplication.R
import com.baktiyar11.cryptoapplication.databinding.ActivityCoinDetailBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class CoinDetailActivity : AppCompatActivity() {

    private val binding by lazy { ActivityCoinDetailBinding.inflate(layoutInflater) }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
        if (checkSymbol()) return
        checkOrientation(savedInstanceState)
    }

    private fun checkOrientation(savedInstanceState: Bundle?) {
        if (savedInstanceState == null) supportFragmentManager.beginTransaction()
            .replace(R.id.fragment_container, CoinDetailFragment.newInstance(getSymbol())).commit()
    }

    private fun getSymbol() = intent.getStringExtra(EXTRA_FROM_SYMBOL) ?: EMPTY_SYMBOL

    private fun checkSymbol() = if (!intent.hasExtra(EXTRA_FROM_SYMBOL)) {
        finish()
        true
    } else false

    companion object {
        private const val EXTRA_FROM_SYMBOL = "fSym"
        private const val EMPTY_SYMBOL = ""

        fun newIntent(context: Context, fromSymbol: String): Intent {
            val intent = Intent(context, CoinDetailActivity::class.java)
            intent.putExtra(EXTRA_FROM_SYMBOL, fromSymbol)
            return intent
        }
    }
}