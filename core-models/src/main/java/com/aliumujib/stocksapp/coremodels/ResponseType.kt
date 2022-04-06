package com.aliumujib.stocksapp.coremodels

public enum class ResponseType(public val value: Int) {
    VALID(0), EMPTY(1), FAILURE(2);

    public companion object {
        public fun fromValue(value: Int): ResponseType {
           return values().firstOrNull {
                it.value == value
            } ?: VALID
        }
    }
}