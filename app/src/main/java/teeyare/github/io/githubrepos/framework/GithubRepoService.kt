package teeyare.github.io.githubrepos.framework

import retrofit2.http.GET
import retrofit2.http.Query
import teeyare.github.io.githubrepos.framework.model.GithubRepoResponse
import teeyare.github.io.githubrepos.framework.model.GithubRepoResponseList

interface GithubRepoService {
    @GET("search/repositories")
    suspend fun getRepoList(
        @Query("q") query: String,
        @Query("sort") sortBy: String,
        @Query("order") orderBy: String
    ): GithubRepoResponseList
}
