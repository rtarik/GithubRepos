package teeyare.github.io.githubrepos.framework

import teeyare.github.io.githubrepos.data.GithubRepoRemoteSource
import teeyare.github.io.githubrepos.domain.GithubRepo
import teeyare.github.io.githubrepos.framework.model.GithubRepoResponseList
import javax.inject.Inject

class RetrofitRemoteSource @Inject constructor(
    private val service: GithubRepoService
) : GithubRepoRemoteSource {
    override suspend fun fetchGithubRepositories(): List<GithubRepo> {
        val response = service.getRepoList(
            query = "tetris+language:assembly",
            sortBy = "stars",
            orderBy = "desc"
        )
        return mapRetrofitToDomainModel(response)
    }

    private fun mapRetrofitToDomainModel(response: GithubRepoResponseList) =
        response.items.orEmpty().map { repo ->
            GithubRepo(
                repo.name.orEmpty(),
                repo.description.orEmpty(),
                repo.stars ?: 0,
                repo.owner?.login.orEmpty(),
                repo.owner?.avatarUrl.orEmpty()
            )
        }
}