package teeyare.github.io.githubrepos.presentation

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.android.synthetic.main.github_repo_list_fragment.*
import teeyare.github.io.githubrepos.R

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

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        recyclerView.layoutManager = LinearLayoutManager(context)
        recyclerView.setHasFixedSize(true)
        recyclerView.addItemDecoration(
            DividerItemDecoration(
                context,
                DividerItemDecoration.VERTICAL
            )
        )
        viewModel.showLoading.observe(this) { show ->
            progressBar.visibility = if (show) View.VISIBLE else View.GONE
        }
        viewModel.showResult.observe(this) { result ->
            recyclerView.adapter = GithubRepoListAdapter(result)
        }
        viewModel.init()
    }

}
