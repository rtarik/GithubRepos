package teeyare.github.io.githubrepos.framework

import teeyare.github.io.githubrepos.data.GithubRepoPersistenceSource
import teeyare.github.io.githubrepos.domain.GithubRepo

class InMemoryPersistenceSource: GithubRepoPersistenceSource {
    private var repos: MutableList<GithubRepo> = mutableListOf()

    override suspend fun getGithubRepositories(): List<GithubRepo> = repos

    override suspend fun addGithubRepositories(repositories: List<GithubRepo>) {
        repos.plusAssign(repositories)
    }
}