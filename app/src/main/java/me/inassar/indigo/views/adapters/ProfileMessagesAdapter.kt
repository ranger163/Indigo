package me.inassar.indigo.views.adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.profile_messaegs_item_row.view.*
import me.inassar.indigo.R
import me.inassar.indigo.dislike
import me.inassar.indigo.like
import me.inassar.indigo.models.ProfileMessagesModel
import me.inassar.indigo.utils.Utils

class ProfileMessagesAdapter(
    private val context: Context,
    private val itemData: List<ProfileMessagesModel>
) : RecyclerView.Adapter<ProfileMessagesAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(
            LayoutInflater.from(parent.context)
                .inflate(R.layout.profile_messaegs_item_row, parent, false)
        )
    }

    override fun getItemCount(): Int {
        return if (itemData.isNotEmpty()) {
            itemData.size
        } else
            0
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(itemData[position])
    }

    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        fun bind(
            item: ProfileMessagesModel
        ) {
            itemView.profileMessageAuthorTv.text = item.author
            itemView.profileMessageDateTv.text = item.date
            itemView.profileMessageTv.text = item.message
            itemView.profileMessageUserTagTv.text = item.userTag
            itemView.profileShareBtn.setOnClickListener {
                Utils.shareMessage(
                    context,
                    itemView.profileMessageCard
                )
            }
            itemView.profileLikeBtn.setOnCheckedChangeListener { buttonView, isChecked ->
                if (isChecked) {
                    buttonView.like()
                } else {
                    buttonView.dislike()
                }
            }
        }

    }
}