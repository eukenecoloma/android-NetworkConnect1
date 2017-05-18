/*
 * Copyright (C) 2016 The Android Open Source Project
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

package com.example.android.networkconnect;

import android.net.NetworkInfo;
import android.support.annotation.IntDef;

/**
 * Sample interface containing bare minimum methods needed for an asynchronous task
 * to update the UI Context.
 * Interfaz de ejemplo que contiene métodos mínimos necesarios para una tarea asincrónica
 * Para actualizar el contexto de la interfaz de usuario.
 */

public interface DownloadCallback {
    interface Progress {
        int ERROR = -1;
        int CONNECT_SUCCESS = 0;
        int GET_INPUT_STREAM_SUCCESS = 1;
        int PROCESS_INPUT_STREAM_IN_PROGRESS = 2;
        int PROCESS_INPUT_STREAM_SUCCESS = 3;
    }

    /**
     * Indicates that the callback handler needs to update its appearance or information based on
     * the result of the task. Expected to be called from the main thread.
     *
     * Indica que el manejador de devolución de llamada debe actualizar su apariencia o información basada en
     * El resultado de la tarea. Se espera que se llame desde el hilo principal.
     */
    void updateFromDownload(String result);

    /**
     * Get the device's active network status in the form of a NetworkInfo object.
     *
     * Obtener el estado activo de la red del dispositivo en forma de un objeto NetworkInfo.
     */
    NetworkInfo getActiveNetworkInfo();

    /**
     * Indicate to callback handler any progress update.
     * @param progressCode must be one of the constants defined in DownloadCallback.Progress.
     * @param percentComplete must be 0-100.
     *
     * Indicar al manejador de devolución de llamada cualquier actualización de progreso.
     * @param progressCode debe ser una de las constantes definidas en DownloadCallback.Progress.
     * @param percentComplete debe ser 0-100.
     */
    void onProgressUpdate(int progressCode, int percentComplete);

    /**
     * Indicates that the download operation has finished. This method is called even if the
     * download hasn't completed successfully.
     * Indica que la operación de descarga ha finalizado. Este método se llama incluso si el
     * La descarga no se ha completado correctamente.
     */
    void finishDownloading();

}
