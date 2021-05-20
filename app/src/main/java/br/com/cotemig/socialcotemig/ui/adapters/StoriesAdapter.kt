package br.com.cotemig.socialcotemig.ui.adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.recyclerview.widget.RecyclerView
import br.com.cotemig.socialcotemig.R
import br.com.cotemig.socialcotemig.models.PostImage
import br.com.cotemig.socialcotemig.models.Stories
import coil.load
import coil.transform.RoundedCornersTransformation

class StoriesAdapter(var context: Context,var stories: List<Stories>) :
    RecyclerView.Adapter<RecyclerView.ViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        var view = LayoutInflater.from(context).inflate(R.layout.item_stories, parent, false)
        return StoriesHolder(view);
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        (holder as StoriesHolder).bind(stories[position])
    }

    override fun getItemCount(): Int {
        return stories.size
    }

    class StoriesHolder(var view: View) : RecyclerView.ViewHolder(view) {
        fun bind(stories: Stories) {
            var image = view.findViewById<ImageView>(R.id.imageStories)
            image.load(stories.image){
                transformations(RoundedCornersTransformation(30f))
            }
        }
    }
}