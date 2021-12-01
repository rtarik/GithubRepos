package teeyare.github.io.githubrepos.presentation

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import dagger.hilt.android.AndroidEntryPoint
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.android.synthetic.main.github_repo_list_fragment.*
import teeyare.github.io.githubrepos.R
import javax.inject.Inject

@AndroidEntryPoint
class GithubRepoListFragment : Fragment() {

    companion object {
        fun newInstance() = GithubRepoListFragment()
    }

    private val viewModel: GithubRepoListViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.github_repo_list_fragment, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        recyclerView.layoutManager = LinearLayoutManager(context)
        recyclerView.setHasFixedSize(true)
        recyclerView.addItemDecoration(
            DividerItemDecoration(
                context,
                DividerItemDecoration.VERTICAL
            )
        )
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
