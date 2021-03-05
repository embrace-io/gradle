/*
 * Copyright 2021 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package org.gradle.embracelogger;

import org.gradle.api.logging.Logger;
import org.gradle.api.logging.Logging;

public class EmbraceLogger {

    private final static Logger LOGGER = Logging.getLogger(EmbraceLogger.class);

    public static void logDebug(String msg) {
        log(Severity.DEBUG, msg, null);
    }

    public static void logInfo(String msg) {
        log(Severity.INFO, msg, null);
    }

    public static void logWarning(String msg) {
        log(Severity.WARNING, msg, null);
    }

    public static void logError(String msg) {
        log(Severity.ERROR, msg, null);
    }

    public static void log(Severity severity, String msg, Throwable throwable) {
        StringBuilder log = new StringBuilder().append("EMB - ").append(msg);
        switch (severity) {
            case DEBUG:
                LOGGER.debug(log.toString());
                break;
            case INFO:
                LOGGER.info(log.toString());
                break;
            case WARNING:
                LOGGER.warn(log.toString());
                break;
            case ERROR:
                LOGGER.error(log.toString(), throwable);
                break;
            default:
        }
    }

    public enum Severity {
        DEBUG,
        INFO,
        WARNING,
        ERROR,
        NONE
    }
}
