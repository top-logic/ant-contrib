/*
 * Copyright (c) 2001-2004 Ant-Contrib project.  All rights reserved.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package net.sf.antcontrib.util;

/**
 * @author <a href="mailto:mattinger@yahoo.com">Matthew Inger</a>
 */
public class ThreadPoolThread extends Thread {
    /**
     * Field pool.
     */
    private final ThreadPool pool;

    /**
     * Field runnable.
     */
    private Runnable runnable;

    /**
     * Constructor for ThreadPoolThread.
     *
     * @param pool ThreadPool
     */
    public ThreadPoolThread(ThreadPool pool) {
        super();
        this.pool = pool;
    }

    /**
     * Method setRunnable.
     *
     * @param runnable Runnable
     */
    public void setRunnable(Runnable runnable) {
        this.runnable = runnable;
    }

    /**
     * Method run.
     *
     * @see java.lang.Runnable#run()
     */
    public void run() {
        try {
            if (runnable != null) {
                runnable.run();
            }
        } finally {
            try {
                pool.returnThread(this);
            } catch (Exception e) {
                // gulp
            }
        }
    }
}
