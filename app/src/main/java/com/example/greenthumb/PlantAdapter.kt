package com.example.greenthumb

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView

class PlantAdapter : ListAdapter<Plant, PlantAdapter.PlantViewHolder>(PlantDiffCallback()) {

    class PlantViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        private val plantNameTextView: TextView = itemView.findViewById(R.id.plantNameTextView)

        fun bind(plant: Plant) {
            plantNameTextView.text = plant.name
            // You'll add code here later to load the image
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PlantViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_plant_card, parent, false)
        return PlantViewHolder(view)
    }

    override fun onBindViewHolder(holder: PlantViewHolder, position: Int) {
        holder.bind(getItem(position))
    }
}

class PlantDiffCallback : DiffUtil.ItemCallback<Plant>() {
    override fun areItemsTheSame(oldItem: Plant, newItem: Plant): Boolean {
        return oldItem.id == newItem.id
    }

    override fun areContentsTheSame(oldItem: Plant, newItem: Plant): Boolean {
        return oldItem == newItem
    }
}
class PlantViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
    // Find all the new views from the new layout
    private val plantImageView: ImageView = itemView.findViewById(R.id.plantImageView)
    private val plantNameTextView: TextView = itemView.findViewById(R.id.plantNameTextView)
    private val plantSpeciesTextView: TextView = itemView.findViewById(R.id.plantSpeciesTextView)
    private val wateringStatusIcon: ImageView = itemView.findViewById(R.id.wateringStatusIcon)

    fun bind(plant: Plant) {
        plantNameTextView.text = plant.name
        plantSpeciesTextView.text = plant.species

        // TODO: Add logic to set the plant image using a library like Glide or Coil
        // TODO: Add logic to change the color of the wateringStatusIcon based on the watering date
    }
}