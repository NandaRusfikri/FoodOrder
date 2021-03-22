package com.projectpro.foodorder.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.projectpro.foodorder.R
import com.projectpro.foodorder.data.remote.model.Menus
import com.projectpro.foodorder.data.remote.model.MenusItem
import java.text.NumberFormat
import java.util.*

class AdapterMenu : RecyclerView.Adapter<AdapterMenu.Holder>() {

    private var lsMenus: List<MenusItem> = emptyList()

    fun addList(menus: List<MenusItem>) {
        this.lsMenus = menus
        notifyDataSetChanged()
    }

    inner class Holder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        fun bind(menuLs: MenusItem) {
            val tvMenuName = itemView.findViewById<TextView>(R.id.tvMenuName)
            val tvDesc = itemView.findViewById<TextView>(R.id.tvDesc)
            val tvPrice = itemView.findViewById<TextView>(R.id.tvPrice)

            val localeID = Locale("in", "ID")
            val formatRupiah = NumberFormat.getCurrencyInstance(localeID)
            formatRupiah.maximumFractionDigits = 0


            val price = formatRupiah.format(menuLs.price)

            tvMenuName.text = menuLs.name
            tvDesc.text = menuLs.description
            tvPrice.text = price
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): Holder {
        return Holder(LayoutInflater.from(parent.context).inflate(R.layout.item_menus, parent, false))
    }

    override fun onBindViewHolder(holder: Holder, position: Int) {
        holder.bind(lsMenus[position])
    }

    override fun getItemCount(): Int {
        return lsMenus.size
    }

}