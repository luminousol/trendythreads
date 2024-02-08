package com.trendythreads.trendythreadsweb.global.uri;

import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;

public class UriCreator {

    // 새로운 URI를 만드는 createUri 메서드
    public static URI createUri(String defaultUri, Long resourceId) {
        return UriComponentsBuilder
                .newInstance()
                .path(defaultUri + "/{resourceId}")
                .buildAndExpand(resourceId)
                .toUri();
    }
}
