package com.example.jetpack_test1

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.jetpack_test1.network.UserApi
import kotlinx.coroutines.launch
import java.io.IOException

sealed interface UserUiState {
    data class Success(val users: String) : UserUiState
    object Error : UserUiState
    object Loading : UserUiState
}

class UsersViewModel : ViewModel() {
    /** The mutable State that stores the status of the most recent request */
    var usersUiState: UserUiState by mutableStateOf(UserUiState.Loading)
        private set

    /**
     * Call getUsers() on init so we can display status immediately.
     */
    init {
        getUsers()
    }

    /**
     * Gets Users information from the Users API Retrofit service and updates the
     * [Users] [List] [MutableList].
     */
    fun getUsers() {
        viewModelScope.launch {
            try {
                val listResult = UserApi.retrofitService.getUsers()
                usersUiState = UserUiState.Success(listResult)
            } catch (e: IOException) {
                usersUiState = UserUiState.Error
            }
        }
    }
}
