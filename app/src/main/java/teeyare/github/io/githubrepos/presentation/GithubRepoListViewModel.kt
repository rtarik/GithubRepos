package teeyare.github.io.githubrepos.presentation

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import teeyare.github.io.githubrepos.domain.GetReposUseCase
import teeyare.github.io.githubrepos.domain.GithubRepo
import teeyare.github.io.githubrepos.domain.updateOnSuccess
import javax.inject.Inject

@HiltViewModel
class GithubRepoListViewModel @Inject constructor(private val useCase: GetReposUseCase) :
    ViewModel() {

    private val _showLoading = MutableLiveData<Boolean>()
    val showLoading: LiveData<Boolean> = _showLoading
    private val _showResult = MutableLiveData<List<GithubRepo>>()
    val showResult: LiveData<List<GithubRepo>> = _showResult

    fun init() {
        _showLoading.value = true
        viewModelScope.launch {
            useCase(Unit).updateOnSuccess(_showResult)
            _showLoading.value = false
        }
    }
}