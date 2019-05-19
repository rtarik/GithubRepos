package teeyare.github.io.githubrepos.presentation

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.github_repo_list_fragment.*
import teeyare.github.io.githubrepos.R
import teeyare.github.io.githubrepos.domain.GithubRepo


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
        recyclerView.adapter = GithubRepoListAdapter(
            (1..20).map {
                GithubRepo(
                    "tensorflow",
                    "Computation using data flow graphs for scalable machine learning",
                    it * 100,
                    "tensorflow",
                    ""
                )
            }
        )
    }

}
