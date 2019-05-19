package teeyare.github.io.githubrepos.model

import androidx.lifecycle.LiveData
import retrofit2.http.GET

interface GithubRepoApi {
    @GET("")
    fun getRepoList(): LiveData<List<GithubRepo>>

}

class GithubRepo
