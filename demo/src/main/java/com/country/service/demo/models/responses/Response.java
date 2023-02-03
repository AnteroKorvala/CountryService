package com.country.service.demo.models.responses;

public record Response<T>(Boolean error, String msg, T data) { }
