package teeyare.github.io.githubrepos.model

import androidx.lifecycle.LiveData

interface GithubRepoRepository {
    fun getRepoList(): LiveData<List<GithubRepo>>
}