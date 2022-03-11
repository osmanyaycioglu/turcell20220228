package com.training.ms.error;

import java.io.InputStream;

import com.fasterxml.jackson.databind.ObjectMapper;

import feign.Response;
import feign.codec.ErrorDecoder;

public class GeneralErrorDecoder implements ErrorDecoder {

    @Override
    public Exception decode(final String methodKeyParam,
                            final Response responseParam) {
        try {
            if (responseParam.status() != 404) {
                ErrorObj convertErrorObjLoc = this.convertErrorObj(responseParam.body()
                                                                                .asInputStream());
                return new RestException(convertErrorObjLoc);
            } else {
                ErrorObj convertErrorObjLoc = new ErrorObj().setDesc("Not found")
                                                            .setErrorCode(404);
                return new RestException(convertErrorObjLoc);
            }
        } catch (Exception eLoc) {
            return new ErrorDecoder.Default().decode(methodKeyParam,
                                                     responseParam);
        }
    }

    private ErrorObj convertErrorObj(final InputStream bytes) {
        ObjectMapper mapperLoc = new ObjectMapper();
        try {
            return mapperLoc.readValue(bytes,
                                       ErrorObj.class);
        } catch (Exception eLoc) {
            eLoc.printStackTrace();
        }
        return null;

    }


}
