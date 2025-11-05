package org.demo.cmp.project.core

abstract class BaseUseCase<R, P> {
    abstract suspend fun execute(params: P): R
}
