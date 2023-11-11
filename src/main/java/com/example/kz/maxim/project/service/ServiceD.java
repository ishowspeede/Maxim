package com.example.kz.maxim.project.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.zip.DataFormatException;

@Service
@Slf4j
public class ServiceD {
    public ServiceC serviceC;

    @Value("example4.property")
    private String value4;

    public ServiceD(ServiceC serviceC) {
        this.serviceC = serviceC;
    }

    public static String getMessageFromDbClassD() {
        return "This message selected from database ClassD";
    }

    public static String throwError() throws DataFormatException {
        throw new DataFormatException("This message selected from database ClassD");
    }

    public void printMessage()  {
        System.out.println("Print from B class: " + ServiceC.getMessageFromDbClassC());
        System.out.println("Print from C class: " + ServiceD.getMessageFromDbClassD());
        try {
            System.out.println("throwError from D class: " + ServiceD.throwError());
        } catch (DataFormatException e) {          log.error("Threw");
        }
    }
    public void methodD() {
        serviceC.methodC();
    }
}
