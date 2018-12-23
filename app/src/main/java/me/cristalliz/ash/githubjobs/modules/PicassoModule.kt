package me.cristalliz.ash.githubjobs.modules

import android.content.Context
import com.squareup.picasso.OkHttp3Downloader
import com.squareup.picasso.Picasso
import dagger.Module
import dagger.Provides
import me.cristalliz.ash.githubjobs.Services.ServiceModule

@Module(includes = arrayOf(ServiceModule::class, ContextModule::class))
class PicassoModule {
    @Provides
    fun picasso(context: Context, okHttp3Downloader: OkHttp3Downloader): Picasso {
        return Picasso.Builder(context)
            .downloader(okHttp3Downloader)
            .build()
    }

}