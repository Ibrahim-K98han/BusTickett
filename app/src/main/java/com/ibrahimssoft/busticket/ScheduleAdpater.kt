package com.ibrahimssoft.busticket

import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.PopupMenu
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.ibrahimssoft.busticket.databinding.SchedulRowBinding

class ScheduleAdpater(val favoritCallback:(BusSchedule)->Unit, val menuClickCallback:(BusSchedule, RowAction)->Unit)
    :ListAdapter<BusSchedule, ScheduleAdpater.BusScheduleViewHolder>(BusScheduleDiffUtil()){

    class BusScheduleViewHolder(val binding:SchedulRowBinding):RecyclerView.ViewHolder(binding.root){
        fun bind(busSchedule: BusSchedule){
            binding.schedule = busSchedule
        }
    }

    class BusScheduleDiffUtil:DiffUtil.ItemCallback<BusSchedule>(){
        override fun areItemsTheSame(oldItem: BusSchedule, newItem: BusSchedule): Boolean {
            return oldItem.id == newItem.id
        }

        override fun areContentsTheSame(oldItem: BusSchedule, newItem: BusSchedule): Boolean {
            return oldItem == newItem
        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BusScheduleViewHolder {
        val binding = SchedulRowBinding.inflate(
            LayoutInflater.from(parent.context),parent,false)
        return BusScheduleViewHolder(binding)
    }

    override fun onBindViewHolder(holder: BusScheduleViewHolder, position: Int) {
        val busSchedule = getItem(position)
        holder.bind(busSchedule)
        val btn = holder.binding.menuBtn
        holder.binding.menuBtn.setOnClickListener{
            val popupMenu = PopupMenu(btn.context,btn)
            popupMenu.menuInflater.inflate(R.menu.row_menu,popupMenu.menu)
            popupMenu.show()
            popupMenu.setOnMenuItemClickListener {
                val action:RowAction = when(it.itemId){
                    R.id.item_edit -> RowAction.EDIT
                    R.id.item_delete -> RowAction.DELETE
                    else -> RowAction.NONE
                }
                menuClickCallback(busSchedule, action)
                true
            }
        }
        holder.binding.favoritId.setOnClickListener {
            busSchedule.favorit = !busSchedule.favorit
            holder.bind(busSchedule)
            favoritCallback(busSchedule)
        }
    }
}

enum class RowAction{
    EDIT, DELETE,NONE
}