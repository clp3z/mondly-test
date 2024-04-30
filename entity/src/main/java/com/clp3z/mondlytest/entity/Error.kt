package com.clp3z.mondlytest.entity

interface Error {

    object IO : Error

    class Network(val code: Int) : Error

    class Unknown(val message: String) : Error
}
