package teeyare.github.io.githubrepos.data

import teeyare.github.io.githubrepos.domain.GithubRepo

interface GithubRepoPersistenceSource {
    fun getGithubRepositories(): List<GithubRepo>
    fun addGithubRepositories(repositories: List<GithubRepo>)
}

interface GithubRepoRemoteSource {
    fun fetchGithubRepositories(): List<GithubRepo>
}