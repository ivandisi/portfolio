package it.ivandisiro.portfolio.networking.callback

import it.ivandisiro.portfolio.model.Me

interface ProfileCallback {
    fun onSuccess(profileData: Me?);
    fun onError(code: Int, exception: Throwable?);
}