package me.ninetyeightping.pinglib.cache

abstract class Cache<A, B> {

    var cacheMap = hashMapOf<A, B>()


    abstract fun AbyB(b: B) : A?

    abstract fun BbyA(a: A) : B?




}