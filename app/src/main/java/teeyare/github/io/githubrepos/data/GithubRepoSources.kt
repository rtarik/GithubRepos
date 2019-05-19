package teeyare.github.io.githubrepos.data

import teeyare.github.io.githubrepos.domain.GithubRepo

interface GithubRepoPersistenceSource {
    suspend fun getGithubRepositories(): List<GithubRepo>
    suspend fun addGithubRepositories(repositories: List<GithubRepo>)
}

interface GithubRepoRemoteSource {
    suspend fun fetchGithubRepositories(): List<GithubRepo>
}