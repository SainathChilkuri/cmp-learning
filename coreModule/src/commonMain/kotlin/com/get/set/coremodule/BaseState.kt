package com.get.set.coremodule

abstract class BaseState(dataState: DataState = DataState.INITIAL) {
}


enum class DataState {
    SUCCESS,
    FAILED,
    LOADING,
    INITIAL
}