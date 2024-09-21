package com.org.litness.data.repository

import com.org.litness.base.MResult
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow

class UserRepository constructor() {

    fun signUp(email: String, password: String): Flow<MResult<String>> {
        return flow {

        }
    }

    fun signIn(email: String, password: String): Flow<MResult<String>> {
        return flow {

        }
    }
}