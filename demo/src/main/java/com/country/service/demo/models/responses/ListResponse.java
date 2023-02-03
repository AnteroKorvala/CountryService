package com.country.service.demo.models.responses;

import java.util.List;

public record ListResponse<T>(Boolean error, String msg, List<T> data) { }
