package org.demo.cmp.project.core

abstract class BaseState(dataState: DataState = DataState.INITIAL) {
}


enum class DataState {
    SUCCESS,
    FAILED,
    LOADING,
    INITIAL
}