package teeyare.github.io.githubrepos.framework

import androidx.lifecycle.LiveData
import retrofit2.http.GET
import teeyare.github.io.githubrepos.domain.GithubRepo

interface GithubRepoApi {
    @GET("")
    fun getRepoList(): LiveData<List<GithubRepo>>

}
