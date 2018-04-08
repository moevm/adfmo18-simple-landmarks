package com.breezesoftware.stayfit.core

import java.net.URL

/**
 * This file is part of Test Kotlin Application
 *
 * You can do everything with the code and files
 *
 * Created by popof on 26.03.2018.
 */

class AppConfig {
    val SERVER_PROTOCOL = "http"
    val SERVER_HOST = "breezegames.cloudapp.net"
    val SERVER_PORT = 27015

    val SERVER_URL_STRING = "$SERVER_PROTOCOL://$SERVER_HOST:$SERVER_PORT"
    val SERVER_URL = URL(SERVER_URL_STRING)
}