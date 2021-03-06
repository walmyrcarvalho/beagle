/*
 * Copyright 2020 ZUP IT SERVICOS EM TECNOLOGIA E INOVACAO SA
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

package br.com.zup.beagle.widget.action

import br.com.zup.beagle.widget.context.Bind

data class SendRequest(
    val url: Bind<String>,
    val method: Bind<RequestActionMethod> = Bind.Value(RequestActionMethod.GET),
    val headers: Bind<Map<String, String>>? = null,
    val data: Any? = null,
    val onSuccess: List<Action>? = null,
    val onError: List<Action>? = null,
    val onFinish: List<Action>? = null
) : Action {
    constructor(
        url: String,
        method: RequestActionMethod = RequestActionMethod.GET,
        headers: Map<String, String>? = null,
        data: Any? = null,
        onSuccess: List<Action>? = null,
        onError: List<Action>? = null,
        onFinish: List<Action>? = null
    ) : this(
        Bind.Value(url),
        Bind.Value(method),
        if (headers != null) Bind.Value(headers) else headers,
        data,
        onSuccess,
        onError,
        onFinish
    )
}

@SuppressWarnings("UNUSED_PARAMETER")
enum class RequestActionMethod {
    GET,
    POST,
    PUT,
    DELETE,
    HEAD,
    PATCH
}
