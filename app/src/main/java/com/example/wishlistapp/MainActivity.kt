package com.example.wishlistapp

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {

    private lateinit var recyclerView: RecyclerView
    private lateinit var adapter: WishlistAdapter
    private val wishlistItems = mutableListOf<Wishlist>()

    //Referencing user input fields
    private lateinit var editItemName: EditText
    private lateinit var editItemPrice: EditText
    private lateinit var editItemUrl: EditText
    private lateinit var buttonAddItem: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        val wishlistRv = findViewById<RecyclerView>(R.id.wishlistRv)
        recyclerView.layoutManager = LinearLayoutManager(this)
        adapter = WishlistAdapter(wishlistItems)
        recyclerView.adapter = adapter

        // Initialize user input fields
        editItemName = findViewById(R.id.item_name_input)
        editItemPrice = findViewById(R.id.price_input)
        editItemUrl = findViewById(R.id.website_input)
        buttonAddItem = findViewById(R.id.button)

        buttonAddItem.setOnClickListener {
            val name = editItemName.text.toString().trim()
            val price = editItemPrice.text.toString().trim()
            val url = editItemUrl.text.toString().trim()

            if (name.isNotEmpty() && price.isNotEmpty() && url.isNotEmpty()) {
                // Create a new Wishlist object
                val newItem = Wishlist(name, price, url)
                // Add the item to the list
                wishlistItems.add(newItem)
                // Notify the adapter to update the RecyclerView
                adapter.notifyItemInserted(wishlistItems.size - 1)

                // Clear the input fields for the next entry
                editItemName.text.clear()
                editItemPrice.text.clear()
                editItemUrl.text.clear()
            }
        }
    }
}
