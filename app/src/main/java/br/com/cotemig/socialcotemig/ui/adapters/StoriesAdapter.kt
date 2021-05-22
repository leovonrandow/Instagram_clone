package br.com.cotemig.socialcotemig.ui.adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.recyclerview.widget.RecyclerView
import br.com.cotemig.socialcotemig.R
import br.com.cotemig.socialcotemig.models.Stories
import coil.ImageLoader
import coil.load
import coil.request.ImageRequest
import coil.transform.CircleCropTransformation
import coil.transform.RoundedCornersTransformation
import com.bumptech.glide.load.resource.bitmap.CenterCrop

class StoriesAdapter(var context: Context, var stories: List<Stories>) :
    RecyclerView.Adapter<RecyclerView.ViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        var view = LayoutInflater.from(context).inflate(R.layout.item_stories, parent, false)
        return StoriesHolder(view);
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        (holder as StoriesHolder).bind(context, stories[position])
    }

    override fun getItemCount(): Int {
        return stories.size
    }

    class StoriesHolder(var view: View) : RecyclerView.ViewHolder(view) {
        fun bind(context: Context, stories: Stories) {
            var image = view.findViewById<ImageView>(R.id.imageStories)
            image.load(stories.avatar) {

                crossfade(true)
                placeholder(R.drawable.borda_insta)
                transformations(CircleCropTransformation())
            }
            var is_live = view.findViewById<ImageView>(R.id.live)

            if(stories.live)
                is_live.visibility = View.VISIBLE
            else
                is_live.visibility = View.GONE



        }
    }
}