/*
 * Copyright 2015 Anton Tananaev (anton.tananaev@gmail.com)
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
package org.traccar.manager;

import org.traccar.manager.model.Command;
import org.traccar.manager.model.CommandType;
import org.traccar.manager.model.Device;
import org.traccar.manager.model.User;

import java.util.List;

import retrofit2.Call;
import retrofit2.Response;
import retrofit2.http.Body;
import retrofit2.http.DELETE;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.PUT;
import retrofit2.http.Path;
import retrofit2.http.Query;

public interface WebService {

    @FormUrlEncoded
    @POST("/api/session")
    Call<User> addSession(@Field("email") String email, @Field("password") String password);

    @GET("/api/devices")
    Call<List<Device>> getDevices();

    @POST("/api/devices")
    Call<Device> addDevice(@Body Device device);

    @PUT("/api/devices/{id}")
    Call<Device> updateDevice(@Path("id") long id, @Body Device device);

    @DELETE("/api/devices/{id}")
    Call<Void> removeDevice(@Path("id") long id);

    @GET("/api/commandtypes")
    Call<List<CommandType>> getCommandTypes(@Query("deviceId") long deviceId);

    @POST("/api/commands")
    Call<Command> sendCommand(@Body Command command);
}
