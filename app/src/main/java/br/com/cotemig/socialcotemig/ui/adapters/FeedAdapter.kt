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
import coil.transform.RoundedCornersTransformation

class FeedAdapter(var context: Context, var list: List<Post>) :
    RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        var view = LayoutInflater.from(context).inflate(R.layout.item_feed, parent, false)
        return PostHolder(view)
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        (holder as PostHolder).bind(list[position])
    }

    override fun getItemCount(): Int {
        return list.size
    }

    class PostHolder(var view: View) : RecyclerView.ViewHolder(view) {

        fun bind(post: Post) {

            var username = view.findViewById<TextView>(R.id.username)
            username.text = post.user

            var locationName = view.findViewById<TextView>(R.id.locationName)
            locationName.text = post.local

            var date = view.findViewById<TextView>(R.id.date)
            date.text = post.date

            var description = view.findViewById<TextView>(R.id.description)
            description.text = post.description

            var avatar = view.findViewById<ImageView>(R.id.avatar)
            avatar.load(post.avatar) {
                transformations(RoundedCornersTransformation(50f))
            }

            var postImage = view.findViewById<ImageView>(R.id.postImage)
            // esse método load só existe quando utilizamos o coil
            // ele recebe a url da imagem para fazer o download
            postImage.load(post.image)

//            Glide.with(context).load(post.image).into(postImage)

        }

    }
}