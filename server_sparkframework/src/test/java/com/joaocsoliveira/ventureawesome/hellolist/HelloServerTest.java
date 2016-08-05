package com.joaocsoliveira.ventureawesome.hellolist;

import org.junit.*;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;

/**
 * Created by joaocsoliveira on 04/08/16.
 */
public class HelloServerTest {

    private HelloServer helloServer;
    private HelloService helloService;

    @Before
    public void prepareServer(){
        helloServer = new HelloServer();
        helloServer.start();
    }

    @Before
    public void prepareClient(){
        Retrofit retrofit = new Retrofit.Builder()
                .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                .addConverterFactory(GsonConverterFactory.create())
                .baseUrl("http://127.0.0.1:4567")
                .build();

        helloService = retrofit.create(HelloService.class);

    }

    @After
    public void stopServer(){
        helloServer.stop();
    }

    @Test
    public void testCommonNames(){
        List<String> names = new ArrayList<>();
        names.add("Joao");
        names.add("Oliveira");

        for (String name: names ) {
            helloService.say_hello(name)
                .subscribe(
                        hello -> {
                            assertNotEquals(hello, null);
                            assertEquals(name, hello.getName());
                            System.out.println(hello);
                        }
                );
        }
    }
}
