package teeyare.github.io.githubrepos.data

import teeyare.github.io.githubrepos.domain.GithubRepo

class GithubRepoRepository(
    val persistenceSource: GithubRepoPersistenceSource,
    val remoteSource: GithubRepoRemoteSource
) {
    fun getGithubRepositories(): List<GithubRepo> = persistenceSource.getGithubRepositories()
}