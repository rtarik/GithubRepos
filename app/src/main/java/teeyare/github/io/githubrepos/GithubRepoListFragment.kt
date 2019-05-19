package teeyare.github.io.githubrepos

import androidx.lifecycle.ViewModelProviders
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup


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
    }

}
