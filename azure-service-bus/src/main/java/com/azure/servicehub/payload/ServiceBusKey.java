package com.azure.servicehub.payload;


import lombok.Getter;
import lombok.RequiredArgsConstructor;


@Getter
@RequiredArgsConstructor
public class ServiceBusKey {
    private final String host;
    private final String sharedAccessKeyName;
    private final String sharedAccessKey;

}
