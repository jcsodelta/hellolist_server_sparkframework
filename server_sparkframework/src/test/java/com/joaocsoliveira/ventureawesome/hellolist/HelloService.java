package com.joaocsoliveira.ventureawesome.hellolist;

import retrofit2.http.*;
import rx.Observable;

/**
 * Created by joaocsoliveira on 04/08/16.
 */
interface HelloService {

    @POST("hello")
    Observable<Hello> say_hello(@Body String name);

}
