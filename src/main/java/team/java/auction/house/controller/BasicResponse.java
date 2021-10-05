package team.java.auction.house.controller;

import team.java.auction.house.dto.ErrorMessage;
import team.java.auction.house.dto.Response;

import java.util.List;

public abstract class BasicResponse {

    public <T> Response<T> createNoDataResponse() {
        return Response.<T>builder().status(Response.Status.NO_DATA).build();
    }

    public <T> Response<T> createOkResponse(T data) {
        return Response.<T>builder().status(Response.Status.OK).data(data).build();
    }

    public <T> Response<List<T>> createOkResponse(List<T> data) {
        return Response.<List<T>>builder().status(Response.Status.OK).data(data).build();
    }

    public <T> Response<T> createOkResponse() {
        return Response.<T>builder().status(Response.Status.OK).build();
    }

    public <T> Response<T> createErrorResponse(ErrorMessage errorMessage) {
        return Response.<T>builder().status(Response.Status.ERROR).error(errorMessage).build();
    }
}