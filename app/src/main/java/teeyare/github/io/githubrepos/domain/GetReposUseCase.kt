package teeyare.github.io.githubrepos.domain

import kotlinx.coroutines.*
import teeyare.github.io.githubrepos.data.GithubRepoRepository

class GetReposUseCase(private val repository: GithubRepoRepository) {

    fun getReposAsync(): Deferred<List<GithubRepo>> = GlobalScope.async(Dispatchers.IO) {
        repository.getGithubRepositories()
    }
}