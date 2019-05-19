package teeyare.github.io.githubrepos.model

import androidx.lifecycle.LiveData

class GithubRepoDownloader(private val githubRepoApi: GithubRepoApi): GithubRepoRepository {
    override fun getRepoList(): LiveData<List<GithubRepo>> {
        return githubRepoApi.getRepoList()
    }
}