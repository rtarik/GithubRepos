package teeyare.github.io.githubrepos.presentation

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.github_repo_list_fragment.*
import teeyare.github.io.githubrepos.R


class GithubRepoListFragment : Fragment() {

    companion object {
        fun newInstance() = GithubRepoListFragment()
    }

    private lateinit var viewModel: GithubRepoListViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.github_repo_list_fragment, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProviders.of(this).get(GithubRepoListViewModel::class.java)

        recyclerView.layoutManager = LinearLayoutManager(context)
        recyclerView.setHasFixedSize(true)
        recyclerView.addItemDecoration(DividerItemDecoration(context, DividerItemDecoration.VERTICAL))
        viewModel.showLoading.observe(this, Observer { show ->
            progressBar.visibility = if (show) View.VISIBLE else View.GONE
        })
        viewModel.showResult.observe(this, Observer { result ->
            progressBar.visibility = View.GONE
            recyclerView.adapter = GithubRepoListAdapter(result)
        })
        viewModel.init()
    }

}
