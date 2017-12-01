package com.komori.yixi.speech

import android.content.Context
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.komori.yixi.R
import com.komori.yixi.widget.HYTextView

/**
 * Created by KomoriWu
 * on 2017-12-01.
 */
class SpeechAdapter(private var mContext: Context) : RecyclerView.Adapter<SpeechAdapter.
SpeechViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup?, viewType: Int): SpeechViewHolder {
        val layoutInflater = LayoutInflater.from(mContext)
        return SpeechViewHolder(layoutInflater.inflate(R.layout.item_speech, parent,
                false))
    }

    override fun onBindViewHolder(holder: SpeechViewHolder?, position: Int) {
        holder?.text?.text = "item:" + position
    }

    class SpeechViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var text: HYTextView? = null

        init {
            text=itemView.findViewById(R.id.text)
        }
    }

    override fun getItemCount(): Int {
        return 10
    }
}