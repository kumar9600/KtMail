package com.think42labs.ktgmail.ui

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.think42labs.ktgmail.BR
import com.think42labs.ktgmail.databinding.InboxItemsBinding
import com.think42labs.ktgmail.net.Response


/**
 * @author Vazhavanthakumar
 * @since 26/12/19
 */
class InboxAdapter(
    var inboxMessageList: List<Response>,
    var context: Context,
    var listener: ClickListener
) : RecyclerView.Adapter<InboxAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(
            DataBindingUtil.inflate(
                LayoutInflater.from(parent.context),
                com.think42labs.ktgmail.R.layout.inbox_items, parent, false
            )
        )
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        if (inboxMessageList.isNotEmpty()) {
            val inboxObj: Response = inboxMessageList[position]
            holder.bind(inboxObj)
            Glide.with(context).load("https://api.androidhive.info/json/google.png")
                .into(holder.binding.iconProfile)
            holder.binding.iconContainer.setOnClickListener { listener.onClickMessage(inboxObj.subject) }
        }
    }

    override fun getItemCount(): Int {
        return inboxMessageList.size
    }

    open class ViewHolder(itemView: InboxItemsBinding) : RecyclerView.ViewHolder(itemView.root) {

        var binding: InboxItemsBinding = itemView

        fun bind(`object`: Any) {
            binding.setVariable(BR.model, `object`)
            binding.executePendingBindings()
        }
    }

    interface ClickListener {
        fun onClickMessage(subject: String)
    }
}