package teeyare.github.io.githubrepos.data

import teeyare.github.io.githubrepos.domain.GithubRepo
import javax.inject.Inject

class GithubRepoRepository @Inject constructor(
    private val persistenceSource: GithubRepoPersistenceSource,
    private val remoteSource: GithubRepoRemoteSource
) {
    suspend fun getGithubRepositories(): List<GithubRepo> {
        val repos = remoteSource.fetchGithubRepositories()
        persistenceSource.addGithubRepositories(repos)
        return persistenceSource.getGithubRepositories()
    }
}