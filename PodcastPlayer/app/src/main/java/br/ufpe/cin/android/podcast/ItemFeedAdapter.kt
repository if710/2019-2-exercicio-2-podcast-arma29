package br.ufpe.cin.android.podcast

import androidx.recyclerview.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import android.widget.Toast
import android.widget.Button

// Custom Adapter - Bind and Inits the holder
class ItemFeedAdapter (private val itemsFeedList: List<ItemFeed>) :
    RecyclerView.Adapter<ItemFeedAdapter.ItemFeedViewHolder>(){

    class ItemFeedViewHolder(view: View): RecyclerView.ViewHolder(view){
        fun findViews(item: ItemFeed){
            val btn_download = itemView.findViewById<Button>(R.id.item_action)
            btn_download.setOnClickListener{
                Toast.makeText(
                    itemView.context,
                    "Wait until download finishes",
                    Toast.LENGTH_SHORT).show()
            }
            itemView.findViewById<TextView>(R.id.item_title).text = item.title
            itemView.findViewById<TextView>(R.id.item_date).text = item.pubDate

        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemFeedViewHolder {
        val view = LayoutInflater
            .from(parent.context)
            .inflate(R.layout.itemlista, parent, false)
        return ItemFeedViewHolder(view)
    }

    override fun onBindViewHolder(holder: ItemFeedViewHolder, position: Int) {
        holder.findViews(itemsFeedList[position])
    }

    override fun getItemCount(): Int = itemsFeedList.size


}

