package teeyare.github.io.githubrepos.framework

import teeyare.github.io.githubrepos.data.GithubRepoPersistenceSource
import teeyare.github.io.githubrepos.domain.GithubRepo
import javax.inject.Inject

class InMemoryPersistenceSource @Inject constructor(): GithubRepoPersistenceSource {
    private var repos: MutableList<GithubRepo> = mutableListOf()

    override suspend fun getGithubRepositories(): List<GithubRepo> = repos

    override suspend fun addGithubRepositories(repositories: List<GithubRepo>) {
        repos.plusAssign(repositories)
    }
}