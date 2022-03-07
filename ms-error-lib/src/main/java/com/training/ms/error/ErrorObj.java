package com.training.ms.error;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Supplier;

public class ErrorObj {

    private List<ErrorObj> subErrors;
    private String         boundedcontext;
    private String         microservice;
    private String         desc;
    private Integer        errorCode;

    public ErrorObj() {
    }

    public ErrorObj(final List<ErrorObj> subErrorsParam,
                    final String boundedcontextParam,
                    final String microserviceParam,
                    final String descParam,
                    final Integer errorCodeParam) {
        super();
        this.subErrors = subErrorsParam;
        this.boundedcontext = boundedcontextParam;
        this.microservice = microserviceParam;
        this.desc = descParam;
        this.errorCode = errorCodeParam;
    }

    public ErrorObj(final String boundedcontextParam,
                    final String microserviceParam,
                    final String descParam,
                    final Integer errorCodeParam) {
        super();
        this.boundedcontext = boundedcontextParam;
        this.microservice = microserviceParam;
        this.desc = descParam;
        this.errorCode = errorCodeParam;
    }

    public static ErrorObj create() {
        return new ErrorObj();
    }

    public static void main(final String[] args) {
        ErrorObj errorObjLoc = new ErrorObj();
        errorObjLoc.setDesc("xyz");
        ErrorObj errorObjLoc2 = new ErrorObj("11",
                                             "ms",
                                             "xxxyyy",
                                             1002);

        ErrorObj errorObjLoc3 = ErrorObj.create()
                                        .setBoundedcontext("11")
                                        .setMicroservice("ms")
                                        .setDesc("xxxyyy")
                                        .setErrorCode(1002)
                                        .addSuberror(ErrorObj.create()
                                                             .setBoundedcontext("12")
                                                             .setMicroservice("ms1")
                                                             .setDesc("xxxyyy1")
                                                             .setErrorCode(1003))
                                        .addSuberror(ErrorObj.create()
                                                             .setBoundedcontext("13")
                                                             .setMicroservice("ms2")
                                                             .setDesc("xxxyyy3")
                                                             .setErrorCode(1004));
        Supplier<ErrorObj> supplierLoc = () -> ErrorObj.create()
                                                       .setMicroservice("ms")
                                                       .setBoundedcontext("11")
                                                       .setDesc("xxxyyy")
                                                       .setErrorCode(1002)
                                                       .addSuberror(ErrorObj.create()
                                                                            .setBoundedcontext("12")
                                                                            .setMicroservice("ms1")
                                                                            .setDesc("xxxyyy1")
                                                                            .setErrorCode(1003))
                                                       .addSuberror(ErrorObj.create()
                                                                            .setBoundedcontext("13")
                                                                            .setMicroservice("ms2")
                                                                            .setDesc("xxxyyy3")
                                                                            .setErrorCode(1004));
        Supplier<ErrorObj> supplierLoc2 = () -> {
            ErrorObj errorObjLoc4 = new ErrorObj();
            errorObjLoc4.setDesc("xyz");
            return errorObjLoc4;
        };
        long delta = System.currentTimeMillis();
        for (int iLoc = 0; iLoc < 10_000_000; iLoc++) {
            processStr("osman" + errorObjLoc.getDesc(),
                       5);
        }
        System.out.println("Delta1 : " + (System.currentTimeMillis() - delta));

        delta = System.currentTimeMillis();
        for (int iLoc = 0; iLoc < 10_000_000; iLoc++) {
            process(() -> "osman" + errorObjLoc.getDesc(),
                    5);
        }
        System.out.println("Delta2 : " + (System.currentTimeMillis() - delta));

    }

    public static void processStr(final String str,
                                  final int test) {
        if (test > 10) {
            System.out.println(str);
        }
    }

    public static void process(final Supplier<String> strSup,
                               final int test) {
        if (test > 10) {
            System.out.println(strSup.get());
        }
    }


    //    public Iterator<ErrorObj> iterator() {
    //        return this.subErrors.iterator();
    //    }


    public ErrorObj addSuberror(final ErrorObj errorObjParam) {
        if (this.subErrors == null) {
            this.subErrors = new ArrayList<>();
        }
        this.subErrors.add(errorObjParam);
        return this;
    }

    public List<ErrorObj> getSubErrors() {
        return this.subErrors;
    }

    public void setSubErrors(final List<ErrorObj> subErrorsParam) {
        this.subErrors = subErrorsParam;
    }

    public String getBoundedcontext() {
        return this.boundedcontext;
    }

    public ErrorObj setBoundedcontext(final String boundedcontextParam) {
        this.boundedcontext = boundedcontextParam;
        return this;
    }

    public String getMicroservice() {
        return this.microservice;
    }

    public ErrorObj setMicroservice(final String microserviceParam) {
        this.microservice = microserviceParam;
        return this;
    }

    public String getDesc() {
        return this.desc;
    }

    public ErrorObj setDesc(final String descParam) {
        this.desc = descParam;
        return this;
    }

    public Integer getErrorCode() {
        return this.errorCode;
    }

    public ErrorObj setErrorCode(final Integer errorCodeParam) {
        this.errorCode = errorCodeParam;
        return this;
    }

}
