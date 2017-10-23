package com.jjl.accounttest.domain.usecase

import kotlinx.coroutines.experimental.Deferred

/**
 * Created by jjimeno on 22/10/17.
 */
interface UseCase<in I, out O> {
    fun perform(input: I?): Deferred<O>
}