package com.clp3z.mondlytest.framework.common

import arrow.core.Either
import arrow.core.left
import arrow.core.right
import com.clp3z.mondlytest.entity.Error
import com.clp3z.mondlytest.entity.Error.IO
import com.clp3z.mondlytest.entity.Error.Network
import com.clp3z.mondlytest.entity.Error.Unknown
import retrofit2.HttpException
import java.io.IOException

fun Throwable.toError() = when (this) {
    is IOException -> IO
    is HttpException -> Network(code())
    else -> Unknown(message ?: "Unknown error")
}

inline fun <T> tryCall(function: () -> T): Either<Error, T> = try {
    function().right()
} catch (error: Throwable) {
    error.toError().left()
}
