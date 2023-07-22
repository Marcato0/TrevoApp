package com.trevo.trevoapp

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.TextView

class CustomMenuAdapter(private val context: Context, private val resource: Int, private val items: List<String>) : ArrayAdapter<String>(context, resource, items) {
    override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {
        val layoutInflater = LayoutInflater.from(context)
        val view = layoutInflater.inflate(resource, null)
        val textView = view.findViewById<TextView>(R.id.menu_item_text)
        textView.text = items[position]
        return view
    }
}
