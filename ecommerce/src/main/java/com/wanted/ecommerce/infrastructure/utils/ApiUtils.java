package com.wanted.ecommerce.infrastructure.utils;

/**
 * apiUtil 설정
 *
 * @param <T>
 */
public class ApiUtils<T> {

    private static final String PROCESS_SUCESS = "요청이 성공적으로 수행하였습니다.";

    private ApiUtils() {
        throw new AssertionError();
    }

    public static <T> ApiResult<T> success(T data) {
        return new ApiResult<>(true, data, PROCESS_SUCESS);
    }

    public static class ApiResult<T> {

        private Boolean success;
        private T data;
        private String message;

        public ApiResult(Boolean success, T data, String message) {
            this.success = success;
            this.data = data;
            this.message = message;
        }

    }

}
