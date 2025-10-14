package org.demo.cmp.project.core

abstract class BaseUseCase<R, S> {
    abstract fun execute(s: S): R
}
