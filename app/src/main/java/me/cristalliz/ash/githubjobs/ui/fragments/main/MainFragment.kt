package me.cristalliz.ash.githubjobs.ui.fragments.main

import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.jakewharton.rxbinding2.widget.RxSearchView
import dagger.android.support.DaggerFragment
import io.reactivex.android.schedulers.AndroidSchedulers
import kotlinx.android.synthetic.main.main_fragment.*
import me.cristalliz.ash.githubjobs.Extensions.background
import me.cristalliz.ash.githubjobs.R
import me.cristalliz.ash.githubjobs.ui.fragments.positiondetails.PositionDetailsFragment
import java.util.concurrent.TimeUnit
import javax.inject.Inject


class MainFragment : DaggerFragment() {
    companion object {
        fun newInstance() = MainFragment()

        const val searchTimeOut: Long = 500
    }

    @Inject
    lateinit var viewModel: MainViewModel

    @Inject
    lateinit var adapter: MainFragmentAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ) = inflater.inflate(R.layout.main_fragment, container, false)

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        recyclerView.adapter = adapter
        recyclerView.layoutManager = LinearLayoutManager(activity)
        recyclerView.isNestedScrollingEnabled = true

        searchView.setOnClickListener {
            searchView.onActionViewExpanded()
        }

        RxSearchView.queryTextChanges(searchView)
            .debounce(searchTimeOut, TimeUnit.MILLISECONDS)
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe {
                progressBar.visibility = View.VISIBLE
                viewModel.getPositions(it.toString()).background().subscribe({
                    progressBar.visibility = View.GONE

                    val filtered = it.filter {
                        it.company_logo != null
                    }

                    adapter.run {
                        items.clear()
                        items.addAll(filtered)
                        notifyDataSetChanged()
                    }
                }, {
                    Log.d("NetworkError", it.toString())
                })
            }

        adapter.onItemClickListener = View.OnClickListener {
            val position = recyclerView.getChildAdapterPosition(it)
            val item= adapter.items[position]

            viewModel.setDetailedPosition(item)

            val transaction = activity!!.supportFragmentManager.beginTransaction()

            transaction.replace(R.id.container, PositionDetailsFragment.newInstance())
            transaction.addToBackStack(null)
            transaction.commit()

            Log.d("ClickToItem", position.toString())
        }
    }
}