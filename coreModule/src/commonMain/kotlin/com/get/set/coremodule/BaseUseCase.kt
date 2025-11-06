package com.get.set.coremodule

abstract class BaseUseCase<R, P> {
    abstract suspend fun execute(params: P): R
}
