package teeyare.github.io.githubrepos.presentation

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import teeyare.github.io.githubrepos.R
import teeyare.github.io.githubrepos.domain.GithubRepo

class GithubRepoListAdapter(var repos: List<GithubRepo>) : RecyclerView.Adapter<GithubRepoListAdapter.ViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_github_repo, parent, false)
        return ViewHolder(view)
    }

    override fun getItemCount(): Int = repos.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(repos[position])
    }

    class ViewHolder(view: View): RecyclerView.ViewHolder(view) {
        private val repoNameTextView: TextView = view.findViewById(R.id.repoNameText)
        private val repoDescriptionTextView: TextView = view.findViewById(R.id.repoDescriptionText)
        private val ownerUsernameTextView: TextView = view.findViewById(R.id.ownerUsernameText)
        private val starsTextView: TextView = view.findViewById(R.id.starsText)

        fun bind(repo: GithubRepo) {
            repoNameTextView.text = repo.name
            repoDescriptionTextView.text = repo.description
            ownerUsernameTextView.text = repo.ownerUsername
            starsTextView.text = repo.stars.toString()
        }
    }
}