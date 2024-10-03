package com.cloud.gentebuenagente.gateway_server;

import reactor.core.publisher.Mono;

import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ServerWebExchange;
import org.springframework.web.server.WebFilter;
import org.springframework.web.server.WebFilterChain;
import org.springframework.web.util.UriComponents;
import org.springframework.web.util.UriComponentsBuilder;

/**
 * This filter ensures that the loopback IP <code>127.0.0.1</code> is used to access the
 * application so that the sample works correctly, due to the fact that redirect URIs with
 * "localhost" are rejected by the Spring Authorization Server, because the OAuth 2.1
 * draft specification states:
 *
 * <pre>
 *     While redirect URIs using localhost (i.e.,
 *     "http://localhost:{port}/{path}") function similarly to loopback IP
 *     redirects described in Section 10.3.3, the use of "localhost" is NOT
 *     RECOMMENDED.
 * </pre>
 *
 * @author Steve Riesenberg
 * @see <a href=
 * "https://tools.ietf.org/html/draft-ietf-oauth-v2-1-01#section-9.7.1">Loopback Redirect
 * Considerations in Native Apps</a>
 */
@Component
@Order(Ordered.HIGHEST_PRECEDENCE)
public class LoopbackIpRedirectWebFilter implements WebFilter {

	@Override
	public Mono<Void> filter(ServerWebExchange exchange, WebFilterChain chain) {
		String host = exchange.getRequest().getURI().getHost();
		if (host != null && host.equals("localhost")) {
			UriComponents uri = UriComponentsBuilder.fromHttpRequest(exchange.getRequest()).host("127.0.0.1").build();
			exchange.getResponse().setStatusCode(HttpStatus.PERMANENT_REDIRECT);
			exchange.getResponse().getHeaders().setLocation(uri.toUri());
			return Mono.empty();
		}
		return chain.filter(exchange);
	}

}
