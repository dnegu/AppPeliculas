package com.dnegu.core.common

interface UseCase<T : Any, R : Any> {

    suspend operator fun invoke(param: T): Result<R>

    suspend operator fun invoke(params: List<T>): Result<List<R>>
}