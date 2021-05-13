package br.com.cotemig.socialcotemig.ui.activites

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import br.com.cotemig.socialcotemig.R
import br.com.cotemig.socialcotemig.models.Post
import br.com.cotemig.socialcotemig.services.RetrofitInitializer
import br.com.cotemig.socialcotemig.ui.adapters.FeedAdapter
import retrofit2.Call
import retrofit2.Response

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        getFeed()
    }

    fun getFeed() {

        var s = RetrofitInitializer().serviceFeed()
        var call = s.getFeed()

        call.enqueue(object : retrofit2.Callback<List<Post>> {

            override fun onResponse(call: Call<List<Post>>, response: Response<List<Post>>) {
                if (response.code() == 200) {

                    response.body()?.let {
                        showFeed(it)
                    }

                }
            }

            override fun onFailure(call: Call<List<Post>>, t: Throwable) {
                Toast.makeText(this@MainActivity, "Ops", Toast.LENGTH_LONG).show()
            }
        })

    }

    fun showFeed(list: List<Post>) {

        var recyclerViewFeed = findViewById<RecyclerView>(R.id.recyclerViewFeed)
        recyclerViewFeed.adapter = FeedAdapter(this, list)
        recyclerViewFeed.layoutManager =
            LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false)

    }

}