package me.cristalliz.ash.githubjobs.Extensions

import com.jakewharton.retrofit2.adapter.rxjava2.HttpException
import io.reactivex.Observable
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import java.io.IOException
import java.lang.Exception

data class Result<out T>(
    val data: T?,
    val error: Throwable?
) {
    fun onSuccess(closure: (T) -> Unit): Result<T> {
        if (data != null) {
            closure(data)
        }

        return this
    }

    fun onFailure(closure: (Throwable) -> Unit): Result<T> {
        if (error != null) {
            closure(error)
        }

        return this
    }
}

fun <T> Observable<T>.background(): Observable<T> = subscribeOn(Schedulers.io())
    .observeOn(AndroidSchedulers.mainThread())

fun <T> Observable<T>.toResult(): Observable<Result<T>> {
    return this.map { it.asResult() }
        .onErrorReturn {
            if (it is HttpException || it is IOException) {
                return@onErrorReturn it.asErrorResult<T>()
            } else {
                throw it
            }
        }
}

fun <T> T.asResult(): Result<T> {
    return Result(data = this, error = null)
}

fun <T> Throwable.asErrorResult(): Result<T> {
    return Result(data = null, error = this)
}

fun <T> T?.unwrap(): T {
    if (this != null) {
        return this
    }

    throw Exception("Value isn't exist")
}