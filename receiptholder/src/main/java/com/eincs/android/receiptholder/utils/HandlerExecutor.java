package com.eincs.android.receiptholder.utils;

import java.util.concurrent.Executor;

import android.os.Handler;

/**
 * 안드로이드의 {@link Handler}에서 {@link Runnable}을 실행시켜주는 {@link Executor} 클래스
 */
public class HandlerExecutor implements Executor {

    private Handler mHandler;

    public HandlerExecutor(Handler handler) {
        mHandler = handler;
    }

    @Override
    public void execute(Runnable command) {
        mHandler.post(command);
    }
}