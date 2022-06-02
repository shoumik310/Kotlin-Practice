/*
* Copyright (C) 2021 The Android Open Source Project.
*
* Licensed under the Apache License, Version 2.0 (the "License");
* you may not use this file except in compliance with the License.
* You may obtain a copy of the License at
*
*     http://www.apache.org/licenses/LICENSE-2.0
*
* Unless required by applicable law or agreed to in writing, software
* distributed under the License is distributed on an "AS IS" BASIS,
* WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
* See the License for the specific language governing permissions and
* limitations under the License.
*/
package com.example.dogglers.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.dogglers.R
import com.example.dogglers.data.DataSource

/**
 * Adapter to inflate the appropriate list item layout and populate the view with information
 * from the appropriate data source
 */
class DogCardAdapter(
    private val context: Context?,
    private val layout: Int
) : RecyclerView.Adapter<DogCardAdapter.DogCardViewHolder>() {

    // Initializing the data using the List found in data/DataSource
    private val dataSet = DataSource.dogs

    /**
     * Initialize view elements
     */
    class DogCardViewHolder(view: View?) : RecyclerView.ViewHolder(view!!) {
        // Declare and initialize all of the list item UI components
        val imageView: ImageView = view!!.findViewById(R.id.dog_image)
        val nameTextView: TextView = view!!.findViewById(R.id.dog_name)
        val ageTextView: TextView = view!!.findViewById(R.id.dog_age)
        val hobbiesTextView: TextView = view!!.findViewById(R.id.dog_hobbies)

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): DogCardViewHolder {
        // Use a conditional to determine the layout type and set it accordingly.
        //  if the layout variable is Layout.GRID the grid list item should be used. Otherwise the
        //  the vertical/horizontal list item should be used.
        val layoutId = when (layout) {
            3 -> R.layout.grid_list_item
            else -> R.layout.vertical_horizontal_list_item
        }

        // Inflate the layout
        val adaptorLayout = LayoutInflater.from(parent.context).inflate(layoutId, parent, false)

        // Null should not be passed into the view holder. This should be updated to reflect
        //  the inflated layout.
        return DogCardViewHolder(adaptorLayout)
    }

    override fun getItemCount(): Int = dataSet.size

    override fun onBindViewHolder(holder: DogCardViewHolder, position: Int) {
        // Get the data at the current position
        val item = dataSet[position]
        //Create resources variable
        val resources = context?.resources
        // Set the image resource for the current dog
        holder.imageView.setImageResource(item.imageResourceId)
        // Set the text for the current dog's name
        holder.nameTextView.text = item.name
        // Set the text for the current dog's age
        holder.ageTextView.text = resources?.getString(R.string.dog_age, item.age.toString())
        // Set the text for the current dog's hobbies by passing the hobbies to the
        //  R.string.dog_hobbies string constant.
        //  Passing an argument to the string resource looks like:
        //  resources?.getString(R.string.dog_hobbies, dog.hobbies)
        holder.hobbiesTextView.text = resources?.getString(R.string.dog_hobbies, item.hobbies.toString())
    }
}
