package com.example.wishlistapp

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class WishlistAdapter(private val wishlistItems: MutableList<Wishlist>) : RecyclerView.Adapter<WishlistAdapter.ViewHolder>() {

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        val nameTextView: TextView
        val urlTextView: TextView
        val priceTextView: TextView

        // We also create a constructor that accepts the entire item row
        // and does the view lookups to find each sub-view
        init {
            // TODO: Store each of the layout's views into
            // the public final member variables created above
            nameTextView = itemView.findViewById(R.id.NameTv)
            urlTextView = itemView.findViewById(R.id.UrlTv)
            priceTextView = itemView.findViewById(R.id.PriceTv)
        }
    }


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): WishlistAdapter.ViewHolder {
        val context = parent.context
        val inflater = LayoutInflater.from(context)

        // Inflate the custom layout
        val contactView = inflater.inflate(R.layout.wishlist_item, parent, false)
        // Return a new holder instance
        return ViewHolder(contactView)
    }

    override fun onBindViewHolder(holder: WishlistAdapter.ViewHolder, position: Int) {
        // Get the data model based on position
        val wishlist = wishlistItems.get(position)
        // Set item views based on views and data model
        holder.nameTextView.text = wishlist.name
        holder.urlTextView.text = wishlist.url
        holder.priceTextView.text = wishlist.price



    }

    override fun getItemCount(): Int {
       return wishlistItems.size
    }

}
