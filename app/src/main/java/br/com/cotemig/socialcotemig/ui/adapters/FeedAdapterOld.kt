package br.com.cotemig.socialcotemig.ui.adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import br.com.cotemig.socialcotemig.R
import br.com.cotemig.socialcotemig.models.Post
import coil.load

class FeedAdapterOld(var context: Context, var list: List<Post>) :
    RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        var view = LayoutInflater.from(context).inflate(R.layout.item_feed, parent, false)
        return FeedHolder(view)
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        (holder as FeedHolder).bind(context, list[position])
    }

    override fun getItemCount(): Int {
        return list.size
    }

    class FeedHolder(var view: View) : RecyclerView.ViewHolder(view) {

        fun bind(context: Context, post: Post) {

            var username = view.findViewById<TextView>(R.id.username)
            username.text = post.user

            var image = view.findViewById<ImageView>(R.id.postImage)
            image.load(post.image)

        }

    }
}