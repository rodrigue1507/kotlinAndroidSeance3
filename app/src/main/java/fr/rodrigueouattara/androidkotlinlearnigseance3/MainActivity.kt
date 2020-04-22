package fr.rodrigueouattara.androidkotlinlearnigseance3

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import dmax.dialog.SpotsDialog
import fr.rodrigueouattara.androidkotlinlearnigseance3.Adapter.MyMovieAdapter
import fr.rodrigueouattara.androidkotlinlearnigseance3.Common.Common
import fr.rodrigueouattara.androidkotlinlearnigseance3.Interface.RetrofitService
import fr.rodrigueouattara.androidkotlinlearnigseance3.models.Movie
import kotlinx.android.synthetic.main.activity_main.*
import retrofit2.Call
import retrofit2.Response
import android.app.AlertDialog

class MainActivity : AppCompatActivity() {
    lateinit var mService: RetrofitService
    lateinit var layoutManager: LinearLayoutManager
    lateinit var adapter: MyMovieAdapter
    lateinit var dialog: AlertDialog

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        mService = Common.retrofitService

        recyclerMovieList.setHasFixedSize(true)
        layoutManager = LinearLayoutManager(this)
        recyclerMovieList.layoutManager = layoutManager

        dialog = SpotsDialog.Builder().setCancelable(false).setContext(this).build()

        getAllMovieList()
    }

    private fun getAllMovieList() {
        dialog.show()

        mService.run {
            getMovieList().enqueue(object : retrofit2.Callback<MutableList<Movie>> {
                override fun onFailure(call: Call<MutableList<Movie>>, t: Throwable) {
                    TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
                }

                override fun onResponse(
                    call: Call<MutableList<Movie>>,
                    response: Response<MutableList<Movie>>
                ) {
                    adapter = MyMovieAdapter(baseContext,response.body() as MutableList<Movie>)
                    adapter.notifyDataSetChanged()
                    recyclerMovieList.adapter = adapter

                    dialog.dismiss()
                }
            })
        }
    }
}
