package teeyare.github.io.githubrepos.framework

import kotlinx.coroutines.delay
import teeyare.github.io.githubrepos.data.GithubRepoRemoteSource
import teeyare.github.io.githubrepos.domain.GithubRepo

class FakeRemoteSource : GithubRepoRemoteSource {
    override suspend fun fetchGithubRepositories(): List<GithubRepo> {
            delay(5000)
            return (1..50).map {
                GithubRepo(
                    "tensorflow",
                    "A really awesome machine learning library",
                    it * 100,
                    "tensorflow",
                    ""
                )
            }
    }
}