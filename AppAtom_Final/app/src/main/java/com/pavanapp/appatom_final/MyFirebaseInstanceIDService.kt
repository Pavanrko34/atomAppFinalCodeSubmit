package com.pavanapp.appatom_final

import android.util.Log
import com.google.firebase.iid.FirebaseInstanceId
import com.google.firebase.iid.FirebaseInstanceIdService
const val TAG="MyFireBase"
class MyFirebaseInstanceIDService : FirebaseInstanceIdService(){
    override fun onTokenRefresh() {
        val refreshedToken= FirebaseInstanceId.getInstance().token
        Log.d(TAG, "refreshed token:"+refreshedToken!!)
    }
}