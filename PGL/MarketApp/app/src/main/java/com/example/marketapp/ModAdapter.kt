package com.example.marketapp

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.mod.view.*

class ModAdapter (val items : ArrayList<Mod>, val context: Context) : RecyclerView.Adapter<ViewHolder>() {

    // Gets the number of animals in the list
    override fun getItemCount(): Int {
        return items.size
    }

    // Inflates the item views
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(LayoutInflater.from(context).inflate(R.layout.mod, parent, false))
    }

    // Binds each animal in the ArrayList to a view
    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder?.modType?.text = items[position].name + "\n  Quantity: "+items[position].quantity;

        var aux = items[position].name.split(" ");
        var res = aux[0]+"_"+aux[1];

        when(res){
            "primed_ravage" -> holder?.imgMod.setImageResource(R.drawable.primed_ravage)
            "primed_flow" -> holder?.imgMod.setImageResource(R.drawable.primed_flow)
            "primed_regen" -> holder?.imgMod.setImageResource(R.drawable.primed_regen)
        }
    }
}

class ViewHolder (view: View) : RecyclerView.ViewHolder(view) {
    // Holds the TextView that will add each animal to
    var modType = view.desc_mod
    var imgMod = view.img_mod
}
