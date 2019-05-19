package teeyare.github.io.githubrepos.data

import teeyare.github.io.githubrepos.domain.GithubRepo

class GithubRepoRepository(
    private val persistenceSource: GithubRepoPersistenceSource,
    private val remoteSource: GithubRepoRemoteSource
) {
    suspend fun getGithubRepositories(): List<GithubRepo> {
        val repos = remoteSource.fetchGithubRepositories()
        persistenceSource.addGithubRepositories(repos)
        return persistenceSource.getGithubRepositories()
    }
}