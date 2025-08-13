package com.example.greenthumb

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.floatingactionbutton.FloatingActionButton

class MyPlantsFragment : Fragment() {

    // No parameters are needed, so we can remove the old boilerplate code.

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_my_plants, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        // 1. Find all the views from your new layout
        val recyclerView: RecyclerView = view.findViewById(R.id.plantsRecyclerView)
        val emptyView: LinearLayout = view.findViewById(R.id.emptyView)
        val fab: FloatingActionButton = view.findViewById(R.id.fabAddPlant)

        // 2. Initialize your PlantAdapter
        val plantAdapter = PlantAdapter()

        // 3. Set up the RecyclerView with a two-column grid
        recyclerView.adapter = plantAdapter
        recyclerView.layoutManager = GridLayoutManager(requireContext(), 2) // 2 columns

        // 4. Set the click listener for the FloatingActionButton to navigate
        fab.setOnClickListener {
            findNavController().navigate(R.id.action_myPlantsFragment_to_addPlantFragment)
        }

        // --- FOR TESTING ---
        // Create a dummy list to test the UI.
        // Later, this data will come from your Room Database.
        val dummyPlantList = listOf<Plant>() // An empty list to test the empty state
        // val dummyPlantList = listOf(Plant(1, "Test Plant", ...)) // Use this to test the grid

        // 5. Add logic to handle the empty state
        if (dummyPlantList.isEmpty()) {
            recyclerView.visibility = View.GONE  // Hide the list
            emptyView.visibility = View.VISIBLE // Show the empty message
        } else {
            recyclerView.visibility = View.VISIBLE // Show the list
            emptyView.visibility = View.GONE   // Hide the empty message
        }

        // Submit the list to the adapter to be displayed
        plantAdapter.submitList(dummyPlantList)
    }
}